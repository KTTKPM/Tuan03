package iuh.fit.se.payment.strategy;

import java.math.BigDecimal;

public class CreditCardStrategy implements PaymentStrategy {
    private final String cardHolder;
    private final String maskedCardNumber;

    public CreditCardStrategy(String cardHolder, String maskedCardNumber) {
        this.cardHolder = cardHolder;
        this.maskedCardNumber = maskedCardNumber;
    }

    @Override
    public boolean pay(BigDecimal amount) {
        System.out.println("[Strategy] Credit Card payment by " + cardHolder + " with card " + maskedCardNumber + ": " + amount);
        return amount.compareTo(BigDecimal.ZERO) > 0;
    }

    @Override
    public String getMethodName() {
        return "CreditCard";
    }
}
