package com.example.coremodel.http.repository;

import com.example.coremodel.RequestService;
import com.example.coremodel.bean.base.BaseResponse;

public class UserRepository {

    public static io.reactivex.Observable<BaseResponse> load(String name, String pwd){
        return RequestService.getUser().getDynamicData(name,pwd);
    }

}
