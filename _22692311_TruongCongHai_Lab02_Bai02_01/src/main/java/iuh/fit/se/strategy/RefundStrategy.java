package iuh.fit.se.strategy;

import iuh.fit.se.state.Order;

public interface RefundStrategy {
    void refund(Order order);
}
