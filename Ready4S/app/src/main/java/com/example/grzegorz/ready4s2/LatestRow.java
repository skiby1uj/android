package com.example.grzegorz.ready4s2;

/**
 * Created by grzegorz on 04.03.17.
 */

public class LatestRow {
    private String name;
    private String localization;
    private int id;

    public LatestRow(int id, String name, double latitude, double longitude){
        this.id = id;
        this.name = name;
        if (longitude > 0){
            this.localization = longitude+" E, ";
        }
        else {
            this.localization = Math.abs(longitude)+" W, ";
        }
        if (latitude > 0){
            this.localization += latitude + " N";
        }
        else {
            this.localization += Math.abs(latitude) + " S";
        }
    }

    public String getName(){
        return this.name;
    }

    public String getLocalization(){
        return this.localization;
    }

    public int getId(){
        return this.id;
    }
}
