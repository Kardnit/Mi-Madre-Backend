package MiMadre.Product.Configs;

import MiMadre.Product.ProductJPA;
import MiMadre.Product.ProductService;
import MiMadre._Security.Jwt;
import org.mockito.Mockito;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@TestConfiguration
public class ProductIntegrationConfigs {
    @Bean
    @Primary
    public ProductJPA productJPA(){
        return Mockito.mock(ProductJPA.class);
    }

    @Bean
    @Primary
    public Jwt jwt() { return Mockito.mock(Jwt.class); }

    @Bean
    @Primary
    public ProductService service() { return new ProductService(); }

}
