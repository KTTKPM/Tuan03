package iuh.fit.se;

import iuh.fit.se.decorator.BasicOrderAction;
import iuh.fit.se.decorator.LoggingOrderAction;
import iuh.fit.se.decorator.NotificationOrderAction;
import iuh.fit.se.decorator.OrderAction;
import iuh.fit.se.state.CancelledState;
import iuh.fit.se.state.NewState;
import iuh.fit.se.state.Order;
import iuh.fit.se.strategy.FullRefund;

public class Main {
    public static void main(String[] args) {
        Order order = new Order(new NewState());

        // Decorator: Logging and Notification
        OrderAction action = new NotificationOrderAction(
                new LoggingOrderAction(
                        new BasicOrderAction()));

        // State transitions
        action.act(order); // New -> Processing
        action.act(order); // Processing -> Delivered

        // Cancelled with Strategy
        order.setState(new CancelledState(new FullRefund()));
        action.act(order); // Cancelled -> Refund
    }
}