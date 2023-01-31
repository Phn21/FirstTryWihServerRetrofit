package com.example.firsttrywihserverretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.firsttrywihserverretrofit.Pojo.CitiesList;
import com.example.firsttrywihserverretrofit.Pojo.RequestBody;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;


import kotlinx.coroutines.GlobalScope;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private String token = "dyQMHU2beL+SzJKntVQDjr22qib7hCZBkQ+YDmnyv6xNN+bdO4Hlbx/nx/guHwQydLlH/CJjNfX8pqnOocgKBHW/mKr+mE1GgD+lT9vwLIPFP1PJviNxm//+ze5faDFC3MZC6qIBLi7pWoTJEoQV7w13IX4GyLuh6bdzjzTM8SA9FPv4K9bI1oMDgOqd7WB2dc45iEz80USPeyoNeHvJ547f2+ZmI5X4DwQ99WwhawpRzoPOv1NQNJmWiu1gJK66lIiCRwhPirKlIYn16cp8sv8qAbZbaovnHIDa9FNtuFzQbGAv7/Vgl8CMbdqXi2kc+byJsqy7B14cJvB0MNdjleP5GKjXyfRCyEBkzj7O77cUZpErdoHZnjEHvEX1GUnSkioD0lGgMezAKpd1ZquN4A==";
    TextView infoTV, resultTV;
    APIInterface apiInterface;
    RequestBody requestBody;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        infoTV = findViewById(R.id.infoTV);
        resultTV = findViewById(R.id.resultTV);

//        HashMap<String, String> hashmap = new HashMap<String, String>();
//
//        hashmap.put("token", token);
//        hashmap.put("topRecordsCount", String.valueOf(1));


        apiInterface = APIClient.getClient().create(APIInterface.class);

        requestBody = new RequestBody(token,1,"","",0);


        Call<CitiesList> call = apiInterface.getCityLists(requestBody);
        call.enqueue(new Callback<CitiesList>() {
            @Override
            public void onResponse(Call<CitiesList> call, Response<CitiesList> response) {
                Log.d("AkoCode", String.valueOf(response.code()) + "\n\n" + response.headers() + "\n" + response.errorBody());

                if(response.isSuccessful())
                    Toast.makeText(MainActivity.this, response.code() + "\nAko", Toast.LENGTH_SHORT).show();
                else Toast.makeText(MainActivity.this, response.code() + "\nError", Toast.LENGTH_SHORT).show();


                List<CitiesList.ResultList> infoListCall = response.body().result;

//                for (int i=0; i> infoListCall.size(); i++){
//                    infoTV.append( infoListCall.get(i).getName() + "\n");
//                }

                infoTV.setText( "City Name: " + infoListCall.get(0).name + "\nCountry: " +
                        infoListCall.get(0).country);
            }

            @Override
            public void onFailure(Call<CitiesList> call, Throwable t) {
                Log.d("Ako", t.getMessage());
                call.cancel();
            }
        });

//        call.enqueue(new Callback<CitiesList>() {
//            @SuppressLint("SetTextI18n")
//            @Override
//            public void onResponse(Call<CitiesList> call, Response<CitiesList> response) {
//                Log.d("AkoCode", String.valueOf(response.code()) + "\n" + response.message() + "\n" + response.errorBody());
////
////                if (response.code() == 400) {
////                    Log.v("Ako code 400", String.valueOf(response.errorBody()));
////                }
////                CitiesList citiesList = response.body();
////
//////                List<CitiesList.ResultList> resultListList = citiesList.result;
////                CitiesList.InfoList infoListList = citiesList.info;
//                if(response.isSuccessful()){
//                    Toast.makeText(getBaseContext(),"" + response.code(),Toast.LENGTH_SHORT).show();
//                }else {
//                    //response.body() have your LoginResult fields and methods  (example you have to access error then try like this response.body().getError() )
//                    Toast.makeText(MainActivity.this, "" + response.code(), Toast.LENGTH_SHORT).show();
//                }
//
////                infoTV.setText("pageCount: " + infoListList.pageCount
////                        + "\nPageNumber: " + infoListList.pageNumber
////                        + "\npageRowCount" + infoListList.pageRowCount
////                        + "\nrowCount" + infoListList.rowCount);
////                for (CitiesList.InfoList infoList : infoListList){
////                    infoTV.setText("pageCount: " + infoList.pageCount
////                            + "\nPageNumber: " + infoList.pageNumber
////                            + "\npageRowCount" + infoList.pageRowCount
////                            + "\nrowCount" + infoList.rowCount);
////                }
////                for (CitiesList.ResultList resultList : resultListList){
////                    resultTV.setText("Country: " + resultList.country
////                                    + "\nName: " + resultList.name
////                                    + "\nCityID: " + resultList.cityId
////                                    + "\nCountryID: " + resultList.countryId);
////                }
//            }
//
//            @Override
//            public void onFailure(Call<CitiesList> call, Throwable t) {
//                Log.d("Ako", t.getMessage());
//                call.cancel();
//            }
//        });

    }
}