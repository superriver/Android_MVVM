package com.example.coremodel;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {


    public static <T> T initService(String baseUrl,Class<T> clazz)
    {
            return initRetrofit().create(clazz);
    }

    public static Retrofit initRetrofit(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(getClient())
                .build();
        return retrofit;
    }

    public static OkHttpClient getClient(){
        OkHttpClient client = new OkHttpClient.Builder()
                .build();
        return client;
    }

}
