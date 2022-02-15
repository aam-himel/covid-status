package com.example.finalassesmenthome;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.finalassesmenthome.databinding.FragmentHomeBinding;
import com.example.finalassesmenthome.models.CovidInfoModel;
import com.example.finalassesmenthome.viewmodels.CovidInfoViewModel;
import com.squareup.picasso.Picasso;

public class HomeFragment extends Fragment {
    private FragmentHomeBinding binding;
    private CovidInfoViewModel viewModel;

    public HomeFragment() { }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater);
        viewModel = new ViewModelProvider(requireActivity()).get(CovidInfoViewModel.class);


        binding.search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {

                viewModel.setCity(s);
                viewModel.getCovidInfo().observe(getViewLifecycleOwner(), new Observer<CovidInfoModel>() {
                    @Override
                    public void onChanged(CovidInfoModel covidInfoModel) {
                        binding.setCovidInfo(covidInfoModel);
                        setImgPicasso(covidInfoModel.getCountryInfo().getFlag(), binding.countryImg);
                    }
                });
                binding.search.setQuery("", false);
                binding.search.clearFocus();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                Log.d("search", s);
                return false;
            }
        });


        viewModel.getCovidInfo().observe(getViewLifecycleOwner(), new Observer<CovidInfoModel>() {
            @Override
            public void onChanged(CovidInfoModel covidInfoModel) {
                binding.setCovidInfo(covidInfoModel);
                setImgPicasso(covidInfoModel.getCountryInfo().getFlag(), binding.countryImg);
            }
        });

        return binding.getRoot();
    }
    public void setImgPicasso(String imgUrl, ImageView imgView){
        Picasso.get().load(imgUrl).into(imgView);
    }

}