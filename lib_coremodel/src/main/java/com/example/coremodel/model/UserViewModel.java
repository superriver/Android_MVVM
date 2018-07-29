package com.example.coremodel.model;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.example.coremodel.bean.UserBean;
import com.example.coremodel.bean.base.BaseResponse;
import com.example.coremodel.http.repository.UserRepository;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class UserViewModel extends AndroidViewModel {
    private UserBean userBean;

    public final MutableLiveData<UserBean> data = new MutableLiveData<>();
    public UserViewModel(@NonNull Application application) {
        super(application);
    }

    private void loadData(){
        UserRepository.load("","")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BaseResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BaseResponse baseResponse) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
