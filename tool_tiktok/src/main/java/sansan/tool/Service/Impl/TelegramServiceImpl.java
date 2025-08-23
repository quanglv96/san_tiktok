package sansan.tool.Service.Impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;
import sansan.tool.Config.AppConfig;
import sansan.tool.Config.SanException;
import sansan.tool.DTO.TelegramDTO.ReceiveMessageDTO;
import sansan.tool.DTO.TelegramDTO.SendMessTeleDTO;
import sansan.tool.Entity.TelegramMessage;
import sansan.tool.Repository.TelegramMessageRepository;
import sansan.tool.Service.TelegramService;
import sansan.tool.utils.Constants;
import sansan.tool.utils.KeyConfig;
import sansan.tool.utils.MessageSyntax;
import sansan.tool.utils.RequestType;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class TelegramServiceImpl implements TelegramService {
    private static final Logger LOGGER = LoggerFactory.getLogger(TelegramServiceImpl.class);
    @Resource
    private RestTemplate restTemplate;

    @Resource
    private TelegramMessageRepository telegramMessageRepository;

    @Override
    @Async
    public void sendException(String message, String url) {
        LOGGER.info("Send exception message: {}", message);
//        String messageBuilder = String.format(MessageSyntax.EXCEPTION_MESSAGE, message, url, LocalDateTime.now().format(Constants.DATE_TIME_FORMATTER_1));
        String messageBuilder = String.format(MessageSyntax.TRANSFER_LINK_MESSAGE, message, url);
        sendMessage(messageBuilder,RequestType.EXCEPTION.name());
    }

    @Async
    public void sendTransferLink(String link, String traceId) {
        LOGGER.info("Send exception message: {}, with traceId: {}", link, traceId);
        String messageBuilder = String.format(MessageSyntax.TRANSFER_LINK_MESSAGE, link, traceId);
        sendMessage(messageBuilder,RequestType.TRANSFER_LINK.name(), traceId);
    }


    private void sendMessage(String message, String requestType) {
        if (CollectionUtils.isEmpty(AppConfig.TELEGRAM)) {
            LOGGER.error("Telegram configuration is not loaded");
            throw new SanException("Telegram configuration is not loaded");
        }
        StringBuilder url = new StringBuilder(AppConfig.TELEGRAM.get(KeyConfig.SEND_MESSAGE_URL)
                .replace(KeyConfig.BOT_TOKEN, AppConfig.TELEGRAM.get(KeyConfig.API_TOKEN)))
                .append(KeyConfig.VARIABLES_CHAT_ID)
                .append(AppConfig.TELEGRAM.get(KeyConfig.CHAT_ID))
                .append(KeyConfig.VARIABLES_TEXT)
                .append(message);

        ResponseEntity<SendMessTeleDTO> response = restTemplate.getForEntity(url.toString(), SendMessTeleDTO.class);
        if (response.getStatusCode().isError()) {
            LOGGER.error("Failed to send message to Telegram: {}", response.getBody());
        }
        TelegramMessage telegramMessage = new TelegramMessage();
        telegramMessage.setId(UUID.randomUUID().toString());
        telegramMessage.setChatId(response.getBody().getResult().getMessageId());
        telegramMessage.setFromId(response.getBody().getResult().getFrom().getId());
        telegramMessage.setUsername(response.getBody().getResult().getFrom().getUsername());
        telegramMessage.setText(response.getBody().getResult().getText());
        telegramMessage.setSendTime(LocalDateTime.now());
        telegramMessage.setTypeMess(requestType);
        telegramMessageRepository.save(telegramMessage);

        LOGGER.info("Telegram response: {}", response.getBody());
    }

    private void sendMessage(String message, String requestType, String additionalInfo) {
        if (CollectionUtils.isEmpty(AppConfig.TELEGRAM)) {
            LOGGER.error("Telegram configuration is not loaded");
            throw new SanException("Telegram configuration is not loaded");
        }
        StringBuilder url = new StringBuilder(AppConfig.TELEGRAM.get(KeyConfig.SEND_MESSAGE_URL)
                .replace(KeyConfig.BOT_TOKEN, AppConfig.TELEGRAM.get(KeyConfig.API_TOKEN)))
                .append(KeyConfig.VARIABLES_CHAT_ID)
                .append(AppConfig.TELEGRAM.get(KeyConfig.CHAT_ID))
                .append(KeyConfig.VARIABLES_TEXT)
                .append(message);

        ResponseEntity<SendMessTeleDTO> response = restTemplate.getForEntity(url.toString(), SendMessTeleDTO.class);
        if (response.getStatusCode().isError()) {
            LOGGER.error("Failed to send message to Telegram: {}", response.getBody());
        }
        TelegramMessage telegramMessage = new TelegramMessage();
        telegramMessage.setId(UUID.randomUUID().toString());
        telegramMessage.setChatId(response.getBody().getResult().getMessageId());
        telegramMessage.setFromId(response.getBody().getResult().getFrom().getId());
        telegramMessage.setUsername(response.getBody().getResult().getFrom().getUsername());
        telegramMessage.setText(response.getBody().getResult().getText());
        telegramMessage.setSendTime(LocalDateTime.now());
        telegramMessage.setAdditional(additionalInfo);
        telegramMessage.setTypeMess(requestType);
        telegramMessageRepository.save(telegramMessage);

        LOGGER.info("Telegram response: {}", response.getBody());
    }

    @Override
    public void receiveMessage(ReceiveMessageDTO update) {
        LOGGER.error("Telegram configuration is not loaded");
    }
}
