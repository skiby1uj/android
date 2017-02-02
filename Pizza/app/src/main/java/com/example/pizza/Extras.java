package com.example.pizza;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;


public class Extras extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_extras);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.extras, menu);
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
	
	public void ExtrasNext(View w){
	    Intent hop = new Intent(this, Comment.class);
	    
	    CheckBox box=(CheckBox) findViewById(R.id.checkBox1);
	    boolean checkBox[] = new boolean[3];
	    
	    checkBox[0] = box.isChecked();
	    box=(CheckBox) findViewById(R.id.checkBox2);
	    checkBox[1] = box.isChecked();
	    box=(CheckBox) findViewById(R.id.checkBox3);
	    checkBox[2] = box.isChecked();
	    
	    hop.putExtra("SIZE0", checkBox[0]);
	    hop.putExtra("SIZE1", checkBox[1]);
	    hop.putExtra("SIZE2", checkBox[2]);
	    //hop.putExtra("SIZE", checkBox);
	    
	    Intent intent = getIntent();
	    //String message = intent.getStringExtra("KAY");
	    //String cost = intent.getStringExtra("COST");
	    //hop.putExtra("COST", intent.getExtras();
	    hop.putExtra("COST", intent.getIntExtra("COST", 0));
	    hop.putExtra("KAY", intent.getStringExtra("KAY"));
	    //int cos = intent.getIntExtra("COST", 10);
	    //Toast.makeText(this, cos + "" , Toast.LENGTH_LONG).show();
	    
		startActivity(hop);
   }
	public void ExtrasCancel(View w){
		this.finish();
	}
}
