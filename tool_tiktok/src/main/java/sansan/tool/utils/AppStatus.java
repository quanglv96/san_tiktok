package sansan.tool.utils;

import lombok.Getter;

@Getter
public enum AppStatus {
    ACTIVE("ACTIVE"),
    INACTIVE("INACTIVE");
    private final String status;

    AppStatus(String status) {
        this.status = status;
    }
}
