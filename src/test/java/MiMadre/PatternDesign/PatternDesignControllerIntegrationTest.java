package MiMadre.PatternDesign;
import MiMadre.PatternDesign.Configs.PatternDesignIntegrationConfigs;
import MiMadre._Security.Jwt;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

@SpringBootTest(classes = { PatternDesignController.class })
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = PatternDesignIntegrationConfigs.class)
@AutoConfigureMockMvc
public class PatternDesignControllerIntegrationTest {

    @Autowired
    public MockMvc mvc;

    @Autowired
    public Jwt jwt;

    @Autowired
    public PatternDesignJPA database;

    @Test
    public void postPatternDesign() throws Exception{

        PatternDesign patterndesign = new PatternDesign();
        patterndesign.setId("id");
        patterndesign.setName("name");
        patterndesign.setImage("image");

        String jsonBody = new ObjectMapper().writeValueAsString(patterndesign);

        Mockito.doReturn(patterndesign).when(database).save(patterndesign);
        Mockito.doReturn(true).when(jwt).validateBearerToken("");

        ResultActions response = mvc.perform(
                MockMvcRequestBuilders.post("/patterndesign")
                        .content(jsonBody).contentType(MediaType.APPLICATION_JSON)
                        .header(HttpHeaders.AUTHORIZATION, "")
        );

        response.andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void getPatternDesignByID() throws Exception {

        PatternDesign patterndesign = new PatternDesign();
        patterndesign.setId("id");
        patterndesign.setName("name");
        patterndesign.setImage("image");

        Mockito.doReturn(patterndesign).when(database).getById(patterndesign.getId());

        ResultActions result = mvc.perform(
                MockMvcRequestBuilders.get("/patterndesign/id/{id}", patterndesign.getId())
                        .contentType(MediaType.APPLICATION_JSON)
        );

        result.andExpect(MockMvcResultMatchers.status().isOk());
        result.andExpect(MockMvcResultMatchers.jsonPath("$.id").value(patterndesign.getId()));
        result.andExpect(MockMvcResultMatchers.jsonPath("$.name").value(patterndesign.getName()));
        result.andExpect(MockMvcResultMatchers.jsonPath("$.image").value(patterndesign.getImage()));

    }

    @Test
    public void getPatternDesign() throws Exception {

        PatternDesign patterndesign = new PatternDesign();
        patterndesign.setId("id");
        patterndesign.setName("name");
        patterndesign.setImage("image");

        List<PatternDesign> patterndesigns = List.of(patterndesign);

        Mockito.doReturn(patterndesigns).when(database).findAll();

        ResultActions result = mvc.perform(
                MockMvcRequestBuilders.get("/patterndesign")
                        .contentType(MediaType.APPLICATION_JSON)
        );

        result.andExpect(MockMvcResultMatchers.status().isOk());
        assert result.andReturn().getResponse().getContentAsString().contains(patterndesign.getId());
        assert result.andReturn().getResponse().getContentAsString().contains(patterndesign.getName());
        assert result.andReturn().getResponse().getContentAsString().contains(patterndesign.getImage());
    }

    @Test
    public void putPatternDesign() throws Exception{

        PatternDesign patterndesign = new PatternDesign();
        patterndesign.setId("id");
        patterndesign.setName("name");
        patterndesign.setImage("image");

        String jsonBody = new ObjectMapper().writeValueAsString(patterndesign);

        Mockito.doReturn(patterndesign).when(database).save(patterndesign);
        Mockito.doReturn(true).when(jwt).validateBearerToken("");

        ResultActions response = mvc.perform(
                MockMvcRequestBuilders.put("/patterndesign/id/{id}", patterndesign.getId())
                        .content(jsonBody).contentType(MediaType.APPLICATION_JSON)
                        .header(HttpHeaders.AUTHORIZATION, "")
        );

        response.andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void deletePatternDesign() throws Exception{

        PatternDesign patterndesign = new PatternDesign();
        patterndesign.setId("id");
        patterndesign.setName("name");
        patterndesign.setImage("image");

        String jsonBody = new ObjectMapper().writeValueAsString(patterndesign);

        Mockito.doNothing().when(database).delete(patterndesign);
        Mockito.doReturn(true).when(jwt).validateBearerToken("");

        ResultActions response = mvc.perform(
                MockMvcRequestBuilders.delete("/patterndesign")
                        .content(jsonBody).contentType(MediaType.APPLICATION_JSON)
                        .header(HttpHeaders.AUTHORIZATION, "")
        );

        response.andExpect(MockMvcResultMatchers.status().isOk());
    }
}
