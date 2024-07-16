package com.example.simple_api.MyAPI;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class User {
    private int id;
    private String firstName;
    private String secondName;
    private String emailId;
}
