package pl.przemek;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import static org.junit.jupiter.api.Assertions.*;

public class JdbcPlaygroundTest {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @BeforeEach
    void clearDB() {
        jdbcTemplate.execute("DROP TABLE `product_catalog__products`");
        jdbcTemplate.execute("CREATE TABLE `product_catalog__products` (" +
                "`id` varchar(100) NOT NULL" +
                "description varchar(255)" +
                "PRIMARY KEY (`id`)" +
                ");");
    }

    @Test
    void itCountDummyProduct() {
        int productsCount = 1;

        assertEquals(1, productsCount);
    }

    @Test
    void itCountProduct() {
        int productsCount = jdbcTemplate
                .queryForObject("select 1", Integer.class);

        assertEquals(1, productsCount);
    }

    @Test
    void itAddsRealProducts() {

        jdbcTemplate.execute("INSERT INTO `product_catalog__products` (`id`, `description`)" +
                    "values " +
                "(`product1`, `desc1`)" +
                "(`product2`, `desc2`)" +
                ";");
        //jdbcTemplate.update(insertSQL,
          //      product.getID(), product.getDescription());

        int productsCount = jdbcTemplate
                .queryForObject("select count(*) from `product_catalog__products`", Integer.class);

        assertEquals(1, productsCount);
    }
}
