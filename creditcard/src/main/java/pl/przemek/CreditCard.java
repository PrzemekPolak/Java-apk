package pl.przemek;

import java.math.BigDecimal;

public class CreditCard {
    private final String cardNumber;
    private BigDecimal creditLimit;
    private BigDecimal balance;

    public CreditCard(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void assignCredit(BigDecimal creditLimit) {
        if (isBelowCreditLimit(creditLimit)) {
            throw new CreditBelowThresholdException();
        }
        this.creditLimit = creditLimit;
    }

    private boolean isBelowCreditLimit(BigDecimal creditLimit) {
        return BigDecimal.compareTo(BigDecimal.valueOf(100)) < 0;
    }

    public BigDecimal getCurrentLimit() {
        return creditLimit;
    }

    public void withdraw(BigDecimal money) {
        if (balance.compareTo(money) < 0) {
            throw new NotEnoughMoneyException;
        }
        this.balance = balance.subtract(money);
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public String getNumber() {


    }
}
