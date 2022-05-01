package MiMadre.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path = "work")

public class WorkController {

    @Autowired
    private final WorkService workService;

    @Autowired
    public WorkController(WorkService workService) {
        this.workService = workService;
    }

    @PostMapping
    public String postWork(@RequestBody Work work){
        workService.handlePost(work);
        return "success";
    }

    @GetMapping
    public List<Work> getWorks(){
        return workService.getWorks();
    }

    @GetMapping("/id/{id}")
    public Work getWork(@PathVariable String id){
        return workService.getWorkById(id);
    }

    @PutMapping("/id/{id}")
    public String putWork(@PathVariable String id , @RequestBody Work work){
        workService.handlePut(id, work);
        return "success";
    }

    @DeleteMapping
    public String deleteWork(@RequestBody Work work){
        workService.handleDelete(work);
        return "success";
    }
}
