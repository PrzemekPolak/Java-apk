package pl.przemek.legacy_tests;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.przemek.productcatalog.Product;
import pl.przemek.productcatalog.ProductRepository;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.UUID;

@SpringBootTest
public class JpaPlaygroundTest {
    @Autowired
    ProductRepository productRepository;

    @Test
    void itStoreProduct() {
        UUID id = UUID.randomUUID();
        Product product = new Product(id, "My prod", BigDecimal.ONE, Arrays.asList("k1", "k2"), "media.jpg");
        productRepository.save(product);

        Product loaded = productRepository.findById(id.toString()).get();
    }
}