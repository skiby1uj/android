package com.example.budzetdomowy2_0;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class Wydatki extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_wydatki);
		
		
	}
	
	protected void onResume(){
		super.onResume();
		Button button = (Button)findViewById(R.id.WydatkiCykliczneButton);
		button.setText("Wydatki cykliczne\nsuma: " + getSumaWydatkiCykliczne() + " zl");
		button = (Button)findViewById(R.id.WydatkiPlanowaneButton);
		button.setText("Wydatki planowane\nsuma: " + getSumaWydatkiPlanowane() + " zl");
		button = (Button)findViewById(R.id.WydatkiNiePlanowane);
		button.setText("Wydatki nie planowane\nsuma: " + getSumaWydatkiNiePlanowane() + " zl");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.wydatki, menu);
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
	
	public void WydatkiCykliczneButton(View w){
		Intent intent = new Intent(this, WydatkiCykliczne.class);
		startActivity(intent);
	}
	
	public void WydatkiPlanowaneButton(View w){
		Intent intent = new Intent(this, WydatkiPlanowane.class);
		startActivity(intent);
	}
	
	public void WydatkiNiePlanowane(View w){
		Intent intent = new Intent(this, WydatkiNiePlanowane.class);
		startActivity(intent);
	}
	
	public int getSumaWydatkiCykliczne(){
		ZarzadcaBazyWydatkiCykliczne zarzadca = new ZarzadcaBazyWydatkiCykliczne(this);
		Cursor cursor = zarzadca.DajWszystkieWydatkiCykliczne();
		int i = 0;
		int suma = 0;
		while(cursor.moveToNext()){
			suma += cursor.getInt(1);
			i++;
		}
		return suma;
	}
	
	public int getSumaWydatkiPlanowane(){
		ZarzadcaBazyWydatkiPlanowane zarzadca = new ZarzadcaBazyWydatkiPlanowane(this);
		Cursor cursor = zarzadca.DajWszystkie();
		int i = 0;
		int suma = 0;
		while(cursor.moveToNext()){
			suma += cursor.getInt(1);
			i++;
		}
		return suma;
	}
	
	public int getSumaWydatkiNiePlanowane(){
		ZarzadcaBazyWydatkiNiePlanowane zarzadca = new ZarzadcaBazyWydatkiNiePlanowane(this);
		Cursor cursor = zarzadca.DajWszystkich();
		int i = 0;
		int suma = 0;
		while(cursor.moveToNext()){
			suma += cursor.getInt(1);
			i++;
		}
		return suma;
	}
}
