package MiMadre.Product;
import MiMadre.Product.Configs.ProductControllerConfigs;
import MiMadre.Product.Product;
import MiMadre.Product.ProductController;
import MiMadre.Product.ProductService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

@ContextConfiguration(classes = ProductControllerConfigs.class)
@WebMvcTest(ProductController.class)
class ProductControllerTest {

    @Autowired
    ProductController controller;

    @Autowired
    ProductService service;

    @Test
    void postProduct_CreateProduct_String() {
        Product product = new Product();
        String bearer = new String();

        Mockito.doNothing().when(service).handlePost(product);

        controller.postProduct(bearer, product);
    }

    @Test
    void getProducts_List() {
        List<Product> products = List.of(new Product());

        Mockito.doReturn(products).when(service).getProducts();

        List<Product> returnedProducts = controller.getProducts();

        assert products == returnedProducts;
    }

    @Test
    void GetProductById_Product() {
        Product product = new Product();

        Mockito.doReturn(product).when(service).getProductById(product.getId());

        Product returnedProduct = controller.getProducts(product.getId());

        assert product == returnedProduct;
    }

    @Test
    void putProduct() {
        Product product = new Product();
        Product oldproduct = new Product();
        String id = "MyId";
        String bearer = new String();

        Mockito.doReturn(oldproduct).when(service).getProductById(id);

        Mockito.doNothing().when(service).handleDelete(oldproduct);

        Mockito.doNothing().when(service).handlePost(product);

        controller.putProduct(bearer, id, product);
    }

    @Test
    void deleteProduct() {
        Product product = new Product();
        String bearer = new String();

        Mockito.doNothing().when(service).handleDelete(product);

        controller.deleteProduct(bearer, product);
    }
}