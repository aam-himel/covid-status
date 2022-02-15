package com.example.finalassesmenthome.services;

import com.example.finalassesmenthome.models.CovidInfoModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface CovidInfoServiceAPI {
    @GET
    Call<CovidInfoModel> getCovidInfo(@Url String endUrl);
}
