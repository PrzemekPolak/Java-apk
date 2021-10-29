package pl.przemek;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class CreditCardTest {
    @Test
    public void itAllowsAssignCreditLimitToCard() {
        CreditCard card = new CreditCard("1234-5678");
        card.assignCredit(BigDecimal.valueOf(1000));
        assertEquals(BigDecimal.valueOf(1000), card.getCurrentLimit());
    }

    @Test
    public void limitBellowThresholdCantbeAssigned() {
        CreditCard card = new CreditCard("1234-5678");
        try {
            card.assignCredit(BigDecimal.valueOf(50));
            Assertions.fail("Failed");
        } catch (CreditBelowThresholdException e) {
            assertTrue(true);
        }

    }

    public void ItAllowWithdraw() {
        CreditCard card = new CreditCard("1234-5678");
        card.assignCredit(BigDecimal.valueOf(1000));

        card.withdraw(BigDecimal.valueOf(500));

        assertEquals(BigDecimal.valueOf(500), card.getBalance());
    }

    public void ItDisallowWithdrawOverCurrentBalance() {
        CreditCard card = new CreditCard("1234-5678");
        card.assignCredit(BigDecimal.valueOf(1000));
        card.withdraw(BigDecimal.valueOf(500));

        assertThrows(NotEnoughMoneyException.class, ()-> {
            card.withdraw(BigDecimal.valueOf(500));
        });
    }

}
