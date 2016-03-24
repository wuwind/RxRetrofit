package com.feng.myapplicationt.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.feng.myapplicationt.R;

import java.io.IOException;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;

public class RetrofitActivity extends Activity {

    private String TAG = "RetrofitActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // 假设 baseurl = "http://baidu.com"    @GET("/s")    Call<gitmodel>onekey(@Query("wd") String wdvalue);

        //Call<gitmodel>manykey(@QueryMap Map<string, string="">options);


        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.github.com").addConverterFactory(GsonConverterFactory.create()).build();
        gitapi service = retrofit.create(gitapi.class);
//        Call<UserBean> model = service.getFeed("wuwind");
//        model.enqueue(new Callback<UserBean>() {
//                          @Override
//                          public void onResponse(Response<UserBean> response, Retrofit retrofit) {
//                              Log.e(TAG, "onResponse: " + response.body().getLogin());
//                          }
//
//                          @Override
//                          public void onFailure(Throwable t) {
//                              Log.e(TAG, "onFailure: " + t.getMessage());
//                          }
//                      }
//
//        );
    }


    public interface gitapi {
        //        @GET("/users/{user}")
//        Call<UserBean> getFeed(@Path("user") String user);


        //        @POST("/index.php")
//        Call<Des> post(@Body User user);


        @FormUrlEncoded
        @POST("/index.php")
        Call<Des> form(@Field("username") String username, @Field("password") String password);

//        @GET("/user")
//        Call<User> getUser(@Header("Authorization") String authorization);

//        @Headers({"Accept: application/vnd.github.v3.full+json", "User-Agent: Retrofit-Sample-App"})
    }


    public void getData() {
        Retrofit retrofit = new Retrofit.Builder()//
                .baseUrl("https://api.github.com").baseUrl("http://192.168.1.214").addConverterFactory(GsonConverterFactory.create()).build();
        gitapi service = retrofit.create(gitapi.class);

//        Call<Des> model = service.post(new User("guolei", "123456"));

        Call<Des> model = service.form("guolei", "123456");

        //同步请求
        //
        try {
            model.execute().body().getDes();
        } catch (IOException e) {
            e.printStackTrace();
        }

        model.enqueue(new Callback<Des>() {
            @Override
            public void onResponse(Response<Des> response, Retrofit retrofit) {
                Log.e(TAG, "onResponse: " + response.body().getDes());
            }

            @Override
            public void onFailure(Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage());
            }
        });
    }


    class Des {
        public String des;

        public String getDes() {
            return des;
        }

        public void setDes(String des) {
            this.des = des;
        }
    }

    class User {
        public String username;
        public String password;

        public User(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }

}
