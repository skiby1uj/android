package com.example.appinstalled;

import java.util.List;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.widget.Toast;

public class listut {
	
   public static List getInstalledApplication(Context c) {
       return c.getPackageManager().getInstalledApplications(PackageManager.GET_META_DATA);
   }

   public static boolean launchApp(Context c, PackageManager pm, String pkgName) {//uruchomienie apki po klikniêciu
       Intent intent = pm.getLaunchIntentForPackage(pkgName);
       if(intent != null) {
           try {
               c.startActivity(intent);
               return true;
           } catch(ActivityNotFoundException ex) {
        	   Toast toast = Toast.makeText(c, "Application Not Found", Toast.LENGTH_LONG);
               toast.show();
           }
       }
       return false;
   }
}
