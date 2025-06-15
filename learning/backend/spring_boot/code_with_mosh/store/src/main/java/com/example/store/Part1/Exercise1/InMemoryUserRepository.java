package com.example.store.Part1.Exercise1;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class InMemoryUserRepository implements UserRepository{
    private final Map<String, User> users = new HashMap<>();

    @Override
    public void save(User user) {
        System.out.println(user.getName() + " is saved");
        users.put(user.getEmail(), user);
    }

    @Override
    public User findByEmail(String email) {
        return users.getOrDefault(email, null);
    }
}
