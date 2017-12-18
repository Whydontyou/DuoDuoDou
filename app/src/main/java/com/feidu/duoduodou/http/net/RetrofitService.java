package com.feidu.duoduodou.http.net;

/**
 * Created by wangjian on 2017/12/8.
 */

import com.google.gson.JsonObject;

import okhttp3.ResponseBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Created by  on 2016/12/1.
 */
public interface RetrofitService {
    //下载文件
    @GET
    Observable<ResponseBody> downloadPicFromNet(@Url String fileUrl);


    @GET
    Observable<JsonObject> getStringScan(@Url String url);

    /**
     * 版本更新
     *
     * @param version 版本号
     * @param os      系统
     */
    @GET("check_version.php")
    Observable<JsonObject> getJsonVersion(@Query("version") String version, @Query("os") String os);


    /**
     * 注册
     *
     * @param user_name 手机号
     * @param password  密码
     * @param email     验证码
     * @param real_name 企业/个人
     * @param phone_mob 电话
     * @param phone_mob 验证码
     * @return
     */
    @FormUrlEncoded
    @POST("index.php?app=phone&act=app_register")
    Observable<JsonObject> getJsonRegister(@Field("user_name") String user_name,
                                           @Field("password") String password,
                                           @Field("email") String email,
                                           @Field("real_name") String real_name,
                                           @Field("phone_mob") String phone_mob,
                                           @Field("verify_code") String verify_code

    );

    /**
     * 验证码
     *
     * @param mobile
     * @return
     */
    @FormUrlEncoded
    @POST("index.php?app=sms&act=app_sms&mobile=")
    Observable<JsonObject> getJsonCode(
            @Field("mobile") String mobile

    );

    /**
     * 登录
     * http://192.168.1.182:8080/efithealth/mlogin.do?mobphone=18624616670&mempass=123456&phonedeviceno=
     * mobphone  用户名
     * mempass      密码
     * phonedeviceno   设备id
     */

    @GET("index.php?app=phone&act=app_login")
    Observable<JsonObject> getJsonLogin(@Query("user_name") String mobphone,
                                        @Query("password") String mempass
    );

    /**
     * 搜索
     *
     * @param position
     * @return
     */
    @GET("GetCarousel?")
    Observable<JsonObject> getLunBo(@Query("position") String position);

    @GET("search.php")
    Observable<JsonObject> getDingdan(@Query("key") String key, @Query("page") int page);


}
