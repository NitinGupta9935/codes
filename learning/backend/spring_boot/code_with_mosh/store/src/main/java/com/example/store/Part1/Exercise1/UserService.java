package com.example.store.Part1.Exercise1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private NotificationService notificationService;

//    public UserService(UserRepository userRepository, NotificationService notificationService) {
//        this.userRepository = userRepository;
//        this.notificationService = notificationService;
//    }

    public void registerUser(User user) {
        if (userRepository.findByEmail(user.getEmail()) != null)
            throw new IllegalArgumentException("User with email " + user.getEmail() + " already exist");

        userRepository.save(user);
        notificationService.send("You have registered successfully ", user.getEmail());
    }
}
