package sansan.tool.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "products")
@Data
public class Product {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @Column(name = "URL_PRODUCT")
    private String urlProduct;

    @Column(name = "URL_AFFILIATE")
    private String urlAffiliate;

    @Column(name = "ODER")
    private String oder;

    @Column(name = "price")
    private String price;

    @Column(name = "discount")
    private String discount;

}
