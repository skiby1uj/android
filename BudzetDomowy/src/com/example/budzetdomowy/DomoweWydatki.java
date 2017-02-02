package com.example.budzetdomowy;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class DomoweWydatki extends Activity {
	private ListView listView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_domowe_wydatki);
		
		ZarzadcaBazyDomoweWydatki zarzadca = new ZarzadcaBazyDomoweWydatki(this);
		//zarzadca.DodajDomowyWydatek("prad", 145);
		Cursor cursor = zarzadca.DajWszystkie();
		
		rowDomownik rowDomownik_data[] = new rowDomownik[zarzadca.iloscEl];
		int i = 0;
		int ubytek = 0;
		while(cursor.moveToNext()){
			rowDomownik data = new rowDomownik(cursor.getString(0), "\t" + cursor.getInt(1)+"");
			ubytek += cursor.getInt(1);
			rowDomownik_data[i] = data;
			i++;
			
		}
		
		TextView text =(TextView)findViewById(R.id.textView1);
		text.setText("Koszt Domowych wydatkow: "+ubytek);
		int saldo = 0;
		ZarzadcaBazy zarzadca2 = new ZarzadcaBazy(this);
		cursor = zarzadca2.DajWszystkie();
		
		while(cursor.moveToNext()){
			//rowDomownik data = new rowDomownik(cursor.getString(0), "\t" + cursor.getInt(1)+"");
			saldo += cursor.getInt(2);
			//rowDomownik_data[i] = data;
			i++;
			
		}
		
		text = (TextView)findViewById(R.id.textView2);
		text.setText("Saldo rodziny po wydatkach: " + (saldo-ubytek));

		RowAdapter adapter = new RowAdapter(this,
                R.layout.row_domownik, rowDomownik_data);
 
        listView = (ListView)findViewById(R.id.listView1);
 
        listView.setAdapter(adapter);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.domowe_wydatki, menu);
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
	public void Add(View w){
		ZarzadcaBazyDomoweWydatki zarzadca = new ZarzadcaBazyDomoweWydatki(this);
		EditText opis = (EditText)findViewById(R.id.editText1);
		EditText cena = (EditText)findViewById(R.id.editText2);
		zarzadca.DodajDomowyWydatek(opis.getText().toString(), Integer.parseInt(cena.getText()+""));
		Cursor cursor = zarzadca.DajWszystkie();
		
		rowDomownik rowDomownik_data[] = new rowDomownik[zarzadca.iloscEl];
		int i = 0;
		int ubytek = 0;
		while(cursor.moveToNext()){
			rowDomownik data = new rowDomownik(cursor.getString(0), "\t" + cursor.getInt(1)+"");
			ubytek += cursor.getInt(1);
			rowDomownik_data[i] = data;
			i++;
			
		}
		
		
		TextView text =(TextView)findViewById(R.id.textView1);
		text.setText("Koszt Domowych wydatkow: "+ubytek+"");
		
		int saldo = 0;
		ZarzadcaBazy zarzadca2 = new ZarzadcaBazy(this);
		cursor = zarzadca2.DajWszystkie();
		while(cursor.moveToNext()){
			//rowDomownik data = new rowDomownik(cursor.getString(0), "\t" + cursor.getInt(1)+"");
			saldo += cursor.getInt(2);
			//rowDomownik_data[i] = data;
			//i++;
			
		}
		
		text = (TextView)findViewById(R.id.textView2);
		text.setText("Saldo rodziny po wydatkach: " + (saldo - ubytek));
		RowAdapter adapter = new RowAdapter(this,
                R.layout.row_domownik, rowDomownik_data);
 
        listView = (ListView)findViewById(R.id.listView1);
 
        listView.setAdapter(adapter);
        
        
	}
}
