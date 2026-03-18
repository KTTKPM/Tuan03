package iuh.fit.se.decorator;

import iuh.fit.se.state.Order;

public interface OrderAction {
    void act(Order order);
}
