package MiMadre.Work.Configs;

import MiMadre.Work.WorkJPA;
import MiMadre.Work.WorkService;
import MiMadre._Security.Jwt;
import org.mockito.Mockito;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

@TestConfiguration
public class WorkControllerConfigs {

    @Bean
    @Primary
    public WorkService workService(){
        return Mockito.mock(WorkService.class);
    }

    @Bean
    @Primary
    public WorkJPA workJPA(){
        return Mockito.mock(WorkJPA.class);
    }

    @Bean
    @Primary
    public Jwt jwt() { return Mockito.mock(Jwt.class); }
}
