package com.example.encyklopedia;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.media.Image;
import android.os.Bundle;
import android.text.NoCopySpan.Concrete;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Description extends Activity {
	static int ID = 0;	
	
	public void onBackPressed() {//klawisz back systemowy
	    ID = 0;
	    super.onBackPressed();
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_description);
		
		Intent intent = getIntent();
		ImageView image = (ImageView)findViewById(R.id.imageView1);
		
		if(ID != 0){//cos sie zmienilo wiec trzeba zmienic obrazki
			if(ID == 1){
				if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){//poziomy
					TextView text = (TextView)findViewById(R.id.textView6);
					text.setText(R.string.krowa_opis);
					image.setImageResource(R.drawable.krowa);
				}
				else{
					TextView text = (TextView)findViewById(R.id.textView1);
					text.setText(R.string.krowa);
					image.setImageResource(R.drawable.krowa);
					text = (TextView)findViewById(R.id.textView2);
					text.setText(R.string.krowa_opis);
				}
			}
			else if(ID == 2){
				if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
					TextView text = (TextView)findViewById(R.id.textView6);
					text.setText(R.string.kot_opis);
					image.setImageResource(R.drawable.kot);
				}
				else{
					TextView text = (TextView)findViewById(R.id.textView1);
					text.setText(R.string.kot);
					image.setImageResource(R.drawable.kot);
					text = (TextView)findViewById(R.id.textView2);
					text.setText(R.string.kot_opis);
				}
			}
			else if(ID == 3){
				if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
					TextView text = (TextView)findViewById(R.id.textView6);
					text.setText(R.string.lis_opis);
					image.setImageResource(R.drawable.lis);
				}
				else{
					TextView text = (TextView)findViewById(R.id.textView1);
					text.setText(R.string.lis);
					image.setImageResource(R.drawable.lis);
					text = (TextView)findViewById(R.id.textView2);
					text.setText(R.string.lis_opis);
				}
			}
			else if(ID == 4){
				if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
					TextView text = (TextView)findViewById(R.id.textView6);
					text.setText(R.string.swinia_opis);
					image.setImageResource(R.drawable.swinia);
				}
				else{
					TextView text = (TextView)findViewById(R.id.textView1);
					text.setText(R.string.swinia);
					image.setImageResource(R.drawable.swinia);
					text = (TextView)findViewById(R.id.textView2);
					text.setText(R.string.swinia_opis);
				}
			}
			else if(ID == 5){
				if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
					TextView text = (TextView)findViewById(R.id.textView6);
					text.setText(R.string.kura_opis);
					image.setImageResource(R.drawable.kura);
				}
				else{
					TextView text = (TextView)findViewById(R.id.textView1);
					text.setText(R.string.kura);
					image.setImageResource(R.drawable.kura);
					text = (TextView)findViewById(R.id.textView2);
					text.setText(R.string.kura_opis);
				}
			}
		}
		else if(intent.getIntExtra("zwierze_id", 0) == 1){
			if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
				TextView text = (TextView)findViewById(R.id.textView6);
				text.setText(R.string.krowa_opis);
				image.setImageResource(R.drawable.krowa);
			}
			else{
				TextView text = (TextView)findViewById(R.id.textView1);
				text.setText(intent.getStringExtra("name"));
				image.setImageResource(R.drawable.krowa);
				text = (TextView)findViewById(R.id.textView2);
				text.setText(R.string.krowa_opis);
			}
		}
		else if(intent.getIntExtra("zwierze_id", 0) == 2){
			if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
				TextView text = (TextView)findViewById(R.id.textView6);
				text.setText(R.string.kot_opis);
				image.setImageResource(R.drawable.kot);
			}
			else{
				TextView text = (TextView)findViewById(R.id.textView1);
				text.setText(intent.getStringExtra("name"));
				image.setImageResource(R.drawable.kot);
				text = (TextView)findViewById(R.id.textView2);
				text.setText(R.string.kot_opis);
			}
		}
		else if(intent.getIntExtra("zwierze_id", 0) == 3){
			if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
				TextView text = (TextView)findViewById(R.id.textView6);
				text.setText(R.string.lis_opis);
				image.setImageResource(R.drawable.lis);
			}
			else{
				TextView text = (TextView)findViewById(R.id.textView1);
				text.setText(intent.getStringExtra("name"));
				image.setImageResource(R.drawable.lis);
				text = (TextView)findViewById(R.id.textView2);
				text.setText(R.string.lis_opis);
			}
		}
		else if(intent.getIntExtra("zwierze_id", 0) == 4){
			if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
				TextView text = (TextView)findViewById(R.id.textView6);
				text.setText(R.string.swinia_opis);
				image.setImageResource(R.drawable.swinia);
			}
			else{
				TextView text = (TextView)findViewById(R.id.textView1);
				text.setText(intent.getStringExtra("name"));
				image.setImageResource(R.drawable.swinia);
				text = (TextView)findViewById(R.id.textView2);
				text.setText(R.string.swinia_opis);
			}
		}
		else if(intent.getIntExtra("zwierze_id", 0) == 5){
			if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
				TextView text = (TextView)findViewById(R.id.textView6);
				text.setText(R.string.kura_opis);
				image.setImageResource(R.drawable.kura);
			}
			else{
				TextView text = (TextView)findViewById(R.id.textView1);
				text.setText(intent.getStringExtra("name"));
				image.setImageResource(R.drawable.kura);
				text = (TextView)findViewById(R.id.textView2);
				text.setText(R.string.kura_opis);
			}
		}		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.description, menu);
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
		ID = 1;
    	if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){//dla orjentacji poziomej
    		ImageView image = (ImageView)findViewById(R.id.imageView1);
    		image.setImageResource(R.drawable.krowa);
    		TextView text = (TextView)findViewById(R.id.textView6);
    		text.setText(R.string.krowa_opis);
    	}
    	else{
    		Intent intent = new Intent(this, Description.class);
        	TextView text = (TextView)findViewById(R.id.textView1);
        	intent.putExtra("name",text.getText());
        	intent.putExtra("zwierze_id", 1);//dajemy id bo inaczej porównuj¹c ze stringiem przy zmianie jêzyka sie zwali(porównuj¹c z nazw¹)
        	startActivity(intent);
    	}
    	
    }
    
    public void textView2(View w){
    	ID = 2;
    	if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){//dla orjentacji poziomej
    		ImageView image = (ImageView)findViewById(R.id.imageView1);
    		image.setImageResource(R.drawable.kot);
    		TextView text = (TextView)findViewById(R.id.textView6);
    		text.setText(R.string.kot_opis);
    	}
    	else{
    		Intent intent = new Intent(this, Description.class);
        	TextView text = (TextView)findViewById(R.id.textView2);
        	intent.putExtra("name",text.getText());
        	intent.putExtra("zwierze_id", 2);
        	startActivity(intent);
    	}
    	
    }
    
    public void textView3(View w){
    	ID = 3;
    	if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){//dla orjentacji poziomej
    		ImageView image = (ImageView)findViewById(R.id.imageView1);
    		image.setImageResource(R.drawable.lis);
    		TextView text = (TextView)findViewById(R.id.textView6);
    		text.setText(R.string.lis_opis);
    	}
    	else{
    		Intent intent = new Intent(this, Description.class);
        	TextView text = (TextView)findViewById(R.id.textView3);
        	intent.putExtra("name",text.getText());
        	intent.putExtra("zwierze_id", 3);
        	startActivity(intent);
    	}
    	
    }
    
    public void textView4(View w){
    	ID = 4;
    	if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){//dla orjentacji poziomej
    		ImageView image = (ImageView)findViewById(R.id.imageView1);
    		image.setImageResource(R.drawable.swinia);
    		TextView text = (TextView)findViewById(R.id.textView6);
    		text.setText(R.string.swinia_opis);
    	}
    	else{
    		Intent intent = new Intent(this, Description.class);
        	TextView text = (TextView)findViewById(R.id.textView4);
        	intent.putExtra("name",text.getText());
        	intent.putExtra("zwierze_id", 4);
        	startActivity(intent);
    	}
    	
    }
    
    public void textView5(View w){
    	ID = 5;
    	if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){//dla orjentacji poziomej
    		ImageView image = (ImageView)findViewById(R.id.imageView1);
    		image.setImageResource(R.drawable.kura);
    		TextView text = (TextView)findViewById(R.id.textView6);
    		text.setText(R.string.kura_opis);
    	}
    	else{
    		Intent intent = new Intent(this, Description.class);
        	TextView text = (TextView)findViewById(R.id.textView5);
        	intent.putExtra("name",text.getText());
        	intent.putExtra("zwierze_id", 5);
        	startActivity(intent);
    	}
    	
    }
}
