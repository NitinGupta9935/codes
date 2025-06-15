package com.example.store.services;

import com.example.store.dtos.UserSummary;
import com.example.store.entities.Profile;
import com.example.store.entities.User;
import com.example.store.repository.ProfileRepository;
import com.example.store.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class ProfileService {

    private final ProfileRepository profileRepository;
    private final UserRepository userRepository;

    @Transactional
    public void addProfiles() {
        Iterable<User> userIterable = userRepository.findAll();

        int count = 5;
        for (User user: userIterable) {
            int random = (int) (Math.random() * 10) % 10;
            count = count + random;
//			addProfile(count, user);
            Profile profile = getProfile(count, user);
            profileRepository.save(profile);
        }
    }

    public static Profile getProfile(int point, User user) {
        LocalDate date = LocalDate.of(1950 + point, 4, point);

        Profile profile = Profile.builder()
                .bio("bio")
                .phoneNumber("2343"+ point)
                .dateOfBirth(date)
                .loyaltyPoints(point)
                .user(user)
                .build();

//		ProfileService profileService = context.getBean(ProfileService.class);
//		profileService.addProfile(profile);
        return profile;
    }

    @Transactional
    public void getProfiles() {
        List<UserSummary> profiles = profileRepository.findProfiles(15);
        for (UserSummary userSummary: profiles) {
            System.out.println(userSummary.getId());
            System.out.println(userSummary.getEmail());
        }

    }
}
