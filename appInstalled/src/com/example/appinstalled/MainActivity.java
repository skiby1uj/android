package com.example.appinstalled;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
 
import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends Activity {

	private ListView appList;
	private SharedPreferences spreference;
	//private String nameSPreferences = "nameSP";
	PackageManager packageManager;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // spreference = getSharedPreferences(nameSPreferences, Activity.MODE_PRIVATE);
        Create(0);
    }
    
    
    public void Create(int sort/*, SharedPreferences spreference*/){// jakie sortowanie, mozna sprawdzic dokladnie w row.java
    	appList = (ListView)findViewById(R.id.listView);
        packageManager = getPackageManager();
        Context context = (Context) this;
        
        row adapter = new row(sort, context, listut.getInstalledApplication(this), getPackageManager()/*, spreference*/);

        appList.setAdapter(adapter);
        
        appList.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int pos, long id) {
                // get the list adapter
                row appInfoAdapter = (row)parent.getAdapter();
                // get selected item on the list
                ApplicationInfo appInfo = (ApplicationInfo)appInfoAdapter.getItem(pos);
                // launch the selected application
                listut.launchApp(parent.getContext(), getPackageManager(), appInfo.packageName);
                
                }
                
            
        });
    }
    
    public void SortNameRos(View w){
    	CheckBox box = (CheckBox)findViewById(R.id.checkBox1);
    	if(box.isChecked()){    		
    		Create(1);
    		box = (CheckBox)findViewById(R.id.checkBox2);
    		box.setChecked(false);
    		box = (CheckBox)findViewById(R.id.checkBox3);
    		box.setChecked(false);
    		box = (CheckBox)findViewById(R.id.checkBox4);
    		box.setChecked(false);
    	}
    	else
    		Create(0/*,spreference*/);
    }
    public void SortNameMal(View w){
    	CheckBox box = (CheckBox)findViewById(R.id.checkBox2);
    	if(box.isChecked()){    		
    		Create(2);
    		box = (CheckBox)findViewById(R.id.checkBox1);
    		box.setChecked(false);
    		box = (CheckBox)findViewById(R.id.checkBox3);
    		box.setChecked(false);
    		box = (CheckBox)findViewById(R.id.checkBox4);
    		box.setChecked(false);
    	}
    	else
    		Create(0);
    }
    
    public void SortStareRos(View w){
    	CheckBox box = (CheckBox)findViewById(R.id.checkBox3);
    	if(box.isChecked()){    		
    		Create(3);
    		box = (CheckBox)findViewById(R.id.checkBox2);
    		box.setChecked(false);
    		box = (CheckBox)findViewById(R.id.checkBox1);
    		box.setChecked(false);
    		box = (CheckBox)findViewById(R.id.checkBox4);
    		box.setChecked(false);
    	}
    	else
    		Create(0);
    }
    public void SortStareMal(View w){
    	CheckBox box = (CheckBox)findViewById(R.id.checkBox4);
    	if(box.isChecked()){    		
    		Create(4);
    		box = (CheckBox)findViewById(R.id.checkBox2);
    		box.setChecked(false);
    		box = (CheckBox)findViewById(R.id.checkBox3);
    		box.setChecked(false);
    		box = (CheckBox)findViewById(R.id.checkBox1);
    		box.setChecked(false);
    	}
    	else
    		Create(0);
    }
}
