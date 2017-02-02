package com.example.panicbutton;

import java.util.ArrayList;
import java.util.Arrays;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class ListSendSms extends Activity {

	private SharedPreferences sharedpreferences;
	private ListView list ; 
    private ArrayAdapter<String> adapter ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_send_sms);
		Refresh();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.list_send_sms, menu);
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
	
	private void Refresh(){
		sharedpreferences = getSharedPreferences("ListContact", Activity.MODE_PRIVATE);
		String numbers[] = sharedpreferences.getString("numbers", "You didn't give numbers").toString().split(",");
		list =(ListView)findViewById(R.id.listView1);
		 ArrayList<String> carL = new ArrayList<String>(); 
	     carL.addAll( Arrays.asList(numbers) );
	     adapter = new ArrayAdapter<String>(this, R.layout.row, carL);
	     list.setAdapter(adapter);
	}
	
	public void AddNumber(View w){
		EditText text = (EditText)findViewById(R.id.editText1);
		sharedpreferences = getSharedPreferences("ListContact", Activity.MODE_PRIVATE);
		SharedPreferences.Editor preferencesEditor = sharedpreferences.edit();
		preferencesEditor.putString("numbers", sharedpreferences.getString("numbers", "") + text.getText().toString() +",");
		preferencesEditor.commit();
		Refresh();
		text.setText("");
	}
	
	public void DeleteNumbers(View w){
		sharedpreferences = getSharedPreferences("ListContact", Activity.MODE_PRIVATE);
		SharedPreferences.Editor preferencesEditor = sharedpreferences.edit();
		preferencesEditor.putString("numbers", "");
		preferencesEditor.commit();
		Refresh();
	}
}
