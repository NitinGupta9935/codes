package com.example.store.repository;

import com.example.store.dtos.UserSummary;
import com.example.store.entities.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    // Entity Graph
//    Entity Graph is used to control which relationships (associations) are eagerly fetched from the database
//    @EntityGraph(attributePaths = "tags")
    @EntityGraph(attributePaths = {"tags", "addresses"})
    Optional<User> findByEmail(String name);

    @Query(value = "select u.id as id, u.email as email from User u where u.profile.loyaltyPoints > :max order by u.email")
    List<UserSummary> findProfiles(@Param("max") int max);

}
