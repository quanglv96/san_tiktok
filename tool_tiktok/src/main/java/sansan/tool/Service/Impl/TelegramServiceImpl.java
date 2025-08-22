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
import sansan.tool.Service.TelegramService;
import sansan.tool.utils.Constants;
import sansan.tool.utils.KeyConfig;
import sansan.tool.utils.MessageSyntax;

import java.time.LocalDateTime;

@Service
public class TelegramServiceImpl implements TelegramService {
    private static final Logger LOGGER = LoggerFactory.getLogger(TelegramServiceImpl.class);

    private final RestTemplate restTemplate = new RestTemplate();


    @Override
    @Async
    public void sendException(String message, String url) {
        LOGGER.info("Send exception message: {}", message);
        String messageBuilder = String.format(MessageSyntax.EXCEPTION_MESSAGE, message,url, LocalDateTime.now().format(Constants.DATE_TIME_FORMATTER_1));
        sendMessage(messageBuilder);
    }


    private void sendMessage(String message) {
        if(CollectionUtils.isEmpty(AppConfig.TELEGRAM)){
            LOGGER.error("Telegram configuration is not loaded");
            throw new SanException("Telegram configuration is not loaded");
        }
        StringBuilder url = new StringBuilder(AppConfig.TELEGRAM.get(KeyConfig.SEND_MESSAGE_URL)
                .replace(KeyConfig.BOT_TOKEN, AppConfig.TELEGRAM.get(KeyConfig.API_TOKEN)))
                .append(KeyConfig.VARIABLES_CHAT_ID)
                .append(AppConfig.TELEGRAM.get(KeyConfig.CHAT_ID))
                .append(KeyConfig.VARIABLES_TEXT)
                .append(message);

        ResponseEntity<String> response = restTemplate.getForEntity(url.toString(), String.class);
        if (response.getStatusCode().isError()) {
            LOGGER.error("Failed to send message to Telegram: {}", response.getBody());
        }
        LOGGER.info("Telegram response: {}", response.getBody());
    }
}
