package com.example.grzegorz.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by grzegorz on 27.02.17.
 */

public class RodzajScianyModel extends SQLiteOpenHelper {
    public static final String rodzaj_sciany_table = "rodzaj_sciany";

    public static final String id_column = "id";
    public static final String nazwa_column = "nazwa";

    public RodzajScianyModel(Context context, int version) {
        super(context, rodzaj_sciany_table, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        Log.e("String", "inCreate Rodzaj Sciany");
        sqLiteDatabase.execSQL("CREATE TABLE " + rodzaj_sciany_table + "(" +
                id_column + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                nazwa_column + " TEXT NOT NULL);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void add(String nazwa){
        Log.e("String", "add Rodzaj Sciany");
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(nazwa_column, nazwa);
        db.insertOrThrow(rodzaj_sciany_table, null, values);
    }
}
