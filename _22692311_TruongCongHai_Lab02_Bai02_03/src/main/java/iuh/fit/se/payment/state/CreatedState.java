package iuh.fit.se.payment.state;

import iuh.fit.se.payment.PaymentContext;

public class CreatedState implements PaymentState {
    @Override
    public void handle(PaymentContext context) {
        System.out.println("[State] Created -> Processing");
        context.setState(new ProcessingState());
    }

    @Override
    public String name() {
        return "Created";
    }
}
