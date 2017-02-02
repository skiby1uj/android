package com.example.budzetdomowy2_0;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class ZarzadcaBazyWydatkiCykliczne extends SQLiteOpenHelper {
	public Context tmp = null;
	public static int iloscEl = 0;
	
	public ZarzadcaBazyWydatkiCykliczne(Context context) {
		super(context, "WydatkiCykliczne.db", null, 3);
		// TODO Auto-generated constructor stub
		tmp = context;
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		
		
		
		db.execSQL(
				"create table WydatkiCykliczne(" + 
				/*"ID int,"  +*/
				"Opis varchar(50)," + 
				"Koszt int);"
				);
	}
	
	public void DodajWydatek(String opis, int koszt){
		SQLiteDatabase db = getWritableDatabase();
		ContentValues wartosc = new ContentValues();
		/*wartosc.put("ID", iloscEl);*/
		wartosc.put("Opis", opis);
		wartosc.put("Koszt", koszt);
		db.insertOrThrow("WydatkiCykliczne", null, wartosc);
	}
	
	public Cursor DajWszystkieWydatkiCykliczne(){
		String []kolumny = {/*"ID", */"Opis", "Koszt"};
		SQLiteDatabase db = getReadableDatabase();
		Cursor kursor = db.query("WydatkiCykliczne", kolumny, null, null, null, null, null);
		iloscEl = kursor.getCount();
		
		return kursor;
	}
	
	public void UsunWydatek(int id){
		SQLiteDatabase db = getWritableDatabase();
		
		Cursor cursor = DajWszystkieWydatkiCykliczne();
		int i = 0;
		while(id >= i ){
			cursor.moveToNext();
			i++;
		}
		String where = "Opis = " + "'" +  cursor.getString(0)+ "'" + " and Koszt = " + "'" + cursor.getInt(1) + "'";
		//Toast.makeText(tmp, where , Toast.LENGTH_LONG).show();
		db.delete("WydatkiCykliczne", where, null);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		//Toast.makeText(tmp, "Usunieta", Toast.LENGTH_LONG).show();
		db.execSQL("DROP TABLE WydatkiCykliczne;");
		onCreate(db);
	}

	
	
}
