package iuh.fit.se.payment;

import iuh.fit.se.payment.strategy.PaymentStrategy;

import java.math.BigDecimal;

public interface Payment {
    BigDecimal getAmount();

    String getDetails();

    PaymentStrategy getStrategy();
}
