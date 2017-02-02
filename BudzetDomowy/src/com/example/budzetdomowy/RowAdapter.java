package com.example.budzetdomowy;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class RowAdapter extends ArrayAdapter<rowDomownik> {
	Context context;
    int layoutResourceId;  
    rowDomownik data[] = null;
    
    public RowAdapter(Context context, int layoutResourceId, rowDomownik[] data){
    	 super(context, layoutResourceId, data);
         this.layoutResourceId = layoutResourceId;
         this.context = context;
         this.data = data;
    }
    
    public View getView(int position, View convertView, ViewGroup parent){
    	View row = convertView;
    	rowDomownikHolder holder = null;

    	if(row == null){
    		LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);
            holder = new rowDomownikHolder();
            holder.dane = (TextView)row.findViewById(R.id.textView1);
            //holder.wydatek = (TextView)row.findViewById(R.id.textView2);
            holder.cena = (TextView)row.findViewById(R.id.textView2);
            
            row.setTag(holder);
    	}
    	else{
    		holder = (rowDomownikHolder)row.getTag();
    	}
    	rowDomownik object = data[position];
        holder.dane.setText(object.dane);
        //holder.wydatek.setText(object.wydatek);
        holder.cena.setText(object.cena);
    	return row;
    }
    
    static class rowDomownikHolder{
    	TextView dane;
    	TextView wydatek;
    	TextView cena;
    }
}
