package iuh.fit.se;

import iuh.fit.se.payment.BasePayment;
import iuh.fit.se.payment.Payment;
import iuh.fit.se.payment.PaymentContext;
import iuh.fit.se.payment.decorator.DiscountCodeDecorator;
import iuh.fit.se.payment.decorator.ProcessingFeeDecorator;
import iuh.fit.se.payment.strategy.CreditCardStrategy;
import iuh.fit.se.payment.strategy.PayPalStrategy;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Payment creditCardPayment = new BasePayment(
                "ORD-001",
                new BigDecimal("100.00"),
                new CreditCardStrategy("Truong Cong Hai", "**** **** **** 1234")
        );
        creditCardPayment = new ProcessingFeeDecorator(creditCardPayment, new BigDecimal("2.5"));
        creditCardPayment = new DiscountCodeDecorator(creditCardPayment, "SAVE10", new BigDecimal("10"));

        Payment paypalPayment = new BasePayment(
                "ORD-002",
                new BigDecimal("80.00"),
                new PayPalStrategy("hai.student@example.com")
        );
        paypalPayment = new DiscountCodeDecorator(paypalPayment, "SAVE5", new BigDecimal("5"));
        paypalPayment = new ProcessingFeeDecorator(paypalPayment, new BigDecimal("3"));

        PaymentContext context1 = new PaymentContext(creditCardPayment);
        context1.process();

        PaymentContext context2 = new PaymentContext(paypalPayment);
        context2.process();

        System.out.println("\n=== Conclusion ===");
        System.out.println("State Pattern: quản lý vòng đời thanh toán (Created -> Processing -> Completed/Failed).");
        System.out.println("Strategy Pattern: thay đổi phương thức thanh toán (Credit Card, PayPal) mà không sửa luồng xử lý.");
        System.out.println("Decorator Pattern: thêm phí xử lý/mã giảm giá linh hoạt, có thể kết hợp theo nhu cầu.");
    }
}