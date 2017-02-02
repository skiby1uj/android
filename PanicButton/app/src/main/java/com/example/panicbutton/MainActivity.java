package com.example.panicbutton;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity{
	
	 private TextView latituteField;
	  private TextView longitudeField;
	  private LocationManager locationManager;
	  private String provider;
	  private Location loc;
	  private SharedPreferences sharedpreferences;
	  //private SmsManager smsManager = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //latituteField = (TextView)findViewById(R.id.textView2);
        //longitudeField = (TextView)findViewById(R.id.textView4);
        
        
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
    
    public void AlarmNumber(View w){
    	Intent intent = new Intent(this, AlarmNumber.class);
    	startActivity(intent);
    }
    
    public void ListSendSms(View w){
    	Intent intent = new Intent(this, ListSendSms.class);
    	startActivity(intent);
    }
    
    public void Alarm(View w){

    	sendSMS();
    	Call();
    }
    
    public void sendSMS(){
    	sharedpreferences = getSharedPreferences("ListContact", Activity.MODE_PRIVATE);
		String numbers[] = sharedpreferences.getString("numbers", "You didn't give numbers").toString().split(",");
		int howMany = numbers.length;
		
		locationManager = (LocationManager)getSystemService(LOCATION_SERVICE);
        Criteria criteria = new Criteria();
        provider = locationManager.getBestProvider(criteria, true);
        loc = locationManager.getLastKnownLocation(provider);
        boolean enabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        //Toast.makeText(this, numbers[0], Toast.LENGTH_LONG).show();
        if(enabled){
        	for(int i = 0; i < howMany; i++){
        		// Toast.makeText(this, numbers[i], Toast.LENGTH_LONG).show();
        		SmsManager smsManager = SmsManager.getDefault();
    	    	smsManager.sendTextMessage(numbers[i] ,null,"longitude: \n" + loc.getLongitude() + "\nlatitude: \n" + loc.getLatitude(),null,null);
        	}
        }
        else{
        	Toast.makeText(this, "Not location", Toast.LENGTH_LONG).show();
         }        
    }
    private void Call(){
    	sharedpreferences = getSharedPreferences("Alarm Number", Activity.MODE_PRIVATE);
        
        Intent phoneIntent = new Intent(Intent.ACTION_CALL);
       
        phoneIntent.setData(Uri.parse("tel:" + sharedpreferences.getString("number", "")));
        try{
        	startActivity(phoneIntent);
        }catch(android.content.ActivityNotFoundException ex){
        	Toast.makeText(MainActivity.this, 
        	         "Call faild, please try again later.", Toast.LENGTH_SHORT).show();
        }
    }
}
