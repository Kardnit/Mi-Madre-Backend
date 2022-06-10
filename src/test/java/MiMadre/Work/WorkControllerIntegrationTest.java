package MiMadre.Work;

import MiMadre.Work.Configs.WorkIntegrationConfigs;
import MiMadre.Work.Work;
import MiMadre.Work.WorkController;
import MiMadre.Work.WorkJPA;
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

@SpringBootTest(classes = { WorkController.class })
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = WorkIntegrationConfigs.class)
@AutoConfigureMockMvc
public class WorkControllerIntegrationTest {

    @Autowired
    public MockMvc mvc;

    @Autowired
    public Jwt jwt;

    @Autowired
    public WorkJPA database;

    @Test
    public void postWork() throws Exception{

        Work work = new Work();
        work.setId("id");
        work.setName("name");
        work.setImage("image");

        String jsonBody = new ObjectMapper().writeValueAsString(work);

        Mockito.doReturn(work).when(database).save(work);
        Mockito.doReturn(true).when(jwt).validateBearerToken("");

        ResultActions response = mvc.perform(
                MockMvcRequestBuilders.post("/work")
                        .content(jsonBody).contentType(MediaType.APPLICATION_JSON)
                        .header(HttpHeaders.AUTHORIZATION, "")
        );

        response.andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void getWorkByID() throws Exception {

        Work work = new Work();
        work.setId("id");
        work.setName("name");
        work.setImage("image");

        Mockito.doReturn(work).when(database).getById(work.getId());

        ResultActions result = mvc.perform(
                MockMvcRequestBuilders.get("/work/id/{id}", work.getId())
                        .contentType(MediaType.APPLICATION_JSON)
        );

        result.andExpect(MockMvcResultMatchers.status().isOk());
        result.andExpect(MockMvcResultMatchers.jsonPath("$.id").value(work.getId()));
        result.andExpect(MockMvcResultMatchers.jsonPath("$.name").value(work.getName()));
        result.andExpect(MockMvcResultMatchers.jsonPath("$.image").value(work.getImage()));

    }

    @Test
    public void getWork() throws Exception {

        Work work = new Work();
        work.setId("id");
        work.setName("name");
        work.setImage("image");

        List<Work> works = List.of(work);

        Mockito.doReturn(works).when(database).findAll();

        ResultActions result = mvc.perform(
                MockMvcRequestBuilders.get("/work")
                        .contentType(MediaType.APPLICATION_JSON)
        );

        result.andExpect(MockMvcResultMatchers.status().isOk());
        assert result.andReturn().getResponse().getContentAsString().contains(work.getId());
        assert result.andReturn().getResponse().getContentAsString().contains(work.getName());
        assert result.andReturn().getResponse().getContentAsString().contains(work.getImage());
    }

    @Test
    public void putWork() throws Exception{

        Work work = new Work();
        work.setId("id");
        work.setName("name");
        work.setImage("image");

        String jsonBody = new ObjectMapper().writeValueAsString(work);

        Mockito.doReturn(work).when(database).save(work);
        Mockito.doReturn(true).when(jwt).validateBearerToken("");

        ResultActions response = mvc.perform(
                MockMvcRequestBuilders.put("/work/id/{id}", work.getId())
                        .content(jsonBody).contentType(MediaType.APPLICATION_JSON)
                        .header(HttpHeaders.AUTHORIZATION, "")
        );

        response.andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void deleteWork() throws Exception{

        Work work = new Work();
        work.setId("id");
        work.setName("name");
        work.setImage("image");

        String jsonBody = new ObjectMapper().writeValueAsString(work);

        Mockito.doNothing().when(database).delete(work);
        Mockito.doReturn(true).when(jwt).validateBearerToken("");

        ResultActions response = mvc.perform(
                MockMvcRequestBuilders.delete("/work")
                        .content(jsonBody).contentType(MediaType.APPLICATION_JSON)
                        .header(HttpHeaders.AUTHORIZATION, "")
        );

        response.andExpect(MockMvcResultMatchers.status().isOk());
    }
}
