package com.example.encyklopedia;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewDebug.FlagToString;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {
	//int ID = 0;
	
    @Override
  /*  protected void onResume(){
    	super.onResume();
    	if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE && ID != 0){
        	Toast.makeText(this, "wlazl000", Toast.LENGTH_LONG).show();
        	Intent intent = new Intent(this, Description.class);
        	intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        	intent.putExtra("ID", ID);
        	startActivity(intent);
        }
    }*/
    
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
    
    public void textView1(View w){
    	//ID = 1;
    	if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){//dla orjentacji poziomej
    		/*ImageView image = (ImageView)findViewById(R.id.imageView1);
    		image.setImageResource(R.drawable.krowa);
    		TextView text = (TextView)findViewById(R.id.textView6);
    		text.setText(R.string.krowa_opis);*/
    		Intent intent = new Intent(this, Description.class);
        	TextView text = (TextView)findViewById(R.id.textView1);
        	intent.putExtra("name",text.getText());
        	intent.putExtra("zwierze_id", 1);//dajemy id bo inaczej por�wnuj�c ze stringiem przy zmianie j�zyka sie zwali(por�wnuj�c z nazw�)
        	//intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        	startActivity(intent);
    	}
    	else{
    		Intent intent = new Intent(this, Description.class);
        	TextView text = (TextView)findViewById(R.id.textView1);
        	intent.putExtra("name",text.getText());
        	intent.putExtra("zwierze_id", 1);//dajemy id bo inaczej por�wnuj�c ze stringiem przy zmianie j�zyka sie zwali(por�wnuj�c z nazw�)
        	startActivity(intent);
    	}
    	
    }
    
    public void textView2(View w){
    	//ID = 2;
    	/*if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){//dla orjentacji poziomej
    		ImageView image = (ImageView)findViewById(R.id.imageView1);
    		image.setImageResource(R.drawable.kot);
    		TextView text = (TextView)findViewById(R.id.textView6);
    		text.setText(R.string.kot_opis);
    	}
    	else{*/
    		Intent intent = new Intent(this, Description.class);
        	TextView text = (TextView)findViewById(R.id.textView2);
        	intent.putExtra("name",text.getText());
        	intent.putExtra("zwierze_id", 2);
        	startActivity(intent);
    	//}
    	
    }
    
    public void textView3(View w){
    	/*ID = 3;
    	if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){//dla orjentacji poziomej
    		ImageView image = (ImageView)findViewById(R.id.imageView1);
    		image.setImageResource(R.drawable.lis);
    		TextView text = (TextView)findViewById(R.id.textView6);
    		text.setText(R.string.lis_opis);
    	}
    	else{*/
    		Intent intent = new Intent(this, Description.class);
        	TextView text = (TextView)findViewById(R.id.textView3);
        	intent.putExtra("name",text.getText());
        	intent.putExtra("zwierze_id", 3);
        	startActivity(intent);
    	//}
    	
    }
    
    public void textView4(View w){
    	/*ID = 4;
    	if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){//dla orjentacji poziomej
    		ImageView image = (ImageView)findViewById(R.id.imageView1);
    		image.setImageResource(R.drawable.swinia);
    		TextView text = (TextView)findViewById(R.id.textView6);
    		text.setText(R.string.swinia_opis);
    	}
    	else{*/
    		Intent intent = new Intent(this, Description.class);
        	TextView text = (TextView)findViewById(R.id.textView4);
        	intent.putExtra("name",text.getText());
        	intent.putExtra("zwierze_id", 4);
        	startActivity(intent);
    	//}
    	
    }
    
    public void textView5(View w){
    	/*ID = 5;
    	if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){//dla orjentacji poziomej
    		ImageView image = (ImageView)findViewById(R.id.imageView1);
    		image.setImageResource(R.drawable.kura);
    		TextView text = (TextView)findViewById(R.id.textView6);
    		text.setText(R.string.kura_opis);
    	}
    	else{*/
    		Intent intent = new Intent(this, Description.class);
        	TextView text = (TextView)findViewById(R.id.textView5);
        	intent.putExtra("name",text.getText());
        	intent.putExtra("zwierze_id", 5);
        	startActivity(intent);
    	//}
    	
    }
}
