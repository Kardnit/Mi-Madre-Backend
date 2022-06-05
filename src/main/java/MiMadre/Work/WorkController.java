package MiMadre.Work;
import MiMadre._Security.Jwt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path = "work")

public class WorkController {

    @Autowired
    private WorkService workService;

    @Autowired
    private Jwt jwt;

    @PostMapping
    public String postWork(@RequestHeader("Authorization") String bearer, @RequestBody Work work){

        if(!jwt.validateBearerToken(bearer)){
            return "Invalid JWT";
        }

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
    public String putWork(@RequestHeader("Authorization") String bearer, @PathVariable String id , @RequestBody Work work){
        if(!jwt.validateBearerToken(bearer)){
            return "Invalid JWT";
        }

        workService.handlePut(id, work);
        return "success";
    }

    @DeleteMapping
    public String deleteWork(@RequestHeader("Authorization") String bearer, @RequestBody Work work){
        if(!jwt.validateBearerToken(bearer)){
            return "Invalid JWT";
        }

        workService.handleDelete(work);
        return "success";
    }
}
