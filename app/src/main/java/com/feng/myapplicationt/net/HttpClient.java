package com.feng.myapplicationt.net;

import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


/**
 * Created by Wuhf on 2016/3/24.
 * Description ：
 */
public class HttpClient {

    static Request request = RequestFactory.createRequsetFrom(Request.zhuangbiUrl);

    public static Subscription getZhuangbiInfo(String key, Observer observer) {
        Observable search = request.search(key);
        return subNext(search, observer);
    }

    private static Subscription subNext(Observable observable, Observer observer) {
        return  observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }


}
