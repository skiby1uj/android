package com.example.pizza;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class Comment extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_comment);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.comment, menu);
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
	
	public void CommentNext(View w){
		Intent hop = new Intent(this, Summary.class);		
   		Intent intent = getIntent();
   		
   		EditText text = (EditText)findViewById(R.id.editText1);
   		String comment = text.getText()+"";
   		
   		hop.putExtra("COMMENT", comment);
   		hop.putExtra("SIZE0", intent.getBooleanExtra("SIZE0", false));
   		hop.putExtra("SIZE1", intent.getBooleanExtra("SIZE1", false));
   		hop.putExtra("SIZE2", intent.getBooleanExtra("SIZE2", false));
   		hop.putExtra("COST", intent.getIntExtra("COST", 0));
	    //hop.putExtra("COST", intent.getStringExtra("COST"));
	    hop.putExtra("KAY", intent.getStringExtra("KAY"));
   		
		startActivity(hop);
	}
	
	public void CommentCancel(View w){
		this.finish();
	}
}
