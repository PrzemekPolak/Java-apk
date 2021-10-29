package pl.przemek;

import org.junit.jupiter.api.Test;

public class BlaBlaTest {
    @Test
    public void ItAllowsToHandleCreditCardWithdrawFromMultipleCards() {
        String cardNumber1 = thereIscardWithlimitWithinTheSystem(1000);
        String cardNumber2 = thereIscardWithlimitWithinTheSystem(2000);

        BankingSystem system = thereIsBankingSystem();

        system.handleWithdraw(cardNumber1, 500);
        system.handleWithdraw(cardNumber2, 1000);

        balanceOfCardEquals(cardNumber1, 500);
        balanceOfCardEquals(cardNumber2, 1000);
    }

    private BankingSystem thereIsBankingSystem() {
        return new BankingSystem();
    }

    private String thereIscardWithlimitWithinTheSystem(int i) {
        return "123456";
    }
}
