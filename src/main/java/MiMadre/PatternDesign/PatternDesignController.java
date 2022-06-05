package MiMadre.PatternDesign;
import MiMadre._Security.Jwt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path = "patterndesign")

public class PatternDesignController {

    @Autowired
    private PatternDesignService patternDesignService;

    @Autowired
    private Jwt jwt;

    @PostMapping
    public String postPatternDesign(@RequestHeader("Authorization") String bearer, @RequestBody PatternDesign patternDesign){

        if(!jwt.validateBearerToken(bearer)){
            return "Invalid JWT";
        }

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
    public String putPatternDesign(@RequestHeader("Authorization") String bearer, @PathVariable String id , @RequestBody PatternDesign patternDesign){
        if(!jwt.validateBearerToken(bearer)){
            return "Invalid JWT";
        }

        patternDesignService.handlePut(id, patternDesign);
        return "success";
    }

    @DeleteMapping
    public String deletePatternDesign(@RequestHeader("Authorization") String bearer, @RequestBody PatternDesign patternDesign){
        if(!jwt.validateBearerToken(bearer)){
            return "Invalid JWT";
        }

        patternDesignService.handleDelete(patternDesign);
        return "success";
    }
}
