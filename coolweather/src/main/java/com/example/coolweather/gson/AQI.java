package com.example.coolweather.gson;

/**
 * Created by Lancer on 2017/1/19.
 */
public class AQI {
    public AQICity city;

    public class AQICity {
        public String aqi;
        public String pm25;
    }
}