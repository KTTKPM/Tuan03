package iuh.fit.se.payment.state;

import iuh.fit.se.payment.PaymentContext;

public class ProcessingState implements PaymentState {
    @Override
    public void handle(PaymentContext context) {
        System.out.println("[State] Processing payment...");
        boolean success = context.getPayment()
                .getStrategy()
                .pay(context.getPayment().getAmount());

        if (success) {
            context.setState(new CompletedState());
        } else {
            context.setState(new FailedState());
        }
    }

    @Override
    public String name() {
        return "Processing";
    }
}
