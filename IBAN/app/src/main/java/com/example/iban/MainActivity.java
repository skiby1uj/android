package com.example.iban;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends Activity {

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
    
    public void actionSend(View v){
    	EditText nr = (EditText)findViewById(R.id.iban);
    	String iban = nr.getText().toString();
    	Konto Iban = new Konto();
    	Iban.nr = iban;
    	System.out.println("To jest iban: " + Iban.nr);
    	//Toast.makeText(this, "IBAN = " + Iban.nr, Toast.LENGTH_LONG).show();
    	if(Iban.czyPoprawny() == true){
    		Toast.makeText(this, "IBAN POPRAWNY ", Toast.LENGTH_LONG).show();
    		//Toast.makeText(this, "IBAN POPRAWNY", Toast.LENGTH_LONG).show();
    	}
    	else{
    		Toast.makeText(this,  "IBAN BLEDNY", Toast.LENGTH_LONG).show();
    		nr.setError("BLAD");
    	}
    }
}
