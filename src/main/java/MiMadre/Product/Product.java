package MiMadre.Product;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity (name = "products")

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Product {

    @Column @Id
    private String id;
    @Column
    private String name;
    @Column
    private String image;
}
