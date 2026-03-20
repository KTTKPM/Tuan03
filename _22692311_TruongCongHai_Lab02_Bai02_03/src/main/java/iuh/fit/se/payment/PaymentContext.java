package iuh.fit.se.payment;

import iuh.fit.se.payment.state.CompletedState;
import iuh.fit.se.payment.state.CreatedState;
import iuh.fit.se.payment.state.FailedState;
import iuh.fit.se.payment.state.PaymentState;

public class PaymentContext {
    private final Payment payment;
    private PaymentState state;

    public PaymentContext(Payment payment) {
        this.payment = payment;
        this.state = new CreatedState();
    }

    public void process() {
        System.out.println("\n=== New Payment ===");
        System.out.println("Details: " + payment.getDetails());
        System.out.println("Method: " + payment.getStrategy().getMethodName());
        System.out.println("Final amount: " + payment.getAmount());

        while (!(state instanceof CompletedState) && !(state instanceof FailedState)) {
            state.handle(this);
        }

        System.out.println("Result state: " + state.name());
    }

    public Payment getPayment() {
        return payment;
    }

    public PaymentState getState() {
        return state;
    }

    public void setState(PaymentState state) {
        this.state = state;
    }
}
