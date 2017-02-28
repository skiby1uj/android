package com.example.grzegorz.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by grzegorz on 27.02.17.
 */

public class PomieszczenieModel extends SQLiteOpenHelper {
    private static final String pomieszczenie_table = "pomieszczenie";

    private static final String id_column = "id";
    private static final String id_dane_podstawowe_column = "id_dane_podstawowe";
    private static final String nazwa_pomieszczenia_column = "nazwa_pomieszczenia";

    public PomieszczenieModel(Context context, int version) {
        super(context, pomieszczenie_table, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        Log.e("String", "inCreatePomieszczenie");
        sqLiteDatabase.execSQL("CREATE TABLE " + pomieszczenie_table + "(" +
                id_column + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                id_dane_podstawowe_column + " INTEGER NOT NULL," +
                nazwa_pomieszczenia_column + " TEXT NOT NULL);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void add(int id_dane_podstawowe, String nazwa){
        Log.e("String", "add Pomieszczenie");
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(id_dane_podstawowe_column, id_dane_podstawowe);
        values.put(nazwa_pomieszczenia_column, nazwa);
        db.insertOrThrow(pomieszczenie_table, null, values);
    }
}
