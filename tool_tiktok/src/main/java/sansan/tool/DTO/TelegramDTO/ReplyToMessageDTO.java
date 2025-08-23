package sansan.tool.DTO.TelegramDTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReplyToMessageDTO {

    @JsonProperty("message_id")
    private Integer messageId;

    @JsonProperty("from")
    private TeleDTO from;

    @JsonProperty("date")
    private Integer date;

    @JsonProperty("text")
    private String text;

}
