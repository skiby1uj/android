package com.example.budzetdomowy2_0;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class ZarzadcaBazyWydatkiPlanowane extends SQLiteOpenHelper {
public static int iloscEl = 0;
	public Context tmp = null;
	public ZarzadcaBazyWydatkiPlanowane(Context context) {
		super(context, "WydatkiPlanowane.db", null, 2);
		// TODO Auto-generated constructor stub
		tmp = context;
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(
				"create table WydatkiPlanowane(" + 
				"Opis varchar(50)," + 
				"Koszt int);"
				);
	}
	
	public void DodajWydatekPlanowany(String opis, int koszt){
		SQLiteDatabase db = getWritableDatabase();
		ContentValues wartosc = new ContentValues();
		wartosc.put("Opis", opis);
		wartosc.put("Koszt", koszt);
		db.insertOrThrow("WydatkiPlanowane", null, wartosc);
	}
	
	public Cursor DajWszystkie(){
		String kolumny[] = {"Opis", "Koszt"};
		SQLiteDatabase db = getReadableDatabase();
		Cursor kursor = db.query("WydatkiPlanowane",kolumny,null,null,null,null,null);
		iloscEl = kursor.getCount();
		return kursor;
	}
	
	public void UsunWydatek(int id){
		SQLiteDatabase db = getWritableDatabase();
		
		Cursor cursor = DajWszystkie();
		int i = 0;
		while(id >= i ){
			cursor.moveToNext();
			i++;
		}
		String where = "Opis = " + "'" +  cursor.getString(0)+ "'" + " and Koszt = " + "'" + cursor.getInt(1) + "'";
		//Toast.makeText(tmp, where , Toast.LENGTH_LONG).show();
		db.delete("WydatkiPlanowane", where, null);
	}
	
	public void DeleteAll(){
		SQLiteDatabase db = getWritableDatabase();
		db.delete("WydatkiPlanowane", "", null);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL("DROP TABLE WydatkiPlanowane;");
		onCreate(db);
	}

}
