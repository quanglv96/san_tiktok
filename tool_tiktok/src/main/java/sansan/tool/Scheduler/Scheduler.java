package sansan.tool.Scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class Scheduler {
    // Chạy lúc 2h sáng hàng ngày (cron format)
//    @Scheduled(cron = "0 0 2 * * *")
    public void nightlyUpdate() {
        System.out.println("Nightly config update");
        // TODO: logic update
    }

    // Chạy mỗi 5 giây
//    @Scheduled(fixedRate = 5000)
    public void updateConfig() {
        System.out.println("Updating system config at " + LocalDateTime.now());
        // TODO: viết logic update config
    }
}
