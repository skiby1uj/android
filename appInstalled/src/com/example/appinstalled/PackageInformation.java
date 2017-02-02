package com.example.appinstalled;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;



import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.graphics.drawable.Drawable;
import android.preference.PreferenceManager;
import android.util.Log;

public class PackageInformation {
	private Context mContext;

	public  PackageInformation(Context context){
	    mContext=context;   
	}
	
	private class Shpreferences{
		 SharedPreferences sharedpreferences;
	 }

	class InfoObject{
		public String appname = "";
		//public String pname = "";
		//public String versionName = "";
		//public int versionCode = 0;
		public float ratingBarFloat;
		public Drawable icon;
		
		public String getName(){
			return appname;
		}
		
		public Drawable getImage(){
			return icon;
		}
		public float getratingBar(){
			return ratingBarFloat;
		}
	}
	
	public ArrayList<InfoObject> getInstalledApps(boolean getSysPackages) {
		ArrayList<InfoObject> res = new ArrayList<InfoObject>();        
		List<PackageInfo> packs = mContext.getPackageManager().getInstalledPackages(0);
		Shpreferences sharePre = new Shpreferences();
        sharePre.sharedpreferences = PreferenceManager.getDefaultSharedPreferences(mContext);//moje

		for(int i=0;i<packs.size();i++) {
		    PackageInfo p = packs.get(i);
		    if ((!getSysPackages) && (p.versionName == null)) {
		        continue ;
		    }
		    InfoObject newInfo = new InfoObject();
		    newInfo.appname = p.applicationInfo.loadLabel(mContext.getPackageManager()).toString();
		    //newInfo.pname = p.packageName;
		    //newInfo.versionName = p.versionName;
		    //newInfo.versionCode = p.versionCode;
		    newInfo.icon = p.applicationInfo.loadIcon(mContext.getPackageManager());
		    newInfo.ratingBarFloat =  sharePre.sharedpreferences.getFloat(newInfo.appname, 0.0f);
		    res.add(newInfo);
		}
		return res; 
	}
}
