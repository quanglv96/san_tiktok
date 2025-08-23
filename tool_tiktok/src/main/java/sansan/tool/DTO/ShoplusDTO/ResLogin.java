package sansan.tool.DTO.ShoplusDTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResLogin {

    @JsonProperty("code")
    private String code;

    @JsonProperty("msg")
    private String msg;

    @JsonProperty("data")
    private DataLoginShoplus data;

    @JsonProperty("success")
    private Boolean success;

    @JsonProperty("expired")
    private LocalDateTime expired;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class DataLoginShoplus {

        @JsonProperty("user_id")
        private String userId;

        @JsonProperty("token")
        private String token;

        @JsonProperty("nick_name")
        private String nickName;

        @JsonProperty("email")
        private String email;

        @JsonProperty("system_id")
        private String systemId;

        @JsonProperty("from_system")
        private String fromSystem;

    }
}
