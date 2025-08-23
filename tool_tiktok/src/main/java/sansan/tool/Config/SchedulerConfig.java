package sansan.tool.Config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Configuration
public class SchedulerConfig {

    @Bean
    public ScheduledExecutorService taskScheduler() {
        return Executors.newScheduledThreadPool(2);
    }

    @Bean
    public CommandLineRunner scheduleTask(ScheduledExecutorService executor) {
        return args -> {
            executor.scheduleAtFixedRate(
                    () -> System.out.println("Updating config..."),
                    0, 10, TimeUnit.SECONDS
            );
        };
    }
}
