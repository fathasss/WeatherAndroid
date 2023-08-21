package com.example.mobilapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.os.StrictMode;


import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView serviceResultCity;
    TextView serviceResultTemp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnGetWeather = (Button)findViewById(R.id.btnGetWeather);
        btnGetWeather.setOnClickListener(this);

        serviceResultCity = (TextView)findViewById(R.id.txtCityResult);
        serviceResultTemp = (TextView)findViewById(R.id.txtTempratureResult);
    }

    @Override
    public void onClick(View view) {
        WeatherMap weatherObj = new WeatherMap();
        WeatherMap weatherObjResult = new WeatherMap();
        weatherObjResult = weatherObj.WeatherAPI();
        serviceResultCity.setText(weatherObjResult.City);
        serviceResultTemp.setText(weatherObjResult.Temprature.toString());
    }
}