package sansan.tool.DTO.ShoplusDTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReqLogin {
    @JsonProperty("from_system")
    private String fromSystem;

    @JsonProperty("login_id")
    private String loginId;

    @JsonProperty("login_type")
    private String loginType;

    @JsonProperty("password")
    private String password;

    @JsonProperty("req_type")
    private String reqType;
}
