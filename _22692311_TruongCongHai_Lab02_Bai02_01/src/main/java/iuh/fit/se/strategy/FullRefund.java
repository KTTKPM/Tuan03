package iuh.fit.se.strategy;

import iuh.fit.se.state.Order;

public class FullRefund implements RefundStrategy {
    @Override
    public void refund(Order order) {
        System.out.println("Full refund processed.");
    }
}
