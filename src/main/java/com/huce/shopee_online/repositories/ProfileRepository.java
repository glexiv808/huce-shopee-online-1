package com.huce.shopee_online.repositories;

import com.huce.shopee_online.entities.Profile;
import com.huce.shopee_online.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {
    Optional<Profile> findByUser(User user);


}

