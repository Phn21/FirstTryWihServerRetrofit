package com.example.firsttrywihserverretrofit;

import com.example.firsttrywihserverretrofit.Pojo.CitiesList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIInterface {

    @GET("/api/CitiesList")
    Call<CitiesList> getCityListByTopCount(@Query("token") String token, @Query("topRecordsCount") Integer topRecordsCount);

}
