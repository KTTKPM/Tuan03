package iuh.fit.se.strategy;

import iuh.fit.se.state.Order;

public class NoRefund implements RefundStrategy {
    @Override
    public void refund(Order order) {
        System.out.println("No refund for this order.");
    }
}
