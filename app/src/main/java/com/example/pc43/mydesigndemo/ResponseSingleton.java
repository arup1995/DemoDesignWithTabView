package com.example.pc43.mydesigndemo;

import com.example.pc43.mydesigndemo.models.Recycler;
import com.example.pc43.mydesigndemo.models.UserResponse;

public class ResponseSingleton {
    private static ResponseSingleton instance;
    private UserResponse userResponseData;


    public static ResponseSingleton getInstance() {
        if (instance == null) {
            instance = new ResponseSingleton();
        }
        return instance;
    }

    private ResponseSingleton() {
    }

    public void setUserResponseData(UserResponse userResponseData) {
        this.userResponseData = userResponseData;
    }

    public UserResponse getUserResponseData() {
        return userResponseData;
    }


}
