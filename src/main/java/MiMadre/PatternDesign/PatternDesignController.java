package MiMadre.PatternDesign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path = "patterndesign")

public class PatternDesignController {

    @Autowired
    private PatternDesignService patternDesignService;

    @PostMapping
    public String postPatternDesign(@RequestBody PatternDesign patternDesign){
        patternDesignService.handlePost(patternDesign);
        return "success";
    }

    @GetMapping
    public List<PatternDesign> getPatternDesigns(){ return patternDesignService.getPatternDesigns(); }

    @GetMapping("/id/{id}")
    public PatternDesign getPatternDesigns(@PathVariable String id){
        return patternDesignService.getPatternDesignById(id);
    }

    @PutMapping("/id/{id}")
    public String putPatternDesign(@PathVariable String id , @RequestBody PatternDesign patternDesign){
        patternDesignService.handlePut(id, patternDesign);
        return "success";
    }

    @DeleteMapping
    public String deletePatternDesign(@RequestBody PatternDesign patternDesign){
        patternDesignService.handleDelete(patternDesign);
        return "success";
    }
}
