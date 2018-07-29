package com.example.coremodel.http.service;



import com.example.coremodel.bean.base.BaseResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface UserService {
    @GET
    Observable<BaseResponse> getDynamicData(@Query("name") String name, @Query("password") String pwd);

}
