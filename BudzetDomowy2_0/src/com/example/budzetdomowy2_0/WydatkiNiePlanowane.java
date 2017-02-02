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

public class WydatkiNiePlanowane extends Activity {

	private ListView listView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_wydatki_nie_planowane);
		
		Refresh();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.wydatki_nie_planowane, menu);
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
		ZarzadcaBazyWydatkiNiePlanowane zarzadca = new ZarzadcaBazyWydatkiNiePlanowane(this);
		EditText text = (EditText)findViewById(R.id.OpisWydatku);
		String opis = text.getText().toString();
		text = (EditText)findViewById(R.id.CenaWydatku);
		String i = text.getText().toString();
		if(i.equals(""))
			Toast.makeText(this, "Podaj wydatek!", Toast.LENGTH_LONG).show();
		else{
		zarzadca.DodajWydatek(opis, Integer.parseInt(text.getText()+""));
		Refresh();
		}
	}
	
	public void Refresh(){
		ZarzadcaBazyWydatkiNiePlanowane zarzadca = new ZarzadcaBazyWydatkiNiePlanowane(this);
		Cursor cursor = zarzadca.DajWszystkich();
		rowWydatkiNiePlanowane rowWydatkiNiePlanowane_data[] = new rowWydatkiNiePlanowane[zarzadca.iloscEl];
		int i = 0;
		//Toast.makeText(this, zarzadca.iloscEl+"", Toast.LENGTH_LONG).show();
		while(cursor.moveToNext()){
			//Toast.makeText(this,cursor.getString(1) , Toast.LENGTH_LONG).show();

			rowWydatkiNiePlanowane data = new rowWydatkiNiePlanowane(cursor.getString(0), cursor.getInt(1));
			rowWydatkiNiePlanowane_data[i] = data;
			i++;
		}
		rowWydatkiNiePlanowaneAdapter adapter = new rowWydatkiNiePlanowaneAdapter(this, R.layout.row_wydatki_cykliczne/*row_wydatki_nie_planowane*/, rowWydatkiNiePlanowane_data);
		listView = (ListView)findViewById(R.id.listViewWydatkiNiePlanowane);
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
				ZarzadcaBazyWydatkiNiePlanowane zarzadca = new ZarzadcaBazyWydatkiNiePlanowane(tmp);
				//Toast.makeText(tmp, "CLICK" + text.getText(), Toast.LENGTH_LONG).show();
				zarzadca.UsunWydatek(Integer.parseInt(text.getText()+""));
				Refresh();
			}
		});
		dialog.show();
	}
	
}
