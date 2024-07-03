package com.aj.springdemo1.api.service;

import com.aj.springdemo1.api.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {


    private List<User> userList;
    public UserService(){
        userList = new ArrayList<>();
        User user1 = new User(1, "aj", "Lutz");
        User user2 = new User(2, "aj1", "Lutz1");
        userList.addAll(Arrays.asList(user1, user2));
    }

    public Optional<User> getUser(Integer id) {
        Optional optional = Optional.empty();
        for (User user : userList){
            if(id == user.getId()){
                optional = Optional.ofNullable(user);
                return optional;
            }
        }
       return optional;
    }

    public List<User> getUsers() {
        return userList;
    }

    public User updateUser(User inputUser) {
        for(User existingUser : userList){
            if(inputUser.getId() == existingUser.getId()){
                System.out.println("Update is success");
                
                //this.userList.addAll(Arrays.asList(inputUser));
            }
        }

       return inputUser;
    }
}
