package com.huce.shopee_online.controllers;

import com.huce.shopee_online.dto.ResponseObject;
import com.huce.shopee_online.dto.UserDTO;
import com.huce.shopee_online.entities.User;
import com.huce.shopee_online.jwt.JwtTokenStore;
import com.huce.shopee_online.security.PasswordEncoder;
import com.huce.shopee_online.services.AuthService;
import com.huce.shopee_online.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")

public class AuthController {



    @Autowired
    UserService userService;
    @Autowired
    AuthService authService;

    @Operation(summary = "Get example data")
    @ApiResponse(responseCode = "200", description = "Successful operation")
    @PostMapping("/signUp")
    public ResponseEntity<?> signUp(@RequestBody UserDTO user) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(
                        new ResponseObject(200, "OK",
                                userService.signUp(user)));
    }

    @PostMapping("/signin")
    public ResponseEntity<?> signIn(@RequestBody UserDTO userDTO) {
        User user = userService.userRepository.findByEmail((userDTO.getEmail()));
        if (user==null || !PasswordEncoder.getInstance().matches(userDTO.getPassword(), user.getPassword())) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ResponseObject(201,  "User not found",user));
        }
        String token = authService.loginWithEmailAndPassword(userDTO.getEmail(), userDTO.getPassword());
        JwtTokenStore.getInstance().storeToken(userDTO.getEmail(), token);
        return ResponseEntity.status(HttpStatus.OK).body
                (new ResponseObject(200,token,user));
    }
}
