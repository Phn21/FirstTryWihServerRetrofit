package com.example.firsttrywihserverretrofit;

import com.example.firsttrywihserverretrofit.Pojo.CitiesList;
import com.example.firsttrywihserverretrofit.Pojo.RequestBody;

import java.util.HashMap;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface APIInterface {

//    @Headers({"Accept: text/plain",
//            "Content-Type: application/problem+json"})
//    @FormUrlEncoded
//    @POST("/api/CitiesList")
//    Call<CitiesList> getCityListByTopCount(@Field("token") String token, @Field("topRecordsCount") Integer top , @Field("filter") String filter, @Field("sort") String sort, @Field("pageNumber") Integer pageNumber);

    @POST("CitiesList")
    Call<CitiesList> getCityLists(@Body RequestBody requestBody);
}
//{
//        "token": "string",
//        "topRecordsCount": 0,
//        "filter": "",
//        "sort": "",
//        "pageNumber": 0
//        }