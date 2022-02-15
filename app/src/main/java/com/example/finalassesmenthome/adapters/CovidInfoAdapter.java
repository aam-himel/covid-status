package com.example.finalassesmenthome.adapters;

import android.widget.TextView;

import androidx.databinding.BindingAdapter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CovidInfoAdapter {
    @BindingAdapter("setDate")
    public static void setFormattedDate(TextView view, long date){
        final String dateString = new SimpleDateFormat("dd, yyyy").format(new Date(date));
        view.setText("Last Updated: "+ dateString);
    }
}
