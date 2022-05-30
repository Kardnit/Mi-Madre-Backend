package MiMadre.PatternDesign;
import MiMadre.PatternDesign.Configs.PatternDesignControllerConfigs;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

@ContextConfiguration(classes = PatternDesignControllerConfigs.class)
@WebMvcTest(PatternDesignController.class)
class PatternDesignControllerTest {

    @Autowired
    PatternDesignController controller;

    @Autowired
    PatternDesignService service;

    @Test
    void postPatternDesign_CreatePatternDesign_String() {
        PatternDesign patterndesign = new PatternDesign();

        Mockito.doNothing().when(service).handlePost(patterndesign);

        controller.postPatternDesign(patterndesign);
    }

    @Test
    void getPatternDesigns_List() {
        List<PatternDesign> patterndesigns = List.of(new PatternDesign());

        Mockito.doReturn(patterndesigns).when(service).getPatternDesigns();

        List<PatternDesign> returnedPatternDesigns = controller.getPatternDesigns();

        assert patterndesigns == returnedPatternDesigns;
    }

    @Test
    void GetPatternDesignById_PatternDesign() {
        PatternDesign patterndesign = new PatternDesign();

        Mockito.doReturn(patterndesign).when(service).getPatternDesignById(patterndesign.getId());

        PatternDesign returnedPatternDesign = controller.getPatternDesigns(patterndesign.getId());

        assert patterndesign == returnedPatternDesign;
    }

    @Test
    void putPatternDesign() {
        PatternDesign patterndesign = new PatternDesign();
        PatternDesign oldpatterndesign = new PatternDesign();
        String id = "MyId";

        Mockito.doReturn(oldpatterndesign).when(service).getPatternDesignById(id);

        Mockito.doNothing().when(service).handleDelete(oldpatterndesign);

        Mockito.doNothing().when(service).handlePost(patterndesign);

        controller.putPatternDesign(id, patterndesign);
    }

    @Test
    void deletePatternDesign() {
        PatternDesign patterndesign = new PatternDesign();

        Mockito.doNothing().when(service).handleDelete(patterndesign);

        controller.deletePatternDesign(patterndesign);
    }
}