package com.example.budzetdomowy2_0;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class ZarzadcaBazyPrzychodyRodziny extends SQLiteOpenHelper {
	public static int iloscEl = 0;
	public static int suma = 0;
	private Context tmp = null;
	public ZarzadcaBazyPrzychodyRodziny(Context context) {
		super(context, "PrzychodyRodziny.db", null, 2);
		// TODO Auto-generated constructor stub
		tmp = context;
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(
				"create table PrzychodyRodziny(" + 
				/*"ID int,"  +*/
				"Imie varchar(20)," + 
				"Nazwisko varchar(20)," + 
				"Zarobki int);"
				);
	}
	
	public void DodajDomownika(/*int ID,*/ String imie, String nazwisko, int zarobki){
		SQLiteDatabase db = getWritableDatabase();
		ContentValues wartosc = new ContentValues();
		//SQLiteDatabase write = getReadableDatabase();
		//String []kolumny = {"ID"};
		//Cursor kursor =write.query("PrzychodyRodziny", kolumny, null,null,null,null,null);

		//wartosc.put("ID", iloscEl);
		wartosc.put("Imie", imie);
		wartosc.put("Nazwisko", nazwisko);
		wartosc.put("Zarobki", zarobki);
		db.insertOrThrow("PrzychodyRodziny", null, wartosc);
	}
	
	public Cursor DajWszystkie(){
		String[] kolumny={/*"ID",*/"Imie", "Nazwisko", "Zarobki"};
		SQLiteDatabase db = getReadableDatabase();
		Cursor kursor =db.query("PrzychodyRodziny",kolumny,null,null,null,null,null);
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
		String where = "Imie = " + "'" +  cursor.getString(0)+ "'" + " and Nazwisko = " + "'" + cursor.getString(1) + "'";
		//Toast.makeText(tmp, where , Toast.LENGTH_LONG).show();
		db.delete("PrzychodyRodziny", where, null);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
		// TODO Auto-generated method stub
		db.execSQL("DROP TABLE PrzychodyRodziny;");
		//Toast.makeText(tmp, "USUNIETE", Toast.LENGTH_LONG).show();
		onCreate(db);
	}
	
	

}
