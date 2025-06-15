package com.example.store.repository;

import com.example.store.dtos.UserSummary;
import com.example.store.entities.Profile;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {

//    4.9.7
    @EntityGraph(attributePaths = {"user"})
    @Query(value = "select p.id as id, p.user.email as email from Profile p where p.loyaltyPoints > :max order by p.user.email")
    List<UserSummary> findProfiles(@Param("max") int max);

//    List<Profile> findByLoyaltyPointsGreaterThan(int loyaltyPoints);

//    List<Profile> findByLoyaltyPointsGreaterThanOrderByUserEmail(int loyaltyPoints);

}
