package sansan.tool.DTO.TelegramDTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultMessTele {

    @JsonProperty("message_id")
    private String messageId;

    @JsonProperty("from")
    private TeleDTO from;

    @JsonProperty("chat")
    private TeleDTO chat;

    @JsonProperty("date")
    private String date;

    @JsonProperty("text")
    private String text;

}
