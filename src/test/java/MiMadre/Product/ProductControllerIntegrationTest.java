package MiMadre.Product;

import MiMadre.Product.Configs.ProductIntegrationConfigs;
import MiMadre._Security.Jwt;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

@SpringBootTest(classes = { ProductController.class })
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ProductIntegrationConfigs.class)
@AutoConfigureMockMvc
public class ProductControllerIntegrationTest {

    @Autowired
    public MockMvc mvc;

    @Autowired
    public Jwt jwt;

    @Autowired
    public ProductJPA database;

    @Test
    public void postProduct() throws Exception{

        Product product = new Product();
        product.setId("id");
        product.setName("name");
        product.setImage("image");

        String jsonBody = new ObjectMapper().writeValueAsString(product);

        Mockito.doReturn(product).when(database).save(product);
        Mockito.doReturn(true).when(jwt).validateBearerToken("");

        ResultActions response = mvc.perform(
                MockMvcRequestBuilders.post("/product")
                        .content(jsonBody).contentType(MediaType.APPLICATION_JSON)
                        .header(HttpHeaders.AUTHORIZATION, "")
        );

        response.andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void getProductByID() throws Exception {

        Product product = new Product();
        product.setId("id");
        product.setName("name");
        product.setImage("image");

        Mockito.doReturn(product).when(database).getById(product.getId());

        ResultActions result = mvc.perform(
                MockMvcRequestBuilders.get("/product/id/{id}", product.getId())
                        .contentType(MediaType.APPLICATION_JSON)
        );

        result.andExpect(MockMvcResultMatchers.status().isOk());
        result.andExpect(MockMvcResultMatchers.jsonPath("$.id").value(product.getId()));
        result.andExpect(MockMvcResultMatchers.jsonPath("$.name").value(product.getName()));
        result.andExpect(MockMvcResultMatchers.jsonPath("$.image").value(product.getImage()));

    }

    @Test
    public void getProduct() throws Exception {

        Product product = new Product();
        product.setId("id");
        product.setName("name");
        product.setImage("image");

        List<Product> products = List.of(product);

        Mockito.doReturn(products).when(database).findAll();

        ResultActions result = mvc.perform(
                MockMvcRequestBuilders.get("/product")
                        .contentType(MediaType.APPLICATION_JSON)
        );

        result.andExpect(MockMvcResultMatchers.status().isOk());
        assert result.andReturn().getResponse().getContentAsString().contains(product.getId());
        assert result.andReturn().getResponse().getContentAsString().contains(product.getName());
        assert result.andReturn().getResponse().getContentAsString().contains(product.getImage());
    }

    @Test
    public void putProduct() throws Exception{

        Product product = new Product();
        product.setId("id");
        product.setName("name");
        product.setImage("image");

        String jsonBody = new ObjectMapper().writeValueAsString(product);

        Mockito.doReturn(product).when(database).save(product);
        Mockito.doReturn(true).when(jwt).validateBearerToken("");

        ResultActions response = mvc.perform(
                MockMvcRequestBuilders.put("/product/id/{id}", product.getId())
                        .content(jsonBody).contentType(MediaType.APPLICATION_JSON)
                        .header(HttpHeaders.AUTHORIZATION, "")
        );

        response.andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void deleteProduct() throws Exception{

        Product product = new Product();
        product.setId("id");
        product.setName("name");
        product.setImage("image");

        String jsonBody = new ObjectMapper().writeValueAsString(product);

        Mockito.doNothing().when(database).delete(product);
        Mockito.doReturn(true).when(jwt).validateBearerToken("");

        ResultActions response = mvc.perform(
                MockMvcRequestBuilders.delete("/product")
                        .content(jsonBody).contentType(MediaType.APPLICATION_JSON)
                        .header(HttpHeaders.AUTHORIZATION, "")
        );

        response.andExpect(MockMvcResultMatchers.status().isOk());
    }
}
