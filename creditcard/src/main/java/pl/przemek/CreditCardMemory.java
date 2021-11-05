package pl.przemek;

import java.util.Optional;

public interface CreditCardMemory {
    void save(CreditCard card);

    Optional<CreditCard> findByNumber(String cardNumber);
}
