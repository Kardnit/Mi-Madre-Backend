package MiMadre.Work.Configs;
import MiMadre.Work.WorkJPA;
import org.mockito.Mockito;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

@TestConfiguration
public class WorkServiceConfigs {

    @Bean
    @Primary
    public WorkJPA workJPA(){
        return Mockito.mock(WorkJPA.class);
    }
}
