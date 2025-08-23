package sansan.tool.DTO.TelegramDTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SendMessTeleDTO {
    @JsonProperty("ok")
    private Boolean ok;

    @JsonProperty("result")
    private ResultMessTele result;

}
