package com.example.pizza;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends Activity {
	Finish output = new Finish();
	// public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
    
    public void actionSendPizza1(View w){//next window
    	Intent hop = new Intent(this, Extras.class);
    	
    	hop.putExtra("KAY", "pizza 1" );
    	//hop.putExtra("COST", "20 zl");
    	hop.putExtra("COST", 20);
		startActivity(hop);
    }
    
    public void actionSendPizza2(View w){// next window
    	Intent hop = new Intent(this, Extras.class);
    	hop.putExtra("KAY", "pizza 2");
    	hop.putExtra("COST", 25);
    	//hop.putExtra("COST", "25 zl");

		startActivity(hop);
    }
    
    public void actionSendPizza3(View w){// next window
    	Intent hop = new Intent(this, Extras.class);
    
    	hop.putExtra("KAY", "pizza 3");
    	hop.putExtra("COST", 30);
    	
    	//hop.putExtra("COST", "30 zl");
		startActivity(hop);
    }
}
