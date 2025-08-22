package sansan.tool.Service.Impl;

import org.apache.commons.lang3.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import sansan.tool.Config.AppConfig;
import sansan.tool.Config.GlobalExceptionHandler;
import sansan.tool.Config.SanException;
import sansan.tool.Entity.Config;
import sansan.tool.Repository.ConfigRepository;
import sansan.tool.Service.ConfigService;
import sansan.tool.Service.TelegramService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ConfigServiceImpl implements ConfigService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ConfigServiceImpl.class);

    @Resource
    private ConfigRepository configRepository;

    @Resource
    private TelegramService telegramService;

    @Override
    public void LoadMemoryConfig() {
        List<Config> configs = configRepository.findAll();
        if (!CollectionUtils.isEmpty(configs)) {
            for (Config config : configs) {
                switch (config.getType()) {
                    case "TELEGRAM":
                        AppConfig.TELEGRAM.put(config.getKey(), config.getValue());
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
}
