package com.example.store.Part1;

import com.example.store.Part1.PaymentService.PayPalPaymentService;
import com.example.store.Part1.PaymentService.PaymentService;
import com.example.store.Part1.PaymentService.StripePaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {

    @Value("${payment-gateway:stripe}")
    private String paymentGateway;

    @Bean
    public PaymentService strip() {
        return new StripePaymentService();
    }

    @Bean
    public PaymentService paypal() {
        return  new PayPalPaymentService();
    }

    @Bean
    @Scope("prototype")
    public OrderService orderService() {

        return new OrderService(paymentGateway.equals("strip")? strip(): paypal());
    }

}
