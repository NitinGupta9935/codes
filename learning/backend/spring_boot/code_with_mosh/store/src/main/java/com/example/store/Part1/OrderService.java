package com.example.store.Part1;

import com.example.store.Part1.PaymentService.PaymentService;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private PaymentService paymentService;

    public OrderService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void placeOrder() {
        paymentService.processPayment((double) 10);
    }
}
