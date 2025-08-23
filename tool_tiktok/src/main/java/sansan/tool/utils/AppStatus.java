package sansan.tool.utils;

import lombok.Getter;

@Getter
public enum AppStatus {
    ACTIVE("ACTIVE"),
    INACTIVE("INACTIVE"),
    FINISHED("FINISHED"),
    PENDING("PENDING"),
    ERROR("ERROR"),
    SUCCESS("SUCCESS");
    private final String status;

    AppStatus(String status) {
        this.status = status;
    }
}
