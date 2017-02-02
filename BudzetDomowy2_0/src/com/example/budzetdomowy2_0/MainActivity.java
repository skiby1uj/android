package com.example.budzetdomowy2_0;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {
	
	public static int miesiac = 0;
	//public static int rok = 1;
	public Context tmp = this;
    
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        String inFileName = "/data/data/com.budzetdomowy2_0/databases/BACKUP";
        //Toast.makeText(tmp, inFileName,Toast.LENGTH_LONG).show();
    }
    
    protected void onResume(){
    	super.onResume();
    	
    	Button button = (Button)findViewById(R.id.PrzychodyRodzinyButton);
        button.setText("Przychody rodziny\nsuma: " + getZarobkiRoszny() + " zl");
        button = (Button)findViewById(R.id.WydatkiButton);
        button.setText("Wydatki\nsuma: " + 
        				(getSumaWydatkiCykliczne() + 
        				getSumaWydatkiNiePlanowane() + 
        				getSumaWydatkiPlanowane()) + " zl");
    	
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
    
    public void WydatkiButton(View w){
    	Intent intent = new Intent(this, Wydatki.class);
    	startActivity(intent);
    }
    
    public void PrzychodyRodzinyButton(View w){
    	Intent intent = new Intent(this, PrzychodyRodziny.class);
    	startActivity(intent);
    }
    
    public void WynikiFinansoweButton(View w){
    	Intent intent = new Intent(this, WynikiFinansowe.class);
    	intent.putExtra("iloscMiesiecy", miesiac);
    	//intent.putExtra("rok", rok);
    	startActivity(intent);
    }
    
    public int getZarobkiRoszny(){
    	ZarzadcaBazyPrzychodyRodziny zarzadca = new ZarzadcaBazyPrzychodyRodziny(this);
		Cursor cursor = zarzadca.DajWszystkie();
		int i = 0;
		int suma = 0;
		while(cursor.moveToNext()){
			suma += cursor.getInt(2);
			i++;
		}
		return suma;
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
	
	public void RozliczMiesiacButton(View w){
		final Dialog dialog = new Dialog(this);
		dialog.setContentView(R.layout.rozliczenie_miesiaca);
		Button tak = (Button)dialog.findViewById(R.id.button1);
		Button nie = (Button)dialog.findViewById(R.id.button2);
		final Context tmp = this;
		
		
		tak.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				miesiac++;
				/*if(miesiac > 12){
					miesiac = 1;
					rok++;
					//ZarzadcaBazyHistoria zarzadca = new ZarzadcaBazyHistoria(tmp, );
					//zarzadca.UsunWszystkie();
				}*/
				ZarzadcaBazyHistoria zarzadca = new ZarzadcaBazyHistoria(tmp, miesiac/*, rok*/);
				zarzadca.RozliczMiesiac();
				Toast.makeText(tmp, "Rozliczono miesi¹c! " + miesiac, Toast.LENGTH_LONG).show();
				Button button = (Button)findViewById(R.id.WydatkiButton);
			        button.setText("Wydatki\nsuma: " + 
			        				(getSumaWydatkiCykliczne() + 
			        				getSumaWydatkiNiePlanowane() + 
			        				getSumaWydatkiPlanowane()) + " zl");
				dialog.dismiss();
				
				
			}
		});
		
		nie.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				dialog.dismiss();
			}
		});
		dialog.show();
		
	}
	
	public static void restoreDatabase() throws IOException {
        String inFileName = Environment.getExternalStorageDirectory()+"/BACKUP";
        File dbFile = new File(inFileName);
        FileInputStream fis = new FileInputStream(dbFile);
        String outFileName = "/data/data/com.budzetdomowy2_0/databases/BACKUP";
        OutputStream output = new FileOutputStream(outFileName);
        byte[] buffer = new byte[1024];
        int length;
        while ((length = fis.read(buffer))>0){
            output.write(buffer, 0, length);
        }
        output.flush();
        output.close();
        fis.close();
    }
    
    
    public static void backupDatabase() throws IOException {
        String inFileName = "/data/com.budzetdomowy2_0/databases/BACKUP";
        File dbFile = new File(inFileName);
        FileInputStream fis = new FileInputStream(dbFile);
        

        String outFileName =Environment.getExternalStorageDirectory()+"/BACKUP";
        OutputStream output = new FileOutputStream(outFileName);
        byte[] buffer = new byte[1024];
        int length;
        while ((length = fis.read(buffer))>0){
            output.write(buffer, 0, length);
        }
        output.flush();
        output.close();
        fis.close();
    }
    
    public void ImportButton(View w){
    	try {
      		 restoreDatabase();
      		 Toast.makeText(getApplicationContext(), "Succesfully imported database!", Toast.LENGTH_LONG).show();
           } catch (IOException e1) {
     		 Toast.makeText(getApplicationContext(), "Error! No file to import", Toast.LENGTH_LONG).show();   
          	 e1.printStackTrace();
           }
    }
    
    public void ExportButton(View w){
    	try {
    		 backupDatabase();
      		 Toast.makeText(getApplicationContext(), "Succesfully exported database!", Toast.LENGTH_LONG).show();
   		 
        } catch (IOException e1) {   
       	 e1.printStackTrace();
        }
    }
}
