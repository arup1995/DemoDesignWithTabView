package com.example.pc43.mydesigndemo.mydesigndemosdk;

import android.content.Context;

import com.example.pc43.mydesigndemo.R;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyDesignDemoSdk {
    private final Retrofit retrofit;
    private Service service;

    public MyDesignDemoSdk(Retrofit retrofit) {
        this.retrofit = retrofit;
        createService();
    }

    /**
     * Builder for {@link MyDesignDemoSdk}
     */
    public static class Builder {
        public Builder() {
        }

        /**
         * Create the {@link MyDesignDemoSdk} to be used.
         *
         * @return {@link MyDesignDemoSdk}
         */
        public MyDesignDemoSdk build(Context context) {
            Retrofit retrofit = null;
            if (InterceptorHttpClientCreator.getOkHttpClient() != null) {
                retrofit = new Retrofit.Builder()
                        .addConverterFactory(GsonConverterFactory.create())
                        .client(InterceptorHttpClientCreator.getOkHttpClient())
                        .baseUrl(context.getResources().getString(R.string.base_url))
                        .build();

                return new MyDesignDemoSdk(retrofit);
            } else {
                retrofit = new Retrofit.Builder()
                        .addConverterFactory(GsonConverterFactory.create())
//                        .client(InterceptorHTTPClientCreator.getOkHttpClient())
                        .baseUrl(context.getResources().getString(R.string.base_url))
                        .build();
            }
            return new MyDesignDemoSdk(retrofit);
        }
    }

    private void createService() {
        service = retrofit.create(Service.class);
    }

    public Service getService(){
        return service;
    }
}
