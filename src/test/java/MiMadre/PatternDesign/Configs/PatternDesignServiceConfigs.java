package MiMadre.PatternDesign.Configs;
import MiMadre.PatternDesign.PatternDesignJPA;
import org.mockito.Mockito;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

@TestConfiguration
public class PatternDesignServiceConfigs {

    @Bean
    @Primary
    public PatternDesignJPA patternDesignJPA(){
        return Mockito.mock(PatternDesignJPA.class);
    }
}
