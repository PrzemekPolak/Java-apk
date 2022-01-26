package pl.przemek;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.przemek.payment.PayU;
import pl.przemek.productcatalog.Product;
import pl.przemek.productcatalog.ProductCatalog;
import pl.przemek.productcatalog.ProductRepository;
import pl.przemek.sales.*;
import pl.przemek.sales.offerting.OfferMaker;
import pl.przemek.sales.ordering.InMemoryReservationStorage;
import pl.przemek.sales.ordering.ReservationRepository;
import pl.przemek.sales.payment.PayUPaymentGateway;

import java.math.BigDecimal;
import java.util.Arrays;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    public ProductCatalog createProductCatalog(
            ProductRepository productRepository) {
        ProductCatalog productCatalog = new ProductCatalog(productRepository);
        String productId1 = productCatalog.addProduct(
                "MY Example product 1",
                BigDecimal.valueOf(10.10),
                Arrays.asList("tag1", "tag2"),
                "https://picsum.photos/200/300"
        );
        productCatalog.publish(productId1);

        String productId2 = productCatalog.addProduct(
                "Example product 2",
                BigDecimal.valueOf(20.10),
                Arrays.asList("tag2"),
                "https://picsum.photos/300/200"
        );
        productCatalog.publish(productId2);

        String productId3 = productCatalog.addProduct(
                "Example product 3",
                BigDecimal.valueOf(30.10),
                Arrays.asList("tag2"),
                "https://picsum.photos/301/201"
        );
        productCatalog.publish(productId3);

        return productCatalog;
    }

    @Bean
    public SalesFacade createSalesFacade(ProductDetailsProvider productDetailsProvider, PayU payU) {
        return new SalesFacade(
                new BasketStorage(),
                productDetailsProvider,
                new OfferMaker(productDetailsProvider),
                new InMemoryReservationStorage(),
                new PayUPaymentGateway(payU));
    }

    @Bean
    public ProductDetailsProvider productDetailsProvider(ProductCatalog productCatalog ) {
        return (id) -> {
            Product product = productCatalog.getById(id);
            return new ProductDetails(
                    product.getId(),
                    product.getPrice()
            );
        };
    }

    @Bean
    public JpaReservationStorage createJpaReervationStorage(ReservationRepository reservationRepository) {
        return new JpaReservationStorage(reservationRepository);
    }
}
