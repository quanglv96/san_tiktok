package sansan.tool.Service.Impl;

import org.apache.commons.lang3.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;
import sansan.tool.Config.AppConfig;
import sansan.tool.Config.GlobalExceptionHandler;
import sansan.tool.Config.SanException;
import sansan.tool.Entity.Config;
import sansan.tool.Repository.ConfigRepository;
import sansan.tool.Service.ConfigService;
import sansan.tool.Service.TelegramService;
import sansan.tool.utils.AppStatus;
import sansan.tool.utils.KeyConfig;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ConfigServiceImpl implements ConfigService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ConfigServiceImpl.class);

    @Resource
    private ConfigRepository configRepository;

    @Resource
    private RestTemplate restTemplate;

    @Override
    public void LoadMemoryConfig() {
        List<Config> configs = configRepository.findAllByStatus(AppStatus.ACTIVE.getStatus());
        if (!CollectionUtils.isEmpty(configs)) {
            for (Config config : configs) {
                switch (config.getType()) {
                    case "TELEGRAM":
                        AppConfig.TELEGRAM.put(config.getKey(), config.getValue());
                        break;
                    case "SHOPLUS":
                        AppConfig.SHOPLUS.put(config.getKey(), config.getValue());
                        break;
                    default:
                        // Handle unknown type
                        break;
                }
            }
        } else {
            LOGGER.error("ERROR-LoadMemoryConfig: No configuration found in the database.");
            throw new SanException("ERROR-LoadMemoryConfig: No configuration found in the database.");
        }
    }

    @Override
    public void webhookTelegram() {
        String url = AppConfig.TELEGRAM.get(KeyConfig.CONFIG_WEBHOOK)
                .replace(KeyConfig.BOT_TOKEN, AppConfig.TELEGRAM.get(KeyConfig.API_TOKEN))
                .replace(KeyConfig.URL_WEBHOOK, AppConfig.TELEGRAM.get(KeyConfig.URL_RECEIVE));

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, null, String.class);
        if (response.getStatusCode().isError()) {
            LOGGER.error("Failed to send message to Telegram: {}", response.getBody());
        }
        LOGGER.info("Telegram response: {}", response.getBody());
    }
}
