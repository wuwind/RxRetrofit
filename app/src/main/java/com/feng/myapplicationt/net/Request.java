package com.feng.myapplicationt.net;

import com.feng.myapplicationt.model.UserBean;

import retrofit.http.GET;
import retrofit.http.Path;
import rx.Observable;

/**
 * Created by Wuhf on 2016/3/24.
 * Description ：请求接口
 */
public interface Request {

    String baseUrl = "https://api.github.com";

    //获取个人信息
    @GET("/users/{user}")
    Observable<UserBean> getUser(@Path("user") String user);

}
