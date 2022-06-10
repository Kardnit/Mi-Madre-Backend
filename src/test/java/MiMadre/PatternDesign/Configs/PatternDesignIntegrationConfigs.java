package MiMadre.PatternDesign.Configs;

import MiMadre.PatternDesign.PatternDesignJPA;
import MiMadre.PatternDesign.PatternDesignService;
import MiMadre._Security.Jwt;
import org.mockito.Mockito;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@TestConfiguration
public class PatternDesignIntegrationConfigs {
    @Bean
    @Primary
    public PatternDesignJPA patternDesignJPA(){
        return Mockito.mock(PatternDesignJPA.class);
    }

    @Bean
    @Primary
    public Jwt jwt() { return Mockito.mock(Jwt.class); }

    @Bean
    @Primary
    public PatternDesignService service() { return new PatternDesignService(); }

}
