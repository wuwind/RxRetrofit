package com.feng.myapplicationt.net;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

/**
 * Created by Wuhf on 2016/3/24.
 * Description ：
 */
public class RequestFactory {

    public static <T> T createRequsetFrom(Class<T> classServer) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Request.baseUrl)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())//添加Rx适配器
                .addConverterFactory(GsonConverterFactory.create())//添加Gson转换器
                .build();

        return retrofit.create(classServer);

    }

}
