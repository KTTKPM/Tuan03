package iuh.fit.se.decorator;

import iuh.fit.se.state.Order;

public class LoggingOrderAction implements OrderAction {
    private final OrderAction wrapped;

    public LoggingOrderAction(OrderAction wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public void act(Order order) {
        System.out.println("Logging: Order action started.");
        wrapped.act(order);
        System.out.println("Logging: Order action finished.");
    }
}
