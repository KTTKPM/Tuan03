package iuh.fit.se.payment.state;

import iuh.fit.se.payment.PaymentContext;

public class CompletedState implements PaymentState {
    @Override
    public void handle(PaymentContext context) {
        System.out.println("[State] Payment already completed.");
    }

    @Override
    public String name() {
        return "Completed";
    }
}
