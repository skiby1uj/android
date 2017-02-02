package com.example.budzetdomowy;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Domownicy extends Activity {
	private ListView listView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_domownicy);
		
		ZarzadcaBazy zarzadca = new ZarzadcaBazy(this);
		//zarzadca.DodajWydatek("Grzegorz", "Krzeszowski", "MOTOR!!!",4500 );
		//zarzadca.DodajWydatek("Adnrzej", "Krzeszowski", "costam", 12);
		//zarzadca.DodajDomownika("Grzes", "Trudny",0 );
		Cursor cursor = zarzadca.DajWszystkie();
		
		Toast.makeText(this, zarzadca.iloscEl + " ", Toast.LENGTH_SHORT).show();
		rowDomownik rowDomownik_data[] = new rowDomownik[zarzadca.iloscEl];
		int i = 0;
		int przychod = 0;
		while(cursor.moveToNext()){
			rowDomownik data = new rowDomownik(cursor.getString(0) + " " + cursor.getString(1), "\t" + cursor.getInt(2)+"");
			przychod += cursor.getInt(2);
			rowDomownik_data[i] = data;
			i++;
			
		}
		TextView text =(TextView)findViewById(R.id.PrzychodMiesieczny);
		text.setText("Przychody rodziny: "+przychod+"");
		RowAdapter adapter = new RowAdapter(this,
                R.layout.row_domownik, rowDomownik_data);
 
        listView = (ListView)findViewById(R.id.listView1);
 
        final Context tmp = this;
        listView.setAdapter(adapter);
        
        
       /* listView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                    long id) {
               
                //String item = ((TextView)view).getText().toString();
            	CheckBox box = (CheckBox)findViewById(R.id.checkBox1);
            	if(box.isChecked()){
            		ZarzadcaBazy zarzadca = new ZarzadcaBazy(tmp);
            		Cursor cursor = zarzadca.DajWszystkie();
            		//zarzadca
            	}
                //Toast.makeText(tmp, "Kurwa dziala", Toast.LENGTH_LONG).show();
               
            }
        });*/
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.domownicy, menu);
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
		ZarzadcaBazy zarzadca = new ZarzadcaBazy(this);
		EditText imie = (EditText)findViewById(R.id.editText2);
		EditText nazwisko = (EditText)findViewById(R.id.editText1);
		EditText zarobki = (EditText)findViewById(R.id.editText3);
		//Toast.makeText(this, imie.getText().toString(), Toast.LENGTH_LONG).show();
		//zarzadca.DodajDomownika(imie.getText(), nazwisko.getText(), Integer.parseInt(zarobki.getText()+""));
		//int zar = Integer.parseInt(zarobki.getText()+"");
		zarzadca.DodajDomownika(imie.getText().toString(), nazwisko.getText().toString(), Integer.parseInt(zarobki.getText()+""));
		Cursor cursor = zarzadca.DajWszystkie();
		
		Toast.makeText(this, zarzadca.iloscEl + " ", Toast.LENGTH_SHORT).show();
		rowDomownik rowDomownik_data[] = new rowDomownik[zarzadca.iloscEl];
		int i = 0;
		int przychod = 0;
		while(cursor.moveToNext()){
			rowDomownik data = new rowDomownik(cursor.getString(0) + " " + cursor.getString(1), "\t" + cursor.getInt(2)+"");
			
			rowDomownik_data[i] = data;
			i++;
			przychod += cursor.getInt(2);
			
		}
		TextView text =(TextView)findViewById(R.id.PrzychodMiesieczny);
		text.setText(przychod+"");
		RowAdapter adapter = new RowAdapter(this,
                R.layout.row_domownik, rowDomownik_data);
 
        listView = (ListView)findViewById(R.id.listView1);
 
        listView.setAdapter(adapter);
	}
}
