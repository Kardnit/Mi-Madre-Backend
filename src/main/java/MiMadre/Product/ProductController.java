package MiMadre.Product;
import MiMadre._Security.Jwt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path = "product")

public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private Jwt jwt;

    @PostMapping
    public String postProduct(@RequestHeader("Authorization") String bearer, @RequestBody Product product){

        if(!jwt.validateBearerToken(bearer)){
            return "Invalid JWT";
        }

        productService.handlePost(product);
        return "success";
    }

    @GetMapping
    public List<Product> getProducts(){ return productService.getProducts(); }

    @GetMapping("/id/{id}")
    public Product getProduct(@PathVariable String id){
        return productService.getProductById(id);
    }

    @PutMapping("/id/{id}")
    public String putProduct(@RequestHeader("Authorization") String bearer, @PathVariable String id , @RequestBody Product product){
        if(!jwt.validateBearerToken(bearer)){
            return "Invalid JWT";
        }

        productService.handlePut(id, product);
        return "success";
    }

    @DeleteMapping
    public String deleteProduct(@RequestHeader("Authorization") String bearer, @RequestBody Product product){
        if(!jwt.validateBearerToken(bearer)){
            return "Invalid JWT";
        }

        productService.handleDelete(product);
        return "success";
    }
}
