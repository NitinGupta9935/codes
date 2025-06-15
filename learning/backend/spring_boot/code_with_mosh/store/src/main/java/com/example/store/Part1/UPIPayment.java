package com.example.store.Part1;

import org.springframework.stereotype.Component;

@Component
public class UPIPayment implements Payment {
    @Override
    public void pay() {
        System.out.println("Pay by using UPI ");
    }
}
