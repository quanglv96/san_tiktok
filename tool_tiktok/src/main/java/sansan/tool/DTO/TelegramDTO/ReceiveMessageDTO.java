package sansan.tool.DTO.TelegramDTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReceiveMessageDTO {
    @JsonProperty("update_id")
    private Long updateId;

    @JsonProperty("message")
    private MessageTeleDTO message;

}
