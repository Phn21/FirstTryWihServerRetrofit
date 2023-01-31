package com.example.firsttrywihserverretrofit.Pojo;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class CitiesList {
    @SerializedName("Info")
    public List<InfoList> info = new ArrayList();

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

        public Integer getRowCount() {
            return rowCount;
        }

        public void setRowCount(Integer rowCount) {
            this.rowCount = rowCount;
        }

        public Integer getPageCount() {
            return pageCount;
        }

        public void setPageCount(Integer pageCount) {
            this.pageCount = pageCount;
        }

        public Integer getPageRowCount() {
            return pageRowCount;
        }

        public void setPageRowCount(Integer pageRowCount) {
            this.pageRowCount = pageRowCount;
        }

        public Integer getPageNumber() {
            return pageNumber;
        }

        public void setPageNumber(Integer pageNumber) {
            this.pageNumber = pageNumber;
        }
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

        public Integer getCityId() {
            return cityId;
        }

        public void setCityId(Integer cityId) {
            this.cityId = cityId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getCountryId() {
            return countryId;
        }

        public void setCountryId(Integer countryId) {
            this.countryId = countryId;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }
    }
}
