package iuh.fit.se.payment;

import iuh.fit.se.payment.strategy.PaymentStrategy;

import java.math.BigDecimal;

public class BasePayment implements Payment {
    private final String orderId;
    private final BigDecimal amount;
    private final PaymentStrategy strategy;

    public BasePayment(String orderId, BigDecimal amount, PaymentStrategy strategy) {
        this.orderId = orderId;
        this.amount = amount;
        this.strategy = strategy;
    }

    @Override
    public BigDecimal getAmount() {
        return amount;
    }

    @Override
    public String getDetails() {
        return "Order=" + orderId + ", amount=" + amount;
    }

    @Override
    public PaymentStrategy getStrategy() {
        return strategy;
    }
}
