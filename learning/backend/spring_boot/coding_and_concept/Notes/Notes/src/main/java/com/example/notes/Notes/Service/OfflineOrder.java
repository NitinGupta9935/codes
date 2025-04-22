package com.example.notes.Notes.Service;

import org.springframework.stereotype.Component;

@Component("offlineOrderObject")
public class OfflineOrder implements Order{
    @Override
    public String createOrder() {
        return "Offline order is created";
    }
}
