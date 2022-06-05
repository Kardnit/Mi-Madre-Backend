package MiMadre.Work;
import MiMadre.Work.Configs.WorkServiceConfigs;
import MiMadre.Work.Work;
import MiMadre.Work.WorkJPA;
import MiMadre.Work.WorkService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import java.util.List;

@ContextConfiguration(classes = WorkServiceConfigs.class)
@WebMvcTest(WorkService.class)
class WorkServiceTest {

    @Autowired
    WorkService service;

    @Autowired
    WorkJPA database;

    @Test
    void handlePost_SaveWork_Void() {
        Work work = new Work();

        Mockito.doReturn(work).when(database).save(work);

        service.handlePost(work);
    }

    @Test
    void getWorks_GetWorks_List() {
        List<Work> works = List.of(new Work());

        Mockito.doReturn(works).when(database).findAll();

        List<Work> returnedWorks = service.getWorks();

        assert works == returnedWorks;
    }

    @Test
    void getWorkById_GetWork_Work() {
        Work work = new Work();

        Mockito.doReturn(work).when(database).getById(work.getId());

        Work returnedWork = service.getWorkById(work.getId());

        assert work == returnedWork;
    }

    @Test
    void handlePut_UpdateWork_Void() {
        Work work = new Work();
        Work oldwork = new Work();
        String id = "MyId";

        Mockito.doReturn(oldwork).when(database).getById(id);

        Mockito.doNothing().when(database).delete(oldwork);

        Mockito.doReturn(work).when(database).save(work);

        service.handlePut(id, work);
    }

    @Test
    void handleDelete() {
        Work work = new Work();

        Mockito.doNothing().when(database).delete(work);

        service.handleDelete(work);
    }
}