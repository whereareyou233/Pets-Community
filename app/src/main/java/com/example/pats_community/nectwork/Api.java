package com.example.pats_community.nectwork;

import com.example.pats_community.model.GetDiscernResultResponse;
import com.example.pats_community.model.GetTokenResponse;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;


public interface Api {

    /**
     * Retrofit将okhttp请求抽象成java接口，采用注解描述和配置网络请求参数，用动态代理将该接口的注解“翻译”成一个Http请求，最后执行Http请求。
     * 获取鉴权认证Token
     * @param grant_type 类型
     * @param client_id API Key
     * @param client_secret Secret Key
     * @return GetTokenResponse
     */

    @FormUrlEncoded
    @POST("/oauth/2.0/token")
    Call<GetTokenResponse> getToken(@Field("grant_type") String grant_type,
                                    @Field("client_id") String client_id,
                                    @Field("client_secret") String client_secret);
    /**
     * 获取图像识别结果
     * @param accessToken 获取鉴权认证Token
     * @param image 图片base64
     * @param url 网络图片Url
     * @param  baike_num 网络图片Url
     * @return JsonObject
     * @POST   请求方法注解，post请求，表示采用post方法访问网络请求，括号内的是请求地址，Url的一部分，
     * Call<*>返回类型，*表示接收数据的类，一般自定义
     * 接口每个方法的参数都需要注解，否则会报错
     * getData() 接口方法名称，括号内可以写入参数
     * @Field 多用于Post方式传递参数，需要结合@FromUrlEncoded使用，即以表单的形式传递参数
     * @FromUrlCoded	表示请求发送编码表单数据，每个键值对需要使用@Filed注解
     */
    @FormUrlEncoded
    @POST("/rest/2.0/image-classify/v2/advanced_general")
    @Headers("Content-Type:application/x-www-form-urlencoded; charset=utf-8")
    Call<GetDiscernResultResponse> getDiscernResult(@Field("access_token") String accessToken,
                                                    @Field("image") String image,
                                                    @Field("url") String url,
                                                    @Field("baike_num")  int baike_num);
}

