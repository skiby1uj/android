package com.example.panicbutton;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class AlarmNumber extends Activity {

	private SharedPreferences sharedpreferences;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_alarm_number);
		sharedpreferences = getSharedPreferences("Alarm Number", Activity.MODE_PRIVATE);
		TextView number = (TextView)findViewById(R.id.textView1);
		number.setText(sharedpreferences.getString("number", "112"));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.alarm_number, menu);
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
	
	public void EditNumber(View w){
		EditText text = (EditText)findViewById(R.id.editText1);
		SharedPreferences.Editor preferencesEditor = sharedpreferences.edit();
		preferencesEditor.putString("number", text.getText().toString());
		preferencesEditor.commit();
		TextView number =(TextView)findViewById(R.id.textView1);
		number.setText(text.getText().toString());
	}
	
	public void Delete(View w){
		TextView text = (TextView)findViewById(R.id.textView1);
		SharedPreferences.Editor preferencesEditor = sharedpreferences.edit();
		preferencesEditor.putString("number", " ");
		preferencesEditor.commit();
		text.setText("");
	}
}
