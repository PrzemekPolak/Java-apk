package pl.przemek;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreditCardApiTest {
    @Test
    public void ItAllowsToHandleCreditCardWithdrawFromMultipleCards() {
        thereIsCreditCardMemory();

        String cardNumber1 = thereIsCardWithLimitWithinTheSystem(1000);
        String cardNumber2 = thereIsCardWithLimitWithinTheSystem(2000);

        BankingSystem system = thereIsBankingSystem();

        system.handleWithdraw(cardNumber1, 500);
        system.handleWithdraw(cardNumber2, 1000);

        balanceOfCardEquals(cardNumber1, 500);
        balanceOfCardEquals(cardNumber2, 1000);
    }

    private void thereIsCreditCardMemory() {

    }

    private void balanceOfCardEquals(String cardNumber, int expectedBalance) {
        CreditCard loaded = new CreditCard.findByNumber(cardNumber)
                .orElseGet(()  -> new CreditCard(cardNumber));

        assertEquals(BigDecimal.valueOf(expectedBalance), loaded.getBalance());
    }

    private BankingSystem thereIsBankingSystem() {

        return new BankingSystem(cardMemory);
    }

    private String thereIsCardWithLimitWithinTheSystem(int creditLimit) {
        CreditCardMemory memory = new CreditCardHashMemory();

        CreditCard card = new CreditCard(UUID.randomUUID().toString());
        card.assignCredit(BigDecimal.valueOf(creditLimit));

        memory.save(card);

        return card.getNumber();
    }
}
