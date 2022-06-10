package MiMadre.PatternDesign;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.jackson.JsonComponent;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity (name = "patterndesigns")

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class PatternDesign {

    @Column @Id @JsonProperty
    private String id;
    @Column @JsonProperty
    private String name;
    @Column @JsonProperty
    private String image;
}
