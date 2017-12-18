package com.feidu.duoduodou.http.net;

/**
 * Created by wangjian on 2017/12/8.
 */

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 *
 * retrofit请求封装
 */
public class RetrofitUtil {
    String baseUrl ;
    private static final int DEFAULT_TIMEOUT = 5;
    public RetrofitUtil(String baseUrl){
        this.baseUrl=baseUrl;
    }

    public RetrofitService getRetrofit(){
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        Retrofit retrofit = new Retrofit.Builder()
                .client(builder.build())
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        RetrofitService retrofitService = retrofit.create(RetrofitService.class);

        return retrofitService;
    }
}
