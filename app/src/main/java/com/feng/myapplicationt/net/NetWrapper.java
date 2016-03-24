package com.feng.myapplicationt.net;

import com.feng.myapplicationt.adapter.UserInfoAdapter;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


/**
 * Created by Wuhf on 2016/3/24.
 * Description ：
 */
public class NetWrapper {

    private static final String[] mFamousUsers =
            {"wuWind", "SpikeKing", "JakeWharton", "rock3r", "Takhion", "dextorer", "Mariuxtheone"};

    public static void getUserInfo(UserInfoAdapter adapter) {

        Request request = RequestFactory.createRequsetFrom(Request.class);

        Observable.from(mFamousUsers)
                .flatMap(request::getUser)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(adapter::addUser);
    }


}
