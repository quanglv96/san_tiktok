package sansan.tool.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "config")
@Data
public class Config {
    @Id
    @JsonProperty("id")
    private String id;

    @JsonProperty("type")
    private String type; //TELEGRAM, EMAIL, etc. => AppType

    @JsonProperty("key")
    private String key;

    @JsonProperty("value")
    private String value;

    @JsonProperty("description")
    private String description;

    @JsonProperty("status")
    private String status; // "ACTIVE", "INACTIVE" => AppStatus

}
