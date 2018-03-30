package com.example.pc43.mydesigndemo.mydesigndemosdk;

import android.content.Context;
import android.provider.Settings;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

public class InterceptorHttpClientCreator {
    private static OkHttpClient defaultHttpClient;
    public static void createInterceptorHTTPClient(final Context context){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        defaultHttpClient = new OkHttpClient.Builder()
                .addInterceptor(
                        new Interceptor() {
                            @Override
                            public Response intercept(Chain chain) throws IOException {
                                Request request = chain.request().newBuilder()
                                        .addHeader("deviceId", Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID))
                                        .addHeader("deviceType","android")
                                        .build();
                                return chain.proceed(request);
                            }
                        })
                .readTimeout(2, TimeUnit.MINUTES)
                .addInterceptor(interceptor)
                .build();
    }

    public static boolean isHttpClientNull(){
        return defaultHttpClient == null;
    }

    static OkHttpClient getOkHttpClient(){
        if (defaultHttpClient != null){
            return defaultHttpClient;
        }
        return null;
    }
}
