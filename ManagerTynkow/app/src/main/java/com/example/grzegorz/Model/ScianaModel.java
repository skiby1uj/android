package com.example.grzegorz.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by grzegorz on 27.02.17.
 */

public class ScianaModel extends SQLiteOpenHelper {
    private static final String sciana_table = "sciana";

    private static final String id_pomieszczenia_column = "id_pomieszczenia";
    private static final String id_rodzaj_pomieszczenia_column = "id_rodzaj_pomieszczenia";
    private static final String cena_column = "cena";

    public ScianaModel(Context context, int version) {
        super(context, sciana_table, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        Log.e("String", "inCreate Sciana");
        sqLiteDatabase.execSQL("CREATE TABLE " + sciana_table + "(" +
                id_pomieszczenia_column + " INTEGER NOT NULL," +
                id_rodzaj_pomieszczenia_column + " INTEGER NOT NULL," +
                cena_column + " INTEGER);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void add(int id_pomieszczenia, int id_rodzaj_pomieszczenia, int cena){
        Log.e("String", "add Sciana");
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(id_pomieszczenia_column, id_pomieszczenia);
        values.put(id_rodzaj_pomieszczenia_column, id_rodzaj_pomieszczenia);
        values.put(cena_column, cena);
        db.insertOrThrow(sciana_table, null, values);
    }
}
