package com.example.budzetdomowy2_0;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class HistoriaMiesiaca extends Activity {

	ListView listView = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_historia_miesiaca);
		Intent intent = getIntent();
		//Toast.makeText(this, intent.getIntExtra("iloscMiesiecy", 0)+"", Toast.LENGTH_LONG).show();
		//Toast.makeText(this,intent.getIntExtra("miesiac", 0)+"" , Toast.LENGTH_LONG).show();
		
		ZarzadcaBazyHistoria zarzadca = new ZarzadcaBazyHistoria(this, intent.getIntExtra("miesiac", 0)/*, intent.getIntExtra("rok", 0)*/);
		Cursor cursor = zarzadca.DajWszystkie();
		rowWydatkiCykliczne rowWydatkiCykliczne_data[] = new rowWydatkiCykliczne[zarzadca.iloscEl];
		
		
		
		int i = 0;
		int saldo = 0;
		if(cursor.moveToNext()){
			
			rowWydatkiCykliczne data = new rowWydatkiCykliczne( cursor.getString(0), cursor.getInt(1));
			rowWydatkiCykliczne_data[i] = data;
			saldo = cursor.getInt(2) - cursor.getInt(1);
			i++;
		}
		while(cursor.moveToNext()){
			saldo -= cursor.getInt(1);
			//Toast.makeText(this, zarzadca.iloscEl + " ", Toast.LENGTH_LONG).show();
			rowWydatkiCykliczne data = new rowWydatkiCykliczne(/*cursor.getInt(0),*/ cursor.getString(0), cursor.getInt(1));
			rowWydatkiCykliczne_data[i] = data;
			i++;
		}
		
		TextView text = (TextView)findViewById(R.id.textView1);
		text.setText("Historia wydatków z miesi¹ca " + intent.getIntExtra("miesiac", 0));
		text = (TextView)findViewById(R.id.textView2);
		text.setText("Saldo konta za miesi¹c " + intent.getIntExtra("miesiac", 0) + ": " + saldo + " zl");
		rowWydatkiCykliczneAdapter adapter = new rowWydatkiCykliczneAdapter(this, R.layout.row_wydatki_cykliczne, rowWydatkiCykliczne_data);
		listView = (ListView)findViewById(R.id.listView1);
		listView.setAdapter(adapter);
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.historia_miesiaca, menu);
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
}
