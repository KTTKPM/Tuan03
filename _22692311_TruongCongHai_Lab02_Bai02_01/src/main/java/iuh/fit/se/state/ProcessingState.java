package iuh.fit.se.state;

public class ProcessingState implements OrderState {
    @Override
    public void handle(Order order) {
        System.out.println("Packing and shipping order...");
        order.setState(new DeliveredState());
    }
}
