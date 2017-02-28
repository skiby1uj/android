package com.example.grzegorz.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by grzegorz on 27.02.17.
 */

public class DaneZleceniaModel extends SQLiteOpenHelper {
    public static final String dane_zlenienia_table = "dane_zlecenia";

    public static final String id_column = "id";
    public static final String id_klienta_column = "id_klienta";
    public static final String nazwa_column = "nazwa";
    public static final String data_rozpoczecia_column = "data_rozpoczecia";
    public static final String data_zakonczenia_column = "data_zakonczenia";
    public static final String cena_m2_column = "cena_m2";

    public DaneZleceniaModel(Context context, int version) {
        super(context, dane_zlenienia_table, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        Log.e("String", "inCreate Zlecenia");
        sqLiteDatabase.execSQL("CREATE TABLE " + dane_zlenienia_table + "(" +
                id_column + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                id_klienta_column + " INTEGER NOT NULL," +
                nazwa_column + " TEXT NOT NULL," +
                data_rozpoczecia_column + " DATETIME NOT NULL," +
                data_zakonczenia_column + " DATETIME DEFAULT NULL," +
                cena_m2_column + " INTEGER NOT NULL);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        onCreate(sqLiteDatabase);
    }

    public void add(int id_klienta, String nazwa, String data_rozpoczecia, int cena){
        Log.e("String", "add Zlecenia");
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(id_klienta_column, id_klienta);
        values.put(nazwa_column, nazwa);
        values.put(data_rozpoczecia_column, data_rozpoczecia);
        values.put(cena_m2_column, cena);
        db.insertOrThrow(dane_zlenienia_table, null, values);
    }

    public void add(int id_klienta, String nazwa, String data_rozpoczecia, String data_zakonczenia, int cena){
        Log.e("String", "add Zlecenia");
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(id_klienta_column, id_klienta);
        values.put(nazwa_column, nazwa);
        values.put(data_rozpoczecia_column, data_rozpoczecia);
        values.put(data_zakonczenia_column, data_zakonczenia);
        values.put(cena_m2_column, cena);
        db.insertOrThrow(dane_zlenienia_table, null, values);
    }
}
