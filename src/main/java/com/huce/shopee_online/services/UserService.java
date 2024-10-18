package com.huce.shopee_online.services;

import com.huce.shopee_online.dto.UserDTO;
import com.huce.shopee_online.entities.Profile;
import com.huce.shopee_online.entities.User;
import com.huce.shopee_online.repositories.ProfileRepository;
import com.huce.shopee_online.repositories.UserRepository;
import com.huce.shopee_online.security.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    public UserRepository userRepository;

    @Autowired
    public ProfileRepository profileRepository;

    public User signUp(UserDTO userDTO){
        if((userRepository.findByEmail(userDTO.getEmail()) == null) &&
                (userRepository.findByPhone(userDTO.getPhone()) == null)
        )
        {
            User user = new User();
            user.setEmail(userDTO.getEmail());
            user.setPhone(userDTO.getPhone());
            user.setPassword(PasswordEncoder.getInstance().encodePassword(userDTO.getPassword()) );
            user.setActive(true);
            User result =  userRepository.save(user);
            Profile profile = new Profile();
            profile.setAddress("");
            profile.setFirstName("");
            profile.setLastName("");
            profile.setUser(result);
            Profile profileResult = profileRepository.save(profile);
            return  result;

        }else{
            return null;
        }
    }

    public User signIn(UserDTO userDTO){

        //Hash password and compare
        User u = userRepository.findByEmail(userDTO.getEmail());
        if(u != null){
            if (u.getPassword()
                    .equals(PasswordEncoder.getInstance()
                            .encodePassword(userDTO.getPassword()))){
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
        User result =  userRepository.save(user);
        Profile profile = new Profile();
        profile.setAddress("");
        profile.setFirstName("");
        profile.setLastName("");
        profile.setUser(result);
        Profile profileResult = profileRepository.save(profile);
        return result;
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
