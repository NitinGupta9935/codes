package com.example.store.Part1.Exercise1;

public interface UserRepository {
    public void save(User User);
    User findByEmail(String email);
}
