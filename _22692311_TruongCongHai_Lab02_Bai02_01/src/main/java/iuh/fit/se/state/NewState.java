package iuh.fit.se.state;

public class NewState implements OrderState {
    @Override
    public void handle(Order order) {
        System.out.println("Checking order information...");
        order.setState(new ProcessingState());
    }
}
