package sansan.tool.Config;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import sansan.tool.Service.ConfigService;

import javax.annotation.Resource;

@Component
public class ConfigLoader implements ApplicationRunner {
    @Resource
    private ConfigService configService;

    @Override
    public void run(ApplicationArguments args) {
        configService.LoadMemoryConfig();
    }
}
