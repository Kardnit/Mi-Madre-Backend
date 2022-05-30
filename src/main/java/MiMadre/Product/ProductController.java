package MiMadre.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path = "product")

public class ProductController {

    @Autowired
    private ProductService productService;


    @PostMapping
    public String postProduct(@RequestBody Product product){
        productService.handlePost(product);
        return "success";
    }

    @GetMapping
    public List<Product> getProducts(){
        return productService.getProducts();
    }

    @GetMapping("/id/{id}")
    public Product getProduct(@PathVariable String id){
        return productService.getProductById(id);
    }

    @PutMapping("/id/{id}")
    public String putProduct(@PathVariable String id , @RequestBody Product product){
        productService.handlePut(id, product);
        return "success";
    }

    @DeleteMapping
    public String deleteProduct(@RequestBody Product product){
        productService.handleDelete(product);
        return "success";
    }
}
