package com.example.store.services;

import com.example.store.entities.Address;
import com.example.store.entities.User;
import com.example.store.repository.AddressRepository;
import com.example.store.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;
    private final UserRepository userRepository;

    public Address addAddress() {
        User user = userRepository.findById(3L).orElseThrow();

        Address address = Address.builder()
                .street("street")
                .city("city")
                .zip("zip")
                .state("state")
                .user(user)
                .build();

        addressRepository.save(address);

        return address;
    }

    public Address retriveAddress() {
        Address address = addressRepository.findById(1L).orElseThrow();

        System.out.println(address);

        return address;
    }

}
