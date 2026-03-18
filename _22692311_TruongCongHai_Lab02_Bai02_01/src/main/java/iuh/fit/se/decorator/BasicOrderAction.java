package iuh.fit.se.decorator;

import iuh.fit.se.state.Order;

public class BasicOrderAction implements OrderAction {
    @Override
    public void act(Order order) {
        order.process();
    }
}
