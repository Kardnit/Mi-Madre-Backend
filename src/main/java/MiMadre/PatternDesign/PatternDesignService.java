package MiMadre.PatternDesign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PatternDesignService {

    @Autowired
    private PatternDesignJPA patternDesignJPA;

    public void handlePost(PatternDesign patternDesign) {
        patternDesignJPA.save(patternDesign);
    }

    public List<PatternDesign> getPatternDesigns() {
        return patternDesignJPA.findAll();
    }

    public PatternDesign getPatternDesignById(String id) {
        return patternDesignJPA.getById(id);
    }

    public void handlePut(String id, PatternDesign patternDesign) {
        PatternDesign deletePatternDesign = patternDesignJPA.getById(id);
        patternDesignJPA.delete(deletePatternDesign);
        patternDesignJPA.save(patternDesign);
    }

    public void handleDelete(PatternDesign patternDesign) {
        patternDesignJPA.delete(patternDesign);
    }

}
