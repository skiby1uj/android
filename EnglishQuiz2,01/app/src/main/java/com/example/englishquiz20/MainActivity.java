package com.example.englishquiz20;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Intent intent = getIntent();
        if(intent.getIntExtra("page", 1) == 1){
        	TextView text = (TextView) findViewById(R.id.textView1);
        	text.setText("dog");
        	ImageButton image = (ImageButton) findViewById(R.id.imageButton1);
        	image.setImageResource(R.drawable.cat);
        	image = (ImageButton) findViewById(R.id.imageButton2);
        	image.setImageResource(R.drawable.dog);
        	image = (ImageButton) findViewById(R.id.imageButton3);
        	image.setImageResource(R.drawable.drhouse);
        	image = (ImageButton) findViewById(R.id.imageButton4);
        	image.setImageResource(R.drawable.house);
        }
        else if(intent.getIntExtra("page", 1) == 2){
        	TextView text = (TextView) findViewById(R.id.textView1);
        	text.setText("cat");
        	ImageButton image = (ImageButton) findViewById(R.id.imageButton1);
        	image.setImageResource(R.drawable.dog);
        	image = (ImageButton) findViewById(R.id.imageButton2);
        	image.setImageResource(R.drawable.house);
        	image = (ImageButton) findViewById(R.id.imageButton3);
        	image.setImageResource(R.drawable.cat);
        	image = (ImageButton) findViewById(R.id.imageButton4);
        	image.setImageResource(R.drawable.drhouse);
        }
        else if(intent.getIntExtra("page", 1) == 3){
        	TextView text = (TextView) findViewById(R.id.textView1);
        	text.setText("house");
        	ImageButton image = (ImageButton) findViewById(R.id.imageButton1);
        	image.setImageResource(R.drawable.house);
        	image = (ImageButton) findViewById(R.id.imageButton2);
        	image.setImageResource(R.drawable.cat);
        	image = (ImageButton) findViewById(R.id.imageButton3);
        	image.setImageResource(R.drawable.drhouse);
        	image = (ImageButton) findViewById(R.id.imageButton4);
        	image.setImageResource(R.drawable.dog);
        }
        else if(intent.getIntExtra("page", 1) == 4){
        	TextView text = (TextView) findViewById(R.id.textView1);
        	text.setText("House");
        	ImageButton image = (ImageButton) findViewById(R.id.imageButton1);
        	image.setImageResource(R.drawable.house);
        	image = (ImageButton) findViewById(R.id.imageButton2);
        	image.setImageResource(R.drawable.drhouse);
        	image = (ImageButton) findViewById(R.id.imageButton3);
        	image.setImageResource(R.drawable.dog);
        	image = (ImageButton) findViewById(R.id.imageButton4);
        	image.setImageResource(R.drawable.cat);
        }
        
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
    
    public void imageButton1(View w){
    	Intent intent = getIntent();
    	if(intent.getIntExtra("page", 1) == 1){
    		Intent hop = new Intent(this, MainActivity.class);
    		hop.putExtra("question01", false);
    		hop.putExtra("page", 2);
    		startActivity(hop);
    	}
    	else if(intent.getIntExtra("page", 1) == 2){
    		Intent hop = new Intent(this, MainActivity.class);
    		hop.putExtra("question01", intent.getBooleanExtra("question01", true));
    		hop.putExtra("question02", false);
    		hop.putExtra("page", 3);
    		startActivity(hop);
    	}
    	else if(intent.getIntExtra("page", 1) == 3){
    		Intent hop = new Intent(this, MainActivity.class);
    		hop.putExtra("question01", intent.getBooleanExtra("question01", true));
    		hop.putExtra("question02", intent.getBooleanExtra("question02", true));
    		hop.putExtra("question03", true);
    		hop.putExtra("page", 4);
    		startActivity(hop);
    	}
    	else if(intent.getIntExtra("page", 1) == 4){//summary
    		Intent hop = new Intent(this, Summary.class);
    		hop.putExtra("question01", intent.getBooleanExtra("question01", true));
    		hop.putExtra("question02", intent.getBooleanExtra("question02", true));
    		hop.putExtra("question03", intent.getBooleanExtra("question03", true));
    		hop.putExtra("question04", false);
    		hop.putExtra("page", 5);
    		startActivity(hop);
    	}
    }
    //***********************************************************
	public void imageButton2(View w){
	    	Intent intent = getIntent();
	    	if(intent.getIntExtra("page", 1) == 1){
	    		Intent hop = new Intent(this, MainActivity.class);
	    		hop.putExtra("question01", true);
	    		hop.putExtra("page", 2);
	    		startActivity(hop);
	    	}
	    	else if(intent.getIntExtra("page", 1) == 2){
	    		Intent hop = new Intent(this, MainActivity.class);
	    		hop.putExtra("question01", intent.getBooleanExtra("question01", true));
	    		hop.putExtra("question02", false);
	    		hop.putExtra("page", 3);
	    		startActivity(hop);
	    	}
	    	else if(intent.getIntExtra("page", 1) == 3){
	    		Intent hop = new Intent(this, MainActivity.class);
	    		hop.putExtra("question01", intent.getBooleanExtra("question01", true));
	    		hop.putExtra("question02", intent.getBooleanExtra("question02", true));
	    		hop.putExtra("question03", false);
	    		hop.putExtra("page", 4);
	    		startActivity(hop);
	    	}
	    	else if(intent.getIntExtra("page", 1) == 4){//summary
	    		Intent hop = new Intent(this, Summary.class);
	    		hop.putExtra("question01", intent.getBooleanExtra("question01", true));
	    		hop.putExtra("question02", intent.getBooleanExtra("question02", true));
	    		hop.putExtra("question03", intent.getBooleanExtra("question03", true));
	    		hop.putExtra("question04", true);
	    		hop.putExtra("page", 5);
	    		startActivity(hop);
	    	}
	    	
	    }
	//******************************************************
	public void imageButton3(View w){
		Intent intent = getIntent();
    	if(intent.getIntExtra("page", 1) == 1){
    		Intent hop = new Intent(this, MainActivity.class);
    		hop.putExtra("question01", false);
    		hop.putExtra("page", 2);
    		startActivity(hop);
    	}
    	else if(intent.getIntExtra("page", 1) == 2){
    		Intent hop = new Intent(this, MainActivity.class);
    		hop.putExtra("question01", intent.getBooleanExtra("question01", true));
    		hop.putExtra("question02", true);
    		hop.putExtra("page", 3);
    		startActivity(hop);
    	}
    	else if(intent.getIntExtra("page", 1) == 3){
    		Intent hop = new Intent(this, MainActivity.class);
    		hop.putExtra("question01", intent.getBooleanExtra("question01", true));
    		hop.putExtra("question02", intent.getBooleanExtra("question02", true));
    		hop.putExtra("question03", false);
    		hop.putExtra("page", 4);
    		startActivity(hop);
    	}
    	else if(intent.getIntExtra("page", 1) == 4){//summary
    		Intent hop = new Intent(this, Summary.class);
    		hop.putExtra("question01", intent.getBooleanExtra("question01", true));
    		hop.putExtra("question02", intent.getBooleanExtra("question02", true));
    		hop.putExtra("question03", intent.getBooleanExtra("question03", true));
    		hop.putExtra("question04", false);
    		hop.putExtra("page", 5);
    		startActivity(hop);
    	}
	}
	//******************************************************
	public void imageButton4(View w){
		Intent intent = getIntent();
    	if(intent.getIntExtra("page", 1) == 1){
    		Intent hop = new Intent(this, MainActivity.class);
    		hop.putExtra("question01", false);
    		hop.putExtra("page", 2);
    		startActivity(hop);
    	}
    	else if(intent.getIntExtra("page", 1) == 2){
    		Intent hop = new Intent(this, MainActivity.class);
    		hop.putExtra("question01", intent.getBooleanExtra("question01", true));
    		hop.putExtra("question02", false);
    		hop.putExtra("page", 3);
    		startActivity(hop);
    	}
    	else if(intent.getIntExtra("page", 1) == 3){
    		Intent hop = new Intent(this, MainActivity.class);
    		hop.putExtra("question01", intent.getBooleanExtra("question01", true));
    		hop.putExtra("question02", intent.getBooleanExtra("question02", true));
    		hop.putExtra("question03", false);
    		hop.putExtra("page", 4);
    		startActivity(hop);
    	}
    	else if(intent.getIntExtra("page", 1) == 4){//summary
    		Intent hop = new Intent(this, Summary.class);
    		hop.putExtra("question01", intent.getBooleanExtra("question01", true));
    		hop.putExtra("question02", intent.getBooleanExtra("question02", true));
    		hop.putExtra("question03", intent.getBooleanExtra("question03", true));
    		hop.putExtra("question04", false);
    		hop.putExtra("page", 5);
    		startActivity(hop);
    	}
	}
}
