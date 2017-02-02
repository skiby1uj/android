package com.example.budzetdomowy;

import java.sql.SQLClientInfoException;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class ZarzadcaBazy extends SQLiteOpenHelper {
	public static int iloscEl = 0;
	public ZarzadcaBazy(Context context) {
		super(context, "domownicy.db", null, 1);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		
		db.execSQL(
				"create table Domownicy(" + 
				"Imie varchar(20)," + 
				"Nazwisko varchar(20)," + 
				"Zarobki int);"
				);
		
	}
	
	public void DodajDomownika(String imie, String nazwisko,/*, String wydatek,*/ int zarobki){
		SQLiteDatabase db = getWritableDatabase();
		ContentValues wartosc = new ContentValues();
		wartosc.put("Imie", imie);
		wartosc.put("Nazwisko", nazwisko);
		//wartosc.put("Wydatek", wydatek);
		wartosc.put("Zarobki", zarobki);
		db.insertOrThrow("Domownicy", null, wartosc);
	}
	
	public Cursor DajWszystkie(){
		String[] kolumny={"Imie", "Nazwisko", "Zarobki"};
		SQLiteDatabase db = getReadableDatabase();
		Cursor kursor =db.query("Domownicy",kolumny,null,null,null,null,null);
		iloscEl = kursor.getCount();
		return kursor;
	}


	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}

}
