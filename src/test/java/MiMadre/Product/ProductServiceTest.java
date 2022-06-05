package MiMadre.Product;
import MiMadre.Product.Configs.ProductServiceConfigs;
import MiMadre.Product.Product;
import MiMadre.Product.ProductJPA;
import MiMadre.Product.ProductService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import java.util.List;

@ContextConfiguration(classes = ProductServiceConfigs.class)
@WebMvcTest(ProductService.class)
class ProductServiceTest {

    @Autowired
    ProductService service;

    @Autowired
    ProductJPA database;

    @Test
    void handlePost_SaveProduct_Void() {
        Product product = new Product();

        Mockito.doReturn(product).when(database).save(product);

        service.handlePost(product);
    }

    @Test
    void getProducts_GetProducts_List() {
        List<Product> products = List.of(new Product());

        Mockito.doReturn(products).when(database).findAll();

        List<Product> returnedProducts = service.getProducts();

        assert products == returnedProducts;
    }

    @Test
    void getProductById_GetProduct_Product() {
        Product product = new Product();

        Mockito.doReturn(product).when(database).getById(product.getId());

        Product returnedProduct = service.getProductById(product.getId());

        assert product == returnedProduct;
    }

    @Test
    void handlePut_UpdateProduct_Void() {
        Product product = new Product();
        Product oldproduct = new Product();
        String id = "MyId";

        Mockito.doReturn(oldproduct).when(database).getById(id);

        Mockito.doNothing().when(database).delete(oldproduct);

        Mockito.doReturn(product).when(database).save(product);

        service.handlePut(id, product);
    }

    @Test
    void handleDelete() {
        Product product = new Product();

        Mockito.doNothing().when(database).delete(product);

        service.handleDelete(product);
    }
}