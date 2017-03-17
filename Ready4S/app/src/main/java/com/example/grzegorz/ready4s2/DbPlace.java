package com.example.grzegorz.ready4s2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by grzegorz on 03.03.17.
 */

public class DbPlace extends SQLiteOpenHelper{

    private static final String place_table = "place";

    private static final String id_column = "id";
    private static final String name_column = "name";
    private static final String image_url_column = "image_url";
    private static final String longitude_column = "longitude";
    private static final String latitude_column = "latitude";

    private static final int version = 1;

    public DbPlace(Context context) {
        super(context, place_table, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + place_table + "(" +
                id_column + " INTEGER PRIMARY KEY," +
                name_column + " TEXT NOT NULL," +
                image_url_column + " TEXT NOT NULL," +
                longitude_column + " DOUBLE NOT NULL," +
                latitude_column + " DOUBLE NOT NULL);"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    private boolean isInTable(int id){
        SQLiteDatabase db = getReadableDatabase();

        Cursor cr = db.rawQuery("SELECT count("+id_column+") FROM "+ this.place_table+ " WHERE "+id_column +" = " + id, null);
        cr.moveToFirst();
        int countID = cr.getInt(0);

        if(countID == 0){
            return false;
        }

        else{
            return true;
        }
    }

    public point selectAllwithId(int id){
        SQLiteDatabase db = getReadableDatabase();

        Cursor cr = db.rawQuery("SELECT * FROM place WHERE id = " + id, null);
        if(cr.moveToNext()){
            return new point(cr.getInt(0), cr.getString(1), cr.getString(2), cr.getDouble(3), cr.getDouble(4));

        }
        return null;
    }

    public ArrayList selectAllRowTOLatestList(){
        SQLiteDatabase db = getReadableDatabase();
        String[] columns = {id_column.toString(), name_column, latitude_column, longitude_column};
        Cursor cr = db.query(place_table, columns, null,null,null,null,null,null);
        ArrayList<LatestRow> listView = new ArrayList<>();

        while (cr.moveToNext()){
            listView.add(new LatestRow(cr.getInt(0), cr.getString(1), cr.getDouble(2), cr.getDouble(3)));
        }
        return listView;
    }

    public void insert(point point){
        if (this.isInTable(point.id) == false) {
            SQLiteDatabase db = getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(id_column, point.id);
            values.put(name_column, point.name);
            values.put(image_url_column, point.avatar);
            values.put(longitude_column, point.longitude);
            values.put(latitude_column, point.latitude);
            db.insertOrThrow(place_table, null, values);
            Latest.addToLatestList(point.id, point.name, point.latitude, point.longitude);
        }
    }
}
