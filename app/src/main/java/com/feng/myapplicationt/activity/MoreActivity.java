package com.feng.myapplicationt.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.feng.myapplicationt.R;

import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Subscriber;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.functions.Func2;

public class MoreActivity extends Activity {

    private String TAG = "MoreActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] msgs = new String[]{"111s11", "2222aaa222", "333sdsss3333"};

//        Observable.just("11111", "2222222", "3333333")
//                .subscribe(new Action1<String>() {
//                    @Override
//                    public void call(String s) {
//                        Log.e(TAG, "call: " + s );
//                    }
//                });

//        //输出数组
//        Observable.from(msgs).subscribe(new Action1<String>() {
//            @Override
//            public void call(String s) {
//                Log.e(TAG, "call Observable.from : " + s );
//            }
//        });

        //映射后分发
//        Observable.from(msgs).map(upFunc).subscribe(strAction);

        Observable.just(msgs).flatMap(f1).reduce(f2).subscribe(strAction);

    }

    Action1<String> strAction = new Action1<String>() {
        @Override
        public void call(String s) {
            Log.e(TAG, "call Observable.from : " + s);
        }
    };

    // 设置映射函数
    Func1 f1 = new Func1<String[], Observable<String>>() {
        @Override
        public Observable<String> call(String[] strings) {
            return Observable.from(strings);// 映射字符串
        }
    };

    Func2 f2 = new Func2<String, String, String>() {
        @Override
        public String call(String s, String s2) {
            return String.format("%s -- %s", s, s2);
        }
    };

    // 设置映射函数---转换大写
    Func1 upFunc = new Func1<String, String>() {
        @Override
        public String call(String s) {
            return s.toUpperCase();
        }
    };
}
