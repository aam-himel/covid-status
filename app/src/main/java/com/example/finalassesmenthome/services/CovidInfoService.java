package com.example.finalassesmenthome.services;

import com.example.finalassesmenthome.utils.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public interface CovidInfoService {
    public static CovidInfoServiceAPI getCovidInfoService(){
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://disease.sh/v3/covid-19/countries/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(CovidInfoServiceAPI.class);
    }
}
