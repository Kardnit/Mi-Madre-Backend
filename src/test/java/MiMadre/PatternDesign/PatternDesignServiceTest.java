package MiMadre.PatternDesign;
import MiMadre.PatternDesign.Configs.PatternDesignServiceConfigs;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import java.util.List;

@ContextConfiguration(classes = PatternDesignServiceConfigs.class)
@WebMvcTest(PatternDesignService.class)
class PatternDesignServiceTest {

    @Autowired
    PatternDesignService service;

    @Autowired
    PatternDesignJPA database;

    @Test
    void handlePost_SavePatternDesign_Void() {
        PatternDesign patterndesign = new PatternDesign();

        Mockito.doReturn(patterndesign).when(database).save(patterndesign);

        service.handlePost(patterndesign);
    }

    @Test
    void getPatternDesigns_GetPatternDesigns_List() {
        List<PatternDesign> patterndesigns = List.of(new PatternDesign());

        Mockito.doReturn(patterndesigns).when(database).findAll();

        List<PatternDesign> returnedPatternDesigns = service.getPatternDesigns();

        assert patterndesigns == returnedPatternDesigns;
    }

    @Test
    void getPatternDesignById_GetPatternDesign_PatternDesign() {
        PatternDesign patterndesign = new PatternDesign();

        Mockito.doReturn(patterndesign).when(database).getById(patterndesign.getId());

        PatternDesign returnedPatternDesign = service.getPatternDesignById(patterndesign.getId());

        assert patterndesign == returnedPatternDesign;
    }

    @Test
    void handlePut_UpdatePatternDesign_Void() {
        PatternDesign patterndesign = new PatternDesign();
        PatternDesign oldpatterndesign = new PatternDesign();
        String id = "MyId";

        Mockito.doReturn(oldpatterndesign).when(database).getById(id);

        Mockito.doNothing().when(database).delete(oldpatterndesign);

        Mockito.doReturn(patterndesign).when(database).save(patterndesign);

        service.handlePut(id, patterndesign);
    }

    @Test
    void handleDelete() {
        PatternDesign patterndesign = new PatternDesign();

        Mockito.doNothing().when(database).delete(patterndesign);

        service.handleDelete(patterndesign);
    }
}