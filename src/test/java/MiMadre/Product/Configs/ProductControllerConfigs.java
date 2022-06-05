package MiMadre.Product.Configs;
import MiMadre.Product.ProductJPA;
import MiMadre.Product.ProductService;
import MiMadre._Security.Jwt;
import org.mockito.Mockito;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

@TestConfiguration
public class ProductControllerConfigs {

    @Bean
    @Primary
    public ProductService productService(){
        return Mockito.mock(ProductService.class);
    }

    @Bean
    @Primary
    public ProductJPA productJPA(){
        return Mockito.mock(ProductJPA.class);
    }

    @Bean
    @Primary
    public Jwt jwt() { return Mockito.mock(Jwt.class); }
}