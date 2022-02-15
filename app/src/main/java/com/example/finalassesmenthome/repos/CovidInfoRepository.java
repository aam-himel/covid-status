package com.example.finalassesmenthome.repos;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.finalassesmenthome.models.CovidInfoModel;
import com.example.finalassesmenthome.services.CovidInfoService;
import com.example.finalassesmenthome.viewmodels.CovidInfoViewModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CovidInfoRepository {

    public CovidInfoRepository(){
    }

    public MutableLiveData<CovidInfoModel> getCovidInfo(String endUrl){

        String finalEndUrl = String.format("%s?yesterday=true", endUrl);

        MutableLiveData<CovidInfoModel> liveData = new MutableLiveData<>();
        CovidInfoService.getCovidInfoService().getCovidInfo(finalEndUrl).enqueue(new Callback<CovidInfoModel>() {
            @Override
            public void onResponse(Call<CovidInfoModel> call, Response<CovidInfoModel> response) {
                if(response.code() == 200){
                    Log.d("covid", response.body().getCountry());
                    liveData.postValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<CovidInfoModel> call, Throwable t) {
                Log.d("covid", "Error = ======================================" +t.fillInStackTrace());
            }
        });
        return liveData;
    }
}
