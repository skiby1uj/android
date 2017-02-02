package com.example.budzetdomowy2_0;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class ZarzadcaBazyWydatkiNiePlanowane extends SQLiteOpenHelper {

	public static int iloscEl = 0;
	public Context tmp = null;
	//private SQLiteDatabase db = null;
	public ZarzadcaBazyWydatkiNiePlanowane(Context context) {
		super(context, "WydatkiNiePlanowane.db", null, 2);
		// TODO Auto-generated constructor stub
		tmp = context;
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		//this.db = db;
		// TODO Auto-generated method stub
		db.execSQL(
				"create table WydatkiNiePlanowane(" + 
		
				"Opis varchar(50)," + 
				"Koszt int);"
				);
	}
	
	public void DodajWydatek(String opis, int koszt){
		SQLiteDatabase db = getWritableDatabase();
		ContentValues wartosc = new ContentValues();

		wartosc.put("Opis", opis);
		wartosc.put("Koszt", koszt);
		db.insertOrThrow("WydatkiNiePlanowane", null, wartosc);
	}
	
	public Cursor DajWszystkich(){
		String []kolumny = {"Opis", "Koszt"};
		SQLiteDatabase db = getReadableDatabase();
		Cursor kursor = db.query("WydatkiNiePlanowane",kolumny,null,null,null,null,null);
		iloscEl = kursor.getCount();
		return kursor;
	}
	
	public void UsunWydatek(int id){
		SQLiteDatabase db = getWritableDatabase();
		
		Cursor cursor = DajWszystkich();
		int i = 0;
		while(id >= i ){
			cursor.moveToNext();
			i++;
		}
		String where = "Opis = " + "'" +  cursor.getString(0)+ "'" + " and Koszt = " + "'" + cursor.getInt(1) + "'";
		//Toast.makeText(tmp, where , Toast.LENGTH_LONG).show();
		db.delete("WydatkiNiePlanowane", where, null);
	}
	
	public void deleteAll(){
		SQLiteDatabase db = getWritableDatabase();
		db.delete("WydatkiNiePlanowane", "", null);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL("DROP TABLE WydatkiNiePlanowane;");
		//Toast.makeText(tmp, "USUNIETO", Toast.LENGTH_LONG).show();
		onCreate(db);
	}

}

