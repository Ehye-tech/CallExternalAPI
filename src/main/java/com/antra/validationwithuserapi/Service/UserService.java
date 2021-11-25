package com.antra.validationwithuserapi.Service;

import com.antra.validationwithuserapi.Entity.Info;
import com.antra.validationwithuserapi.Entity.User;
import com.antra.validationwithuserapi.Entity.UserWrapper;
import com.antra.validationwithuserapi.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

    public String callEmailFromValidUser(Info info){
        RestTemplate restTemplate = new RestTemplate();
        UserWrapper userPage = restTemplate.getForObject(GET_USER_API+"/?userName="+info.getUserName(), UserWrapper.class);
        List<User> users = userPage.getData();
        String email = getEmailFromUser(users,"Emma");
        return email;
    }

    public String getEmailFromUser(List<User> users, String firstName){
        for(User user : users){
            if(user.getFirstName().equals(firstName)){
                return user.getEmail();
            }
        }
        return null;
    }

}
