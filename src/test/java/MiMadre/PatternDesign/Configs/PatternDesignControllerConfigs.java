package MiMadre.PatternDesign.Configs;
import MiMadre.PatternDesign.PatternDesignController;
import MiMadre.PatternDesign.PatternDesignJPA;
import MiMadre.PatternDesign.PatternDesignService;
import org.mockito.Mockito;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

@TestConfiguration
public class PatternDesignControllerConfigs {

    @Bean
    @Primary
    public PatternDesignService patternDesignService(){
        return Mockito.mock(PatternDesignService.class);
    }

    @Bean
    @Primary
    public PatternDesignJPA patternDesignJPA(){
        return Mockito.mock(PatternDesignJPA.class);
    }
}
