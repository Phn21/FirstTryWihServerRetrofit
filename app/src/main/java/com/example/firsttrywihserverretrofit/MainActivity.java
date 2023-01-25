package com.example.firsttrywihserverretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.firsttrywihserverretrofit.Pojo.CitiesList;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private String token = "dyQMHU2beL+SzJKntVQDjr22qib7hCZBkQ+YDmnyv6xNN+bdO4Hlbx/nx/guHwQydLlH/CJjNfX8pqnOocgKBHW/mKr+mE1GgD+lT9vwLIPFP1PJviNxm//+ze5faDFC3MZC6qIBLi7pWoTJEoQV7w13IX4GyLuh6bdzjzTM8SA9FPv4K9bI1oMDgOqd7WB2dc45iEz80USPeyoNeHvJ547f2+ZmI5X4DwQ99WwhawpRzoPOv1NQNJmWiu1gJK66lIiCRwhPirKlIYn16cp8sv8qAbZbaovnHIDa9FNtuFzQbGAv7/Vgl8CMbdqXi2kc+byJsqy7B14cJvB0MNdjleVuefz57JF75xtMwVk8SLJYTZVhrtp+/iBtHetmdKbbk4eRekUElg24RhNi3EkOCw==";
    TextView infoTV, resultTV;
    APIInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        infoTV = findViewById(R.id.infoTV);
        resultTV = findViewById(R.id.resultTV);

        apiInterface = APIClient.getClient().create(APIInterface.class);
        Call<CitiesList> call = apiInterface.getCityListByTopCount(token,1);
        call.enqueue(new Callback<CitiesList>() {
            @Override
            public void onResponse(Call<CitiesList> call, Response<CitiesList> response) {
                CitiesList citiesList = response.body();

//                List<CitiesList.ResultList> resultListList = citiesList.result;
                CitiesList.InfoList infoListList = citiesList.info;


                infoTV.setText("pageCount: " + infoListList.pageCount
                        + "\nPageNumber: " + infoListList.pageNumber
                        + "\npageRowCount" + infoListList.pageRowCount
                        + "\nrowCount" + infoListList.rowCount);
//                for (CitiesList.InfoList infoList : infoListList){
//                    infoTV.setText("pageCount: " + infoList.pageCount
//                            + "\nPageNumber: " + infoList.pageNumber
//                            + "\npageRowCount" + infoList.pageRowCount
//                            + "\nrowCount" + infoList.rowCount);
//                }
//                for (CitiesList.ResultList resultList : resultListList){
//                    resultTV.setText("Country: " + resultList.country
//                                    + "\nName: " + resultList.name
//                                    + "\nCityID: " + resultList.cityId
//                                    + "\nCountryID: " + resultList.countryId);
//                }
            }

            @Override
            public void onFailure(Call<CitiesList> call, Throwable t) {
                Log.d("Ako", t.getMessage());
                call.cancel();
            }
        });

    }
}