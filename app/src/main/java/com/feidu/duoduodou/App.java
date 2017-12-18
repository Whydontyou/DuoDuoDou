package com.feidu.duoduodou;

import android.app.Application;

import com.feidu.duoduodou.http.net.RetrofitUtil;
import com.feidu.duoduodou.http.net.UrlPath;

/**
 * Created by wangjian on 2017/12/18.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
    }

    private static RetrofitUtil sRetrofitUtil;


    public static RetrofitUtil getRetrofitUtil() {
        if (sRetrofitUtil == null)
            sRetrofitUtil = new RetrofitUtil(UrlPath.URL_BOSS);
        http:
//www.13gjzpw.com/json/api/
        return sRetrofitUtil;
    }
}
