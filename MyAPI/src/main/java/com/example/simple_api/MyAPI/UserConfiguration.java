package com.example.simple_api.MyAPI;


import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserConfiguration {

    //sample pull request
    private List<User> users = new ArrayList<>();
    //get all user
    @GetMapping("/api/users/")
    public List<User> getUsers(){
        return users;
    }
    //get user by ID
    @GetMapping("/api/users/{id}")
    public User getUserId(@PathVariable int id){
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    //add user details to database
    @PostMapping("/api/users/add/details")
    public User createUser(@RequestBody User user){
        users.add(user);
        return user;
    }

    @PutMapping("/api/users/update/{id}")
    public String updateUser(@PathVariable int id, @RequestBody User updatedUser){
        for(User user : users){
            if(user.getId() == id){
                user.setFirstName(updatedUser.getFirstName());
                user.setSecondName(updatedUser.getSecondName());
                user.setEmailId(updatedUser.getEmailId());
                return "User with ID: "+id+" has been updated";
            }
        }
        return "User with ID: "+id+" has not found.";
    }

    //delete user by ID
    @DeleteMapping("/api/users/delete/{id}")
    public String deleteUser(@PathVariable int id){
        User removeUser = null;
        for(User user : users) {
            if(user.getId()==id){
                removeUser=user;
                break;
            }
        }
        if(removeUser != null){
            users.remove(removeUser);
            return "User with ID: "+id+ " has been deleted";
        }
        else{
            return "User with ID: "+id+ " has not Found.";
        }
    }
}
