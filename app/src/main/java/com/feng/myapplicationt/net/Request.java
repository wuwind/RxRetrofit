package com.feng.myapplicationt.net;

import com.feng.myapplicationt.model.UserBean;
import com.feng.myapplicationt.model.ZhuangbiImage;

import java.util.List;

import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;
import rx.Observable;

/**
 * Created by Wuhf on 2016/3/24.
 * Description ：请求接口
 */
public interface Request {

    String baseUrl = "https://api.github.com";
    String zhuangbiUrl = "http://zhuangbi.info";

    //获取个人信息
    @GET("/users/{user}")
    Observable<UserBean> getUser(@Path("user") String user);

    //获取图
    @GET("/search")
    Observable<List<ZhuangbiImage>> search(@Query("q") String query);

}
