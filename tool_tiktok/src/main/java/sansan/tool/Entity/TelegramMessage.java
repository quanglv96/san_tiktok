package sansan.tool.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "Telegram_Message")
@Data
public class TelegramMessage {
    @Id
    @Column(name = "ID")
    private String id; // Unique identifier for the message

    @Column(name = "CHAT_ID")
    private String chatId; // Unique identifier for the chat

    @Column(name = "FROM_ID")
    private String fromId; // Unique identifier for the sender

    @Column(name = "USERNAME")
    private String username; // Username of the sender

    @Column(name = "TEXT")
    private String text; // Text content of the message

    @Column(name = "SEND_TIME")
    private LocalDateTime sendTime;

    @Column(name = "TYPE_MESS")
    private String typeMess;

    @Column(name = "ADDITIONAL")
    private String additional;

}
