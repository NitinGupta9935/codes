package com.example.store.Part1.PaymentService;

import org.springframework.beans.factory.annotation.Value;

import java.util.List;

//@Service("stripe")
public class StripePaymentService implements PaymentService {
    @Value("${stripe.apiUrl}")
    private String apiUrl;

    @Value("${stripe.enable}")
    private boolean enabled;

//    give default value if timeout is not present in application.properties file
    @Value("${stripe.timeout:3000}")
    private int timeout;

    @Value("${stripe.supported-currencies}")
    private List<String> supportedCurrencies;

    @Override
    public void processPayment(Double amount) {
        System.out.println("STRIPE");
        System.out.println("API URL: " + apiUrl);
        System.out.println("Enable: " + enabled);
        System.out.println("Timeout: " + timeout);
        System.out.println("Currencies: " + supportedCurrencies);
        System.out.println("Amount: " + amount);
    }
}
