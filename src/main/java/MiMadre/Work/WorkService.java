package MiMadre.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class WorkService {

    @Autowired
    private WorkJPA workJPA;

    public void handlePost(Work work) {
        workJPA.save(work);
    }

    public List<Work> getWorks() {
        return workJPA.findAll();
    }

    public Work getWorkById(String id) {
        return workJPA.getById(id);
    }

    public void handlePut(String id, Work work) {
        Work deleteWork = workJPA.getById(id);
        workJPA.delete(deleteWork);
        workJPA.save(work);
    }

    public void handleDelete(Work work) {
        workJPA.delete(work);
    }

}
