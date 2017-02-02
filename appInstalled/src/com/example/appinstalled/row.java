package com.example.appinstalled;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.example.appinstalled.PackageInformation.InfoObject;

import android.R.bool;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.Toast;

public class row extends BaseAdapter{
	 private Context mContext;
	 private List mListAppInfo;
	 private PackageManager mPackManager;
	 private int sort;
	 RatingBar ratingBar;
	 Boolean val = true;
	 float ans = (float) 0.0;
	// private SharedPreferences spreferences;
	 

	 public row(int s ,Context c, List list, PackageManager pm/*, SharedPreferences spreference*/) {
	        mContext = c;
	        mListAppInfo = list;
	        mPackManager = pm;
	        sort  = s;
	       // spreferences = spreference;
	 }
	 
	 @Override
	 public int getCount() {
	      return mListAppInfo.size();
	 }
	 
	 @Override
	 public Object getItem(int position) {
	      return mListAppInfo.get(position);
	 }
	 
	 @Override
	 public long getItemId(int position) {
	      return position;
	 }
		 
	 
	 public class Spreferences{
		 SharedPreferences sharedpreferences;
	 }
	 
	 private class ViewHolder {
		  TextView apkName;
		 }
	 
	 private void sortAZ(List<InfoObject> appsData){
		 Collections.sort(appsData, new Comparator<InfoObject>(){
	    	    public int compare(InfoObject arg,InfoObject arg2) {
	    	    	return arg.appname.compareTo(arg2.appname);
	    	    }
	    	});
	 }

	 private void sortZA(List<InfoObject> appsData){
		 Collections.sort(appsData, new Comparator<InfoObject>(){
	    	    public int compare(InfoObject arg,InfoObject arg2) {
	    	    	return arg2.appname.compareTo(arg.appname);
	    	    }
	    	});
	 }
	 
	 private void sortByRankDESC(List<InfoObject> appsData){
		 Collections.sort(appsData, new Comparator<InfoObject>(){
	    	    public int compare(InfoObject arg, InfoObject arg2) {
	    	    	if(arg.getratingBar() > arg2.getratingBar())
	    				return -1;
	    			else if(arg.getratingBar() < arg2.getratingBar())
	    				return 1;
	    			else
	    				return 0;
	    	    }
	    	});
	 }
	 
	 private void sortByRankASC(List<InfoObject> appsData){
		 Collections.sort(appsData, new Comparator<InfoObject>(){
	    	    public int compare(InfoObject arg, InfoObject arg2) {
	    	    	if(arg2.getratingBar() > arg.getratingBar())
	    				return -1;
	    			else if(arg2.getratingBar() < arg.getratingBar())
	    				return 1;
	    			else
	    				return 0;
	    	    }
	    	});
	 }
	 
	 
	 
	 @Override
	 public View getView(final int position, final View convertView, final ViewGroup parent) {//ta metoda jest wywolywana dla ka¿dego wiersza ListView
	      View v = convertView;

	      PackageInformation androidPackagesInfo=new PackageInformation(mContext);      
	      final List<InfoObject> appsData=androidPackagesInfo.getInstalledApps(true);
	     
	      if(sort == 1)
	    	  sortAZ(appsData);
	      else if(sort == 2)
	    	  sortZA(appsData);
	      else if(sort == 3)
	    	  sortByRankASC(appsData);
	       else if(sort == 4)
	    	   sortByRankDESC(appsData);
	      
	      if(v == null) {
	          LayoutInflater inflater = LayoutInflater.from(mContext);
	          v = inflater.inflate(R.layout.rowlayout, null);
	      }
	 
	      ImageView ivAppIcon = (ImageView)v.findViewById(R.id.imageView1);
	      TextView tvAppName = (TextView)v.findViewById(R.id.textView1);

	      tvAppName.setText(appsData.get(position).getName());
	      ivAppIcon.setImageDrawable(appsData.get(position).getImage());
	     
	      ratingBar = (RatingBar)v.findViewById(R.id.ratingBar1);  
	      

          Spreferences sharePre = new Spreferences();
          sharePre.sharedpreferences = PreferenceManager.getDefaultSharedPreferences(mContext);

          ans = sharePre.sharedpreferences.getFloat(appsData.get(position).getName().toString(), 0.0f);

	      ratingBar.setRating(ans);

	      ratingBar.setOnRatingBarChangeListener(new OnRatingBarChangeListener(){
	    	  
	    	  public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromTouch) {
	    		  if(fromTouch){//to doda³em jak nie zapisywa³o ale czemu to pomoglo nie wiem Kadela kaza³
	    		  ans = ratingBar.getRating();
	    		  Spreferences sharePre = new Spreferences();
	    		  sharePre.sharedpreferences = PreferenceManager.getDefaultSharedPreferences(mContext);
	    		
	    		  // SharedPreferences.Editor edit = spreferences.edit();
	    		  
	    		  SharedPreferences.Editor edit = sharePre.sharedpreferences.edit();
	              edit.putFloat(appsData.get(position).getName().toString(), ans);
	              edit.commit();
	              val = false;  
	  	    }
	  	    }
	      }); 
	      return v;
	  }
}
