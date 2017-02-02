package com.example.budzetdomowy2_0;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ZarzadcaBazyHistoria extends SQLiteOpenHelper {
	private static String tabela = null;
	private static Context context = null;
	private static int miesiac = 0;
	public static int iloscEl = 0;
	public ZarzadcaBazyHistoria(Context context, int miesiac/*, int rok*/) {//rok - wersja bazy
		super(context, "HistoriaMiesiac_" + miesiac + ".db", null, 1);
		tabela = "HistoriaMiesiac_" + miesiac;
		this.context = context;
		this.miesiac = miesiac;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL("CREATE TABLE "+ tabela+ "(" +
					"Opis varchar(50)," +
					"Koszt int, " + 
					"Zarobki int);");

		//RozliczMiesiac();
	}
	
	public Cursor DajWszystkie(){
		String kolumny[] = {"Opis", "Koszt", "Zarobki"};
		SQLiteDatabase db = getReadableDatabase();
		Cursor cursor = db.query(tabela, kolumny,null,null,null,null,null);
		iloscEl = cursor.getCount();
		return cursor;
	}
	
	public void Dodaj(String opis, int koszt, int zarobki){
		SQLiteDatabase db = getWritableDatabase();
		ContentValues wartosc = new ContentValues();
		wartosc.put("Opis", opis);
		wartosc.put("Koszt", koszt);
		wartosc.put("Zarobki", zarobki);
		db.insertOrThrow(tabela, null, wartosc);
	}
	
	public void UsunTabele(){
		SQLiteDatabase db = getWritableDatabase();
		db.execSQL("DROP TABLE " + tabela + ";");
	}
	
	public void UsunWszystkie(){
		SQLiteDatabase db = getWritableDatabase();
		for(int i = 1; i<=13 /*&& i <= miesiac*/;i++){
			db.execSQL("DROP TABLE " + "HistoriaMiesiac_" + i);
		}
	}
	
	public void RozliczMiesiac(){
		ZarzadcaBazyPrzychodyRodziny zarz = new ZarzadcaBazyPrzychodyRodziny(context);//w pierwszem wierszu w 2 kolumnie jest wynik zarobkow
		Cursor cursor2 = zarz.DajWszystkie();
		int suma = 0;
		while(cursor2.moveToNext()){
			suma += cursor2.getInt(2);
		}
		/*SQLiteDatabase db = getWritableDatabase();
		ContentValues wartosc = new ContentValues();
		wartosc.put("miesiac", miesiac);
		wartosc.put("zarobki", suma);
		db.insertOrThrow("HistoriaZarobkow", null, wartosc);*/
		
		ZarzadcaBazyWydatkiNiePlanowane zarzadca = new ZarzadcaBazyWydatkiNiePlanowane(context);
		Cursor cursor = zarzadca.DajWszystkich();
		/*if(cursor.moveToNext()){
			SQLiteDatabase db = getWritableDatabase();
			ContentValues wartosc = new ContentValues();
			wartosc.put("Opis", cursor.getString(0));
			wartosc.put("Koszt", cursor.getInt(1));
			wartosc.put("Zarobki", suma);
			db.insertOrThrow(tabela, null, wartosc);
		}*/
		while(cursor.moveToNext()){
			Dodaj(cursor.getString(0), cursor.getInt(1),suma);
		}
		zarzadca.deleteAll();
		
		ZarzadcaBazyWydatkiPlanowane zarzadca2 = new ZarzadcaBazyWydatkiPlanowane(context);
		cursor = zarzadca2.DajWszystkie();
		while(cursor.moveToNext()){
			Dodaj(cursor.getString(0), cursor.getInt(1), suma);
		}
		zarzadca2.DeleteAll();
		ZarzadcaBazyWydatkiCykliczne zarzadca3 = new ZarzadcaBazyWydatkiCykliczne(context);
		cursor = zarzadca3.DajWszystkieWydatkiCykliczne();
		while(cursor.moveToNext()){
			Dodaj(cursor.getString(0), cursor.getInt(1),suma);
		}
	}
	
	public int getWydatkiMiesiaca(){
		Cursor cursor = DajWszystkie();
		int suma = 0;
		while(cursor.moveToNext()){
			suma += cursor.getInt(1);
		}
		return suma;
	}
	
	public int getZarobkiMiesiaca(){
		Cursor cursor = DajWszystkie();
		if(cursor.moveToNext())
			return cursor.getInt(2);
		else
			return 0;
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL("DROP TABLE " + tabela);
		onCreate(db);

	}

}
