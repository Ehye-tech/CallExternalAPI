package com.antra.validationwithuserapi.Service;

import com.antra.validationwithuserapi.Entity.Info;
import com.antra.validationwithuserapi.Entity.User;
import com.antra.validationwithuserapi.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class UserService {

    private static final String GET_USER_API = "https://reqres.in/api/users";

    @Autowired
    private UserRepository userRepository;

    public boolean isValidUser(Info info){
        if (!info.getUserName().equals("Emma")) {
            return false;
        }
        if (!info.getPassword().equals("1234")) {
            return false;
        }
        return true;
    }

    public List<User> saveAllUser(Info info){
        RestTemplate restTemplate = new RestTemplate();
        User[] users = restTemplate.getForObject(GET_USER_API+"/?userName="+info.getUserName(),User[].class);
//        User[] users = restTemplate.getForObject(GET_USER_API,User[].class);
        List<User> usersList = Arrays.asList(users);
        return userRepository.saveAll(usersList);
    }

    public String getEmail(String firstName){
        User user = userRepository.findByFirstName(firstName);
        return user.getEmail();
    }

}
