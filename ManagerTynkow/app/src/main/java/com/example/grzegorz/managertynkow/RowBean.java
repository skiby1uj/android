package com.example.grzegorz.managertynkow;

/**
 * Created by grzegorz on 24.02.17.
 */

public class RowBean {

    public String data_rozpoczecia;
    public String name;
    public boolean checked;

    public RowBean(){}

    public RowBean(String name, String data_rozpoczecia){
        this.data_rozpoczecia = data_rozpoczecia;
        this.name = name;
        this.checked = false;
    }
}
