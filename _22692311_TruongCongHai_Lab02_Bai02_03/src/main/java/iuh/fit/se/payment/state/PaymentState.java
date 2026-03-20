package iuh.fit.se.payment.state;

import iuh.fit.se.payment.PaymentContext;

public interface PaymentState {
    void handle(PaymentContext context);

    String name();
}
