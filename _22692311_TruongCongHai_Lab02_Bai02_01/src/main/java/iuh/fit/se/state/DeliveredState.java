package iuh.fit.se.state;

public class DeliveredState implements OrderState {
    @Override
    public void handle(Order order) {
        System.out.println("Order delivered. Updating status...");
    }
}
