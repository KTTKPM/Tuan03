package iuh.fit.se.state;

import iuh.fit.se.strategy.RefundStrategy;

public class CancelledState implements OrderState {
    private final RefundStrategy refundStrategy;

    public CancelledState(RefundStrategy refundStrategy) {
        this.refundStrategy = refundStrategy;
    }

    @Override
    public void handle(Order order) {
        System.out.println("Order cancelled.");
        refundStrategy.refund(order);
    }
}
