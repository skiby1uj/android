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

public class WydatkiCykliczne extends Activity {

	private ListView listView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_wydatki_cykliczne);
		Refresh();
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.wydatki_cykliczne, menu);
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
		ZarzadcaBazyWydatkiCykliczne zarzadca = new ZarzadcaBazyWydatkiCykliczne(this);
		//EditText text = (EditText)findViewById(R.id.ID);
		//int ID = text.getText().toString();
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
		ZarzadcaBazyWydatkiCykliczne zarzadca = new ZarzadcaBazyWydatkiCykliczne(this);
		Cursor cursor = zarzadca.DajWszystkieWydatkiCykliczne();
		rowWydatkiCykliczne rowWydatkiCykliczne_data[] = new rowWydatkiCykliczne[zarzadca.iloscEl];
		int i = 0;
		while(cursor.moveToNext()){
			//Toast.makeText(this, zarzadca.iloscEl + " ", Toast.LENGTH_LONG).show();
			rowWydatkiCykliczne data = new rowWydatkiCykliczne(/*cursor.getInt(0),*/ cursor.getString(0), cursor.getInt(1));
			rowWydatkiCykliczne_data[i] = data;
			i++;
		}
		
		rowWydatkiCykliczneAdapter adapter = new rowWydatkiCykliczneAdapter(this, R.layout.row_wydatki_cykliczne, rowWydatkiCykliczne_data);
		listView = (ListView)findViewById(R.id.listViewWydatkiCykliczne);
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
				ZarzadcaBazyWydatkiCykliczne zarzadca = new ZarzadcaBazyWydatkiCykliczne(tmp);
				//Toast.makeText(tmp, "CLICK" + text.getText(), Toast.LENGTH_LONG).show();
				zarzadca.UsunWydatek(Integer.parseInt(text.getText()+""));
				Refresh();
			}
		});
		dialog.show();
	}
}
