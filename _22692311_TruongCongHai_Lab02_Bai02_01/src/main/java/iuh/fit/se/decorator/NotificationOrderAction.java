package iuh.fit.se.decorator;

import iuh.fit.se.state.Order;

public class NotificationOrderAction implements OrderAction {
    private final OrderAction wrapped;

    public NotificationOrderAction(OrderAction wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public void act(Order order) {
        wrapped.act(order);
        System.out.println("Notification: Order status updated.");
    }
}
