package MiMadre.Product.Configs;
import MiMadre.Product.ProductJPA;
import org.mockito.Mockito;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

@TestConfiguration
public class ProductServiceConfigs {

    @Bean
    @Primary
    public ProductJPA productJPA(){
        return Mockito.mock(ProductJPA.class);
    }
}
