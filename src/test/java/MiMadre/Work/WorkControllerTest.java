package MiMadre.Work;
import MiMadre.Work.Configs.WorkControllerConfigs;
import MiMadre.Work.Work;
import MiMadre.Work.WorkController;
import MiMadre.Work.WorkService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

@ContextConfiguration(classes = WorkControllerConfigs.class)
@WebMvcTest(WorkController.class)
class WorkControllerTest {

    @Autowired
    WorkController controller;

    @Autowired
    WorkService service;

    @Test
    void postWork_CreateWork_String() {
        Work work = new Work();
        String bearer = new String();

        Mockito.doNothing().when(service).handlePost(work);

        controller.postWork(bearer, work);
    }

    @Test
    void getWorks_List() {
        List<Work> works = List.of(new Work());

        Mockito.doReturn(works).when(service).getWorks();

        List<Work> returnedWorks = controller.getWorks();

        assert works == returnedWorks;
    }

    @Test
    void GetWorkById_Work() {
        Work work = new Work();

        Mockito.doReturn(work).when(service).getWorkById(work.getId());

        Work returnedWork = controller.getWorks(work.getId());

        assert work == returnedWork;
    }

    @Test
    void putWork() {
        Work work = new Work();
        Work oldwork = new Work();
        String id = "MyId";
        String bearer = new String();

        Mockito.doReturn(oldwork).when(service).getWorkById(id);

        Mockito.doNothing().when(service).handleDelete(oldwork);

        Mockito.doNothing().when(service).handlePost(work);

        controller.putWork(bearer, id, work);
    }

    @Test
    void deleteWork() {
        Work work = new Work();
        String bearer = new String();

        Mockito.doNothing().when(service).handleDelete(work);

        controller.deleteWork(bearer, work);
    }
}
