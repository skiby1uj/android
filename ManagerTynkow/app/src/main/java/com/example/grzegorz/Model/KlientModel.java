package com.example.grzegorz.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by grzegorz on 27.02.17.
 */

public class KlientModel extends SQLiteOpenHelper {
    private static final String klient_table = "klient";

    private static final String id_column = "id";
    private static final String imie_column = "imie";
    private static final String nazwisko_column = "nazwisko";
    private static final String telefon_column = "telefon";
    private static final String miejscowosc_column = "miejscowosc";
    private static final String ulica_column = "ulica";
    private static final String numer_budynku_column = "numer_budynku";
    private static final String numer_lokalu_column = "numer_lokalu";

    public KlientModel(Context context, int version) {
        super(context, klient_table, null, version);
        Log.e("String", "konstruktor klient");
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        Log.e("String", "inCreateKlient");
        sqLiteDatabase.execSQL("CREATE TABLE " + klient_table + "(" +
                id_column + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                imie_column + " TEXT NOT NULL," +
                nazwisko_column + " TEXT NOT NULL," +
                telefon_column + " TEXT NOT NULL," +
                miejscowosc_column + " TEXT NOT NULL," +
                ulica_column + " TEXT,"+
                numer_budynku_column + " INTEGER," +
                numer_lokalu_column + " INTEGER);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void add(String imie, String nazwisko, String tel, String miejscowosc){
        Log.e("String", "add Klient");
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(imie_column, imie);
        values.put(nazwisko_column, nazwisko);
        values.put(telefon_column, tel);
        values.put(miejscowosc_column, miejscowosc);
        db.insertOrThrow(klient_table, null, values);
    }
}
