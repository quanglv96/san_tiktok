package sansan.tool.utils;

import lombok.Getter;

@Getter
public enum AppType {
    TELEGRAM("TELEGRAM");

    private final String type;

    AppType(String type) {
        this.type = type;
    }
}
