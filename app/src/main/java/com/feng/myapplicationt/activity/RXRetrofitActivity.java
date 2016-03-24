package com.feng.myapplicationt.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.feng.myapplicationt.R;
import com.feng.myapplicationt.model.UserBean;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by Wuhf on 2016/3/24.
 * Description ：
 */
public class RXRetrofitActivity extends Activity {

    private String TAG = "RXRetrofitActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getData();
    }

    /*2.http api接口*/
    public interface IData {
        @FormUrlEncoded
        @POST("/index.php")
        Observable<UserBean> rxpost(@Field("username") String username, @Field("password") String password);
        @GET("/users/{user}")
        Observable<UserBean> getUser(@Path("user") String user);
    }

    public void getData() {
        //3.在retrofit中添加RxJavaCallAdapterFactory
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
//                .baseUrl("http://192.168.1.214")
                .build();


        IData service = retrofit.create(IData.class);
        Observable<UserBean> observable = service.rxpost("quanshijie", "123456");
//        Observable<UserBean> observable = service.getUser("wuwind");
        observable.observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.newThread()).subscribe(new Action1<UserBean>() {
            @Override
            public void call(UserBean des) {
                Log.e(TAG, "call: " + des.getLogin().toString());
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                Log.e(TAG, "call: " + throwable.getLocalizedMessage());
            }
        });
    }


}
