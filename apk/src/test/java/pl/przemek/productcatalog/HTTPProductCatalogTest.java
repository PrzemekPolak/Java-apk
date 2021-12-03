package pl.przemek.productcatalog;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HTTPProductCatalogTest {

    @Autowired
    TestRestTemplate restTemplate;

    @LocalServerPort
    int serverPort;

    @Autowired
    ProductCatalog;

    @Test
    void itLoadsProductsViaEndpoint() {

        thereIsDraftProduct("example 0");
        thereIsProduct("example 1");
        thereIsProduct("example2");

        ResponseEntity<Product[]> response = callApiForProducts();
        Product[] products = response.getBody();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(2, products.length);
    }

    private void thereIsProduct(String productName) {
        productCatalog.addProduct;
    }

    private void thereIsDraftProduct(String productName) {

    }


    private ResponseEntity<Product[]> callApiForProducts() {
        String url = String.format(
                "http://localhost:%s/api/products",
                serverPort);
        return null;
    }

}
