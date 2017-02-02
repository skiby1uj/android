package com.example.pizza;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.widget.TextView;
import android.widget.Toast;

public class Summary extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_summary);
		Intent intent = getIntent();
		int suma = intent.getIntExtra("COST", 0);
		
		TextView text = (TextView) findViewById(R.id.textView3);//type pizza
		text.setText(intent.getStringExtra("KAY"));
		
		text = (TextView) findViewById(R.id.textView4);//SIZE XXL 10zl
		if(intent.getBooleanExtra("SIZE0", true) == true){
			text.setText("YES");
			suma += 10;
		}
			
		else
			text.setText("NO");
		
		text = (TextView) findViewById(R.id.textView5);//Extra cheese 5zl
		if(intent.getBooleanExtra("SIZE1", true) == true){
			text.setText("YES");
			suma += 5;
		}
		else
			text.setText("NO");
		
		text = (TextView) findViewById(R.id.textView6);//Express service 10zl
		if(intent.getBooleanExtra("SIZE2", true) == true){
			text.setText("YES");
			suma += 10;
		}
		else
			text.setText("NO");
		
		text = (TextView) findViewById(R.id.textView8);//COST FOR PIZZA
		text.setText(suma + " zl");
		
		text = (TextView) findViewById(R.id.textView2);//comment
		text.setText(intent.getStringExtra("COMMENT"));	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.summary, menu);
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
	
	public void SummaryReset(View w){
		Intent intent = new Intent(this, MainActivity.class);
    	intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);//wszystkie wczesniejsze aktywnosci zamyka
		startActivity(intent);
	}
	
	public void SummaryAccept(View w){
		Toast.makeText(this, "Complet", Toast.LENGTH_LONG).show();
		this.finishAffinity();
	}
}
