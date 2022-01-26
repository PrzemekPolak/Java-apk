package pl.przemek.sales.payment;

import pl.przemek.sales.ordering.CustomerDetails;
import pl.przemek.sales.ordering.PaymentDetails;

import java.math.BigDecimal;

public interface PaymentGateway {
    PaymentDetails register(String id, BigDecimal total, CustomerDetails customerDetails);
}
