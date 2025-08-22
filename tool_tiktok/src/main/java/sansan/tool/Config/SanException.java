package sansan.tool.Config;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class SanException extends RuntimeException {
    private String status;
    private String message;

    public SanException(String message) {
        super(message);
        this.status = "ERROR";
    }

    public SanException(String status, String message) {
        super(message);
        this.status = status;
    }
}
