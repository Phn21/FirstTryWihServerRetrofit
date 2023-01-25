package com.example.firsttrywihserverretrofit.Pojo;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class CitiesList {
    @SerializedName("Info")
    public InfoList info = new InfoList();
    @SerializedName("Result")
    public List<ResultList> result = new ArrayList();


    public class InfoList {
        @SerializedName("RowCount")
        public Integer rowCount;
        @SerializedName("PageCount")
        public Integer pageCount;
        @SerializedName("PageRowCount")
        public Integer pageRowCount;
        @SerializedName("PageNumber")
        public Integer pageNumber;
    }

    public class ResultList {
        @SerializedName("OA_CityID")
        public Integer cityId;
        @SerializedName("Name")
        public String name;
        @SerializedName("OA_CountryID")
        public Integer countryId;
        @SerializedName("Country")
        public String country;
    }
}
