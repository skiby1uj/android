package com.example.grzegorz.ready4s2;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by grzegorz on 03.03.17.
 */

public class point {
    public int id;
    public String name;
    public String avatar;
    public double longitude;
    public double latitude;

    public point() {}

    public point(JSONObject json) throws JSONException {
        this.id = json.getInt("id");
        this.name = json.getString("name");
        this.avatar = json.getString("avatar");
        this.longitude = json.getDouble("lng");
        this.latitude = json.getDouble("lat");
    }

    public point(int id, String name, String avatar, double longitude, double latitude){
        this.id = id;
        this.name = name;
        this.avatar = avatar;
        this.longitude = longitude;
        this.latitude = latitude;
    }







}
