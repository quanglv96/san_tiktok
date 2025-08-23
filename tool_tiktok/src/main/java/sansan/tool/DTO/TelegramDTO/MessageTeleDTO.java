package sansan.tool.DTO.TelegramDTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageTeleDTO {
    @JsonProperty("message_id")
    private Integer messageId;

    @JsonProperty("from")
    private TeleDTO from;

    @JsonProperty("chat")
    private TeleDTO chat;

    @JsonProperty("date")
    private Integer date;

    @JsonProperty("text")
    private String text;

    @JsonProperty("reply_to_message")
    private ReplyToMessageDTO replyToMessage;


}
