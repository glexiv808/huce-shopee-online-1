package com.huce.shopee_online.database;

import com.huce.shopee_online.entities.Profile;
import com.huce.shopee_online.entities.User;
import com.huce.shopee_online.repositories.ProfileRepository;
import com.huce.shopee_online.repositories.UserRepository;
import com.huce.shopee_online.security.PasswordEncoder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Database {
// @@Configuration = TU khoa nay co nghia la cau hinh he thong, se duoc khoi dong khi khoi dong server
    // Trong database se tao san cac du lieu Seeding
    // Co nghia la du lieu muon sinh ra san khi khoi dong server

    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository, ProfileRepository profileRepository
    ) {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                userRepository.deleteAll();
                profileRepository.deleteAll();
                if(userRepository.findAll().size()==0)
                {
                    User user = new User();
                    user.setActive(true);
                    user.setPhone("0965741051");
                    user.setEmail("dinhvandong@huce.com.vn");
                    user.setPassword(PasswordEncoder.getInstance().encodePassword("Abcd1234@"));

                    User result =   userRepository.save(user);
                    System.out.println("result_user:"+ user.toString());
                    Profile profile = new Profile();
                    profile.setAddress("Ha Noi, Vietnam");
                    profile.setFirstName("Dong");
                    profile.setLastName("Dinh");
                    profile.setUser(result);
                    profileRepository.save(profile);



                }

            }
        };
    }



}
