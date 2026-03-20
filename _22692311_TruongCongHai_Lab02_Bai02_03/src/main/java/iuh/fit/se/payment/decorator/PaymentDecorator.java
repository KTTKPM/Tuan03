package iuh.fit.se.payment.decorator;

import iuh.fit.se.payment.Payment;
import iuh.fit.se.payment.strategy.PaymentStrategy;

import java.math.BigDecimal;

public abstract class PaymentDecorator implements Payment {
    protected final Payment wrapped;

    protected PaymentDecorator(Payment wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public BigDecimal getAmount() {
        return wrapped.getAmount();
    }

    @Override
    public String getDetails() {
        return wrapped.getDetails();
    }

    @Override
    public PaymentStrategy getStrategy() {
        return wrapped.getStrategy();
    }
}
