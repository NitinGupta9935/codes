package com.example.notes.Notes.Controller;

import com.example.notes.Notes.Service.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Qualifier("onlineOrderObject")
    @Autowired
    Order order;

    @GetMapping(value = "/")
    public String isWorking() {
        return "It is Working ";
    }


    @GetMapping(value = "/value")
    public String getValue(@Value("${day}") int day) {
        return "value is " + day;
    }

    @GetMapping(value = "/order")
    public String order() {
        return order.createOrder();
    }
}
