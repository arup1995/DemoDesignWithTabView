package com.example.pc43.mydesigndemo.mydesigndemosdk;

import com.example.pc43.mydesigndemo.models.Userresponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Service {
    @GET("/bins/18jxyv")
    Call<Userresponse> requestUserDetails();
}
