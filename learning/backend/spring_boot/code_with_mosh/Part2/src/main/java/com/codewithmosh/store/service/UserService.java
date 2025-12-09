package com.codewithmosh.store.service;

import com.codewithmosh.store.entities.User;
import com.codewithmosh.store.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    public UserRepository userRepository;

    public void addUser(long id) {
        User user = new User();
//        user.setId(id);
        user.setName("Name" + id);
        user.setEmail("Example" + id + "@gmail.com");
        int password = (int) (Math.random() * 1000);
        System.out.println(password);
        user.setPassword(Integer.toString(password));

        userRepository.save(user);
    }


}
