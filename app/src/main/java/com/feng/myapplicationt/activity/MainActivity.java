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

public class MainActivity extends Activity {

    private String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Observable observable2 = Observable.create(observableAction);
//        observable.subscribe(mSubsciber);
//        observable.subscribe(mSubsciber2);
//        observable2.subscribe(mSubsciber2);
//        observable2.subscribe(mSubsciber2);
//        observable2.subscribe(actionSubscriber);
//        observable2.subscribe(actionSubscriber,onErrorAction, onCompleteAction);

        observable2.just("123a", "1234f").subscribe(onErrorAction);
        observable2.subscribe(onErrorAction);
    }

    Observable observable = Observable.create(new OnSubscribe<String>() {
        @Override
        public void call(Subscriber<? super String> subscriber) {
            String msg = "hello world1111";
            subscriber.onNext(msg);
            subscriber.onCompleted();
        }
    });

    OnSubscribe<String> observableAction = new OnSubscribe<String>() {
        @Override
        public void call(Subscriber<? super String> subscriber) {
            String msg = "hello world2222";
            subscriber.onNext(msg);
            subscriber.onCompleted();
        }
    };


    Subscriber<String> mSubsciber = new Subscriber<String>() {
        @Override
        public void onCompleted() {
            Log.e(TAG, "onCompleted: ");
        }

        @Override
        public void onError(Throwable e) {

        }

        @Override
        public void onNext(String s) {
            Log.e(TAG, "onNext: " + s);
        }
    };

    Subscriber<String> mSubsciber2 = new Subscriber<String>() {
        @Override
        public void onCompleted() {
            Log.e(TAG, "onCompleted2: ");
        }

        @Override
        public void onError(Throwable e) {

        }

        @Override
        public void onNext(String s) {
            Log.e(TAG, "onNext2: " + s);
        }
    };

    Action1<String> actionSubscriber = new Action1<String>() {
        @Override
        public void call(String s) {
            Log.e(TAG, "actionSubscriber: " + s);
        }

    };

    Action1<String> onErrorAction = new Action1<String>() {
        @Override
        public void call(String s) {
            Log.e(TAG, "onErrorAction---: " + s);
        }

    };

    Action0 onCompleteAction = new Action0() {
        @Override
        public void call() {
            Log.e(TAG, "onCompleteAction---: ");
        }
    };
}
