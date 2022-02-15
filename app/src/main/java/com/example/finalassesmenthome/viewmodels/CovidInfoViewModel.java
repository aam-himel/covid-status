package com.example.finalassesmenthome.viewmodels;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.finalassesmenthome.models.CovidInfoModel;
import com.example.finalassesmenthome.repos.CovidInfoRepository;

public class CovidInfoViewModel extends ViewModel {
    private CovidInfoRepository repository;
    private MutableLiveData<CovidInfoModel> liveData = new MutableLiveData<>();
    private String city = "bangladesh";


    public void setLiveData(CovidInfoModel covidInfoModel) {
        liveData.postValue(covidInfoModel);
    }
    public void setCity(String city) {
        this.city = city;
    }


    public CovidInfoViewModel() {
        repository = new CovidInfoRepository();
        Log.d("test", "Viewmodel called");
    }

    public void loadData(){
        getCovidInfo();
    }

    public MutableLiveData<CovidInfoModel> getCovidInfo(){
        return repository.getCovidInfo(city);
    }


}
