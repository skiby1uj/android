package com.example.budzetdomowy2_0;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class PrzychodyRodziny extends Activity {
	private ListView listView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_przychody_rodziny);
		
		Refresh();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.przychody_rodziny, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void DodajButton(View w){
		ZarzadcaBazyPrzychodyRodziny zarzadca = new ZarzadcaBazyPrzychodyRodziny(this);
		EditText text = (EditText)findViewById(R.id.Imie);
		String imie = text.getText().toString();
		text = (EditText)findViewById(R.id.Nazwisko);
		String nazwisko = text.getText().toString();
		text = (EditText)findViewById(R.id.Zarobki);
		String i = text.getText().toString();
		if(i.equals(""))
			Toast.makeText(this, "Podaj zarobki!", Toast.LENGTH_LONG).show();
		else{
			int zarobki = Integer.parseInt(text.getText()+"");
			zarzadca.DodajDomownika(imie, nazwisko, zarobki);
			Refresh();
		}
	}
	
	public void Refresh(){
		ZarzadcaBazyPrzychodyRodziny zarzadca = new ZarzadcaBazyPrzychodyRodziny(this);
		Cursor cursor = zarzadca.DajWszystkie();
		//Toast.makeText(this, zarzadca.iloscEl + " ", Toast.LENGTH_SHORT).show();
		rowPrzychodyRodziny rowPrzychodyRodziny_data[] = new rowPrzychodyRodziny[zarzadca.iloscEl];
		int i = 0;
		int suma = 0;
		while(cursor.moveToNext()){
			
			rowPrzychodyRodziny data = new rowPrzychodyRodziny(/*cursor.getInt(0),*/ cursor.getString(0), cursor.getString(1), cursor.getInt(2));
			//Toast.makeText(this, cursor.getString(1), Toast.LENGTH_LONG).show();
			suma += cursor.getInt(2);
			rowPrzychodyRodziny_data[i] = data;
			i++;
		}
		zarzadca.suma = suma;
		
		rowPrzychodyRodzinyAdapter adapter = new rowPrzychodyRodzinyAdapter(this, R.layout.row_przychody_rodziny, rowPrzychodyRodziny_data);
		listView = (ListView)findViewById(R.id.listViewPrzychodyRodziny);
		listView.setAdapter(adapter);
	}
	
	public void buttonUsun(View w){
		final Dialog dialog = new Dialog(this);
		dialog.setContentView(R.layout.deleting_dialog);
		final EditText text = (EditText)dialog.findViewById(R.id.editTextIDelete);
		Button button = (Button)dialog.findViewById(R.id.ButtonUsun);
		final Context tmp = this;
		
		
		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ZarzadcaBazyPrzychodyRodziny zarzadca = new ZarzadcaBazyPrzychodyRodziny(tmp);
				//Toast.makeText(tmp, "CLICK" + text.getText(), Toast.LENGTH_LONG).show();
				zarzadca.UsunWydatek(Integer.parseInt(text.getText()+""));
				Refresh();
			}
		});
		dialog.show();
	}
}
