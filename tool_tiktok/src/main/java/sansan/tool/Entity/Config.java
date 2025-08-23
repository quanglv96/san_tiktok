package sansan.tool.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "config")
@Data
public class Config {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "type")
    private String type; //TELEGRAM, EMAIL, etc. => AppType

    @Column(name = "key")
    private String key;

    @Column(name = "value")
    private String value;

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    private String status; // "ACTIVE", "INACTIVE" => AppStatus

}
