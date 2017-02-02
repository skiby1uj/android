package com.example.englishquiz20;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class Summary extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_summary);
		
		TextView text = (TextView) findViewById(R.id.textView2);
		Intent intent = getIntent();
		if(intent.getBooleanExtra("question01", true))
			text.setText("YES");
		else 
			text.setText("NO");
		text = (TextView) findViewById(R.id.textView4);
		if(intent.getBooleanExtra("question02", true))
			text.setText("YES");
		else 
			text.setText("NO");
		text = (TextView) findViewById(R.id.textView6);
		if(intent.getBooleanExtra("question03", true))
			text.setText("YES");
		else 
			text.setText("NO");
		text = (TextView) findViewById(R.id.textView8);
		if(intent.getBooleanExtra("question04", true))
			text.setText("YES");
		else 
			text.setText("NO");
		
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
	
	public void Reset(View w){
		Intent hop = new Intent(this, MainActivity.class);
		//Intent intent = new Intent(this, Summary.class);
		//intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		hop.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		//hop.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
		startActivity(hop);
	}
}
