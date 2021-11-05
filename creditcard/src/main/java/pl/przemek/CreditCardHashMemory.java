package pl.przemek;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class CreditCardHashMemory implements CreditCardMemory {
    private Map<String, CreditCard> cards;

    public CreditCardHashMemory() {
        this.cards = new HashMap<>();
    }

    @Override
    public void save(CreditCard card) {
        cards.put(card.getNumber(), card);
    }

    @Override
    public Optional<CreditCard> findByNumber(String cardNumber) {
        return Optional.of(cards.get(cardNumber));
    }
}
