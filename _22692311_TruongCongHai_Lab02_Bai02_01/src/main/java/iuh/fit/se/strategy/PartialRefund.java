package iuh.fit.se.strategy;

import iuh.fit.se.state.Order;

public class PartialRefund implements RefundStrategy {
    private final double percent;

    public PartialRefund(double percent) {
        if (percent < 0 || percent > 100) {
            throw new IllegalArgumentException("percent must be between 0 and 100");
        }
        this.percent = percent;
    }

    @Override
    public void refund(Order order) {
        System.out.println("Partial refund processed: " + percent + "%.");
    }
}
