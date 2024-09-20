package com.huce.shopee_online.repositories;

import com.huce.shopee_online.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long > {
    User findByEmail(String email);
    User findByPhone(String phone);
//    User findByAddress(String address);


}
