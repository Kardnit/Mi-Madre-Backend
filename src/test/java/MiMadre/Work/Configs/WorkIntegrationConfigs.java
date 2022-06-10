package MiMadre.Work.Configs;

import MiMadre.Work.WorkJPA;
import MiMadre.Work.WorkService;
import MiMadre._Security.Jwt;
import org.mockito.Mockito;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@TestConfiguration
public class WorkIntegrationConfigs {
    @Bean
    @Primary
    public WorkJPA workJPA(){
        return Mockito.mock(WorkJPA.class);
    }

    @Bean
    @Primary
    public Jwt jwt() { return Mockito.mock(Jwt.class); }

    @Bean
    @Primary
    public WorkService service() { return new WorkService(); }

}
