package iuh.fit.se.payment.strategy;

import java.math.BigDecimal;

public class PayPalStrategy implements PaymentStrategy {
    private final String email;

    public PayPalStrategy(String email) {
        this.email = email;
    }

    @Override
    public boolean pay(BigDecimal amount) {
        System.out.println("[Strategy] PayPal payment from " + email + ": " + amount);
        return amount.compareTo(BigDecimal.ZERO) > 0;
    }

    @Override
    public String getMethodName() {
        return "PayPal";
    }
}
