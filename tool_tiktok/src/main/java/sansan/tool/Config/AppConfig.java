package sansan.tool.Config;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public interface AppConfig {

    Map<String, String> TELEGRAM = new HashMap<>();
}
