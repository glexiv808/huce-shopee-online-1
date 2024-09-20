package com.huce.shopee_online.controllers;

import com.huce.shopee_online.dto.ResponseObject;
import com.huce.shopee_online.dto.UserDTO;
import com.huce.shopee_online.entities.User;
import com.huce.shopee_online.services.UserService;
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


    @PostMapping("/signUp")
    public ResponseEntity<?> signUp(@RequestBody UserDTO user) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(
                        new ResponseObject(200, "OK",
                                userService.signUp(user)));


    }

    @PostMapping("/signIn")
    public ResponseEntity<?> signIn(@RequestBody UserDTO user) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(
                        new ResponseObject(200, "OK",
                                userService.signIn(user)));

    }


}
