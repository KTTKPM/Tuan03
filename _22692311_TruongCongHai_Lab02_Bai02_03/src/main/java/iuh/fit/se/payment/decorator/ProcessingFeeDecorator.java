package iuh.fit.se.payment.decorator;

import iuh.fit.se.payment.Payment;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ProcessingFeeDecorator extends PaymentDecorator {
    private final BigDecimal feePercent;

    public ProcessingFeeDecorator(Payment wrapped, BigDecimal feePercent) {
        super(wrapped);
        this.feePercent = feePercent;
    }

    @Override
    public BigDecimal getAmount() {
        BigDecimal fee = wrapped.getAmount()
                .multiply(feePercent)
                .divide(new BigDecimal("100"), 2, RoundingMode.HALF_UP);
        return wrapped.getAmount().add(fee);
    }

    @Override
    public String getDetails() {
        return wrapped.getDetails() + " | +ProcessingFee(" + feePercent + "%)";
    }
}
