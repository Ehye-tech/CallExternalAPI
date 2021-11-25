package com.antra.validationwithuserapi.Controller;

import com.antra.validationwithuserapi.Entity.User;
import com.antra.validationwithuserapi.Repository.UserRepository;
import com.antra.validationwithuserapi.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.antra.validationwithuserapi.Entity.Info;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UserController {

    @Autowired
    UserService service;

    @Autowired
    UserRepository userRepository;

    @PostMapping("/user")
    public ResponseEntity<?> getValidateUserEmail(@RequestBody Info info) {
        if (service.isValidUser(info)) {
            String userEmail = service.callEmailFromValidUser(info);
            return new ResponseEntity<>(userEmail, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
        }
    }
}

