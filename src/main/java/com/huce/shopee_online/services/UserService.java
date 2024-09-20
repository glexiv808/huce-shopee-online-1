package com.huce.shopee_online.services;

import com.huce.shopee_online.dto.UserDTO;
import com.huce.shopee_online.entities.User;
import com.huce.shopee_online.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    public UserRepository userRepository;


    public User signUp(UserDTO userDTO){
        if((userRepository.findByEmail(userDTO.getEmail()) == null) &&
                (userRepository.findByPhone(userDTO.getPhone()) == null)
        ){
            User user = new User();
            user.setEmail(userDTO.getEmail());
            user.setPhone(userDTO.getPhone());
            user.setPassword(userDTO.getPassword());
            user.setActive(true);

            return userRepository.save(user);
        }else{
            return null;
        }




    }

    public User signIn(UserDTO userDTO){
        User u = userRepository.findByEmail(userDTO.getEmail());
        if(u != null){
            if (u.getPassword() == userDTO.getPassword()){
                return u;
            }
        }

        return null;
    }



    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public User createUser(User user) {



        return userRepository.save(user);
    }

    public User updateUser(Long id, User userDetails) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));

        user.setPhone(userDetails.getPhone());
        user.setEmail(userDetails.getEmail());
        user.setPassword(userDetails.getPassword());

        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }








}
