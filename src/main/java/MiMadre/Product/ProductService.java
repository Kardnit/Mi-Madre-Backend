package MiMadre.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductJPA productJPA;

    public void handlePost(Product product) {
        productJPA.save(product);
    }

    public List<Product> getProducts() {
        return productJPA.findAll();
    }

    public Product getProductById(String id) {
        return productJPA.getById(id);
    }

    public void handlePut(String id, Product product) {
        Product deleteProduct = productJPA.getById(id);
        productJPA.delete(deleteProduct);
        productJPA.save(product);
    }

    public void handleDelete(Product product) {
        productJPA.delete(product);
    }

}
