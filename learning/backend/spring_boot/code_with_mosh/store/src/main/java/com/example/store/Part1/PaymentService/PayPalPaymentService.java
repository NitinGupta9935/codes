package com.example.store.Part1.PaymentService;

//@Service("paypal")
public class PayPalPaymentService implements PaymentService {
    @Override
    public void processPayment(Double amount) {
        System.out.println("PAYPAL");
        System.out.println("Amount " + amount);
    }
}
