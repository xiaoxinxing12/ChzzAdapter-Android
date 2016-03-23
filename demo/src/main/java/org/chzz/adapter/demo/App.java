package org.chzz.adapter.demo;

import android.app.Application;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * 作者:copy 邮件:2499551993@qq.com
 * 创建时间:15/6/21 下午10:13
 * 描述:
 */
public class App extends Application {
    private static App sInstance;
    private Retrofit mRetrofit;

    @Override
    public void onCreate() {
        super.onCreate();

        sInstance = this;

        mRetrofit = new Retrofit.Builder()
                .baseUrl("http://7xk9dj.com1.z0.glb.clouddn.com/adapter/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static App getInstance() {
        return sInstance;
    }

    public Retrofit getRetrofit() {
        return mRetrofit;
    }

}