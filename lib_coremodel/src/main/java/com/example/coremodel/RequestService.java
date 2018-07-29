package com.example.coremodel;

import com.example.coremodel.http.service.UserService;

public class RequestService {
    public static UserService getUser(){
        return ApiClient.initService("", UserService.class);
    }
}
