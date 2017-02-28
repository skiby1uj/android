package com.example.grzegorz.managertynkow;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import com.example.grzegorz.Model.DaneZleceniaModel;
import com.example.grzegorz.Model.KlientModel;
import com.example.grzegorz.Model.PomieszczenieModel;
import com.example.grzegorz.Model.RodzajScianyModel;
import com.example.grzegorz.Model.ScianaModel;

/**
 * Created by grzegorz on 27.02.17.
 */

public class DbTools{
    private final int version = 3;

    public KlientModel klientModel;
    public DaneZleceniaModel daneZleceniaModel;
    public PomieszczenieModel pomieszczenieModel;
    public RodzajScianyModel rodzajScianyModel;
    public ScianaModel scianaModel;

    public DbTools(Context context) {
        Log.e("String", "in konstruktor");
        klientModel = new KlientModel(context, version);
        daneZleceniaModel = new DaneZleceniaModel(context,version);
        pomieszczenieModel = new PomieszczenieModel(context, version);
        rodzajScianyModel = new RodzajScianyModel(context, version);
        scianaModel = new ScianaModel(context, version);
    }

    public void addDaneZlecenie(int id_klienta, String nazwa, String data_rozpoczecia, int cena){
        daneZleceniaModel.add(id_klienta, nazwa, data_rozpoczecia, cena);
    }

    public void addKlient(String imie, String nazwisko, String tel, String miejscowosc){
        klientModel.add(imie, nazwisko, tel, miejscowosc);
    }

    public void addPomieszczenie(int id_dane_podstawowe, String nazwa){
        pomieszczenieModel.add(id_dane_podstawowe, nazwa);
    }

    public void addRodzajSciany(String nazwa){
        rodzajScianyModel.add(nazwa);
    }

    public void addSciana(int id_pomieszczenia, int id_rodzaj_pomieszczenia, int cena){
        scianaModel.add(id_pomieszczenia, id_rodzaj_pomieszczenia, cena);
    }
}
