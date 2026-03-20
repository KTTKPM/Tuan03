package iuh.fit.se.payment.decorator;

import iuh.fit.se.payment.Payment;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class DiscountCodeDecorator extends PaymentDecorator {
    private final String code;
    private final BigDecimal discountPercent;

    public DiscountCodeDecorator(Payment wrapped, String code, BigDecimal discountPercent) {
        super(wrapped);
        this.code = code;
        this.discountPercent = discountPercent;
    }

    @Override
    public BigDecimal getAmount() {
        BigDecimal discount = wrapped.getAmount()
                .multiply(discountPercent)
                .divide(new BigDecimal("100"), 2, RoundingMode.HALF_UP);
        BigDecimal finalAmount = wrapped.getAmount().subtract(discount);
        return finalAmount.max(BigDecimal.ZERO);
    }

    @Override
    public String getDetails() {
        return wrapped.getDetails() + " | -Discount(" + code + ":" + discountPercent + "%)";
    }
}
