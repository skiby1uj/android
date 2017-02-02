package com.example.budzetdomowy;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class ZarzadcaBazyDomoweWydatki extends SQLiteOpenHelper {
	//private String 
	public static int iloscEl = 0;
	public ZarzadcaBazyDomoweWydatki(Context context) {
		super(context, "DomoweWydatki.db", null, 1);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(
				"create table DomoweWydatki(" + 
				"OpisWydatku varchar(100)," + 
				"Cena int);"
				);
	}
	
	public void DodajDomowyWydatek(String opis, int cena){
		SQLiteDatabase db = getWritableDatabase();
		ContentValues wartosc = new ContentValues();
		wartosc.put("OpisWydatku", opis);
		wartosc.put("Cena", cena);
		db.insertOrThrow("DomoweWydatki", null, wartosc);
	}
	
	public Cursor DajWszystkie(){
		String[] kolumny={"OpisWydatku", "Cena"};
		SQLiteDatabase db = getReadableDatabase();
		Cursor kursor =db.query("DomoweWydatki",kolumny,null,null,null,null,null);
		iloscEl = kursor.getCount();
		return kursor;
	}
	
	
	


	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}

}
