package com.example.notes.Notes.Service;

import org.springframework.stereotype.Component;

@Component("onlineOrderObject")
public class OnlineOrder implements Order{
    @Override
    public String createOrder() {
        return "Online order is created";
    }
}
