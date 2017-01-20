package com.example.coolweather.db;

import org.litepal.crud.DataSupport;

/**
 * Created by Lancer on 2017/1/19.
 */

public class City extends DataSupport {

    private int id;
    //城市名
    private String cityName;
    //市代号
    private int cityCode;
    //市所属省id
    private int provinceId;

    public int getCityCode() {
        return cityCode;
    }

    public void setCityCode(int cityCode) {
        this.cityCode = cityCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }
}
