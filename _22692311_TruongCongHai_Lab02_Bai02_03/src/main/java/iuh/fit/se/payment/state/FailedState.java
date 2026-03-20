package iuh.fit.se.payment.state;

import iuh.fit.se.payment.PaymentContext;

public class FailedState implements PaymentState {
    @Override
    public void handle(PaymentContext context) {
        System.out.println("[State] Payment failed. Stop processing.");
    }

    @Override
    public String name() {
        return "Failed";
    }
}
