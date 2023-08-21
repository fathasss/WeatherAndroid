package com.example.mobilapp;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import android.os.StrictMode;


public class WeatherMap {
    String API_KEY = "76a11158d658446886c124740232108";
    String City = "Istanbul";
    String API_ENDPOINT = "https://api.weatherapi.com/v1/current.json?key=" + API_KEY + "&q=" + City;
    String  Status;
    Double Temprature;

    public WeatherMap WeatherAPI(){
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        String result = null;
        WeatherMap weatherObject = new WeatherMap();
        try{
            URL url =  new URL(weatherObject.API_ENDPOINT);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();
            JSONObject jsonResponse = new JSONObject(response.toString());
            JSONObject main = jsonResponse.getJSONObject("current");
            //JSONObject weather = weatherArray.getJSONObject(0);
            weatherObject.Temprature = main.getDouble("temp_c");;
            return weatherObject;
        }
        catch(Exception exp){
            Log.d("message","Connection Error");
            return new WeatherMap();
        }
    }
}
