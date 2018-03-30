package com.example.pc43.mydesigndemo;

import com.example.pc43.mydesigndemo.models.Recycler;
import com.example.pc43.mydesigndemo.models.Userresponse;

public class ResponseSingleton {
    private static ResponseSingleton instance;
    private Userresponse userResponseData;
    private Recycler recycler;

    public static ResponseSingleton getInstance() {
        if (instance == null) {
            instance = new ResponseSingleton();
        }
        return instance;
    }

    private ResponseSingleton() {
    }

    public void setUserResponseData(Userresponse userResponseData) {
        this.userResponseData = userResponseData;
    }

    public Userresponse getUserResponseData() {
        return userResponseData;
    }

    public Recycler getRecycler() {
        return recycler;
    }

    public void setRecycler(Recycler recycler) {
        this.recycler = recycler;
    }
}
