package pl.przemek;

import java.math.BigDecimal;

public class BankingSystem {

    private final CreditCardMemory memory;

    public BankingSystem() {
        this.memory = new CreditCardHashMemory();
    }

    public void handleWithdraw(String cardNumber, int money) {
        CreditCard card = memory.findByNumber(cardNumber).get();
        card.withdraw(BigDecimal.valueOf(money));

        memory.save(card);
    }
}
