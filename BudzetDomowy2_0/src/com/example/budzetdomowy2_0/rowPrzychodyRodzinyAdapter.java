package com.example.budzetdomowy2_0;


import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class rowPrzychodyRodzinyAdapter extends ArrayAdapter<rowPrzychodyRodziny> {

	Context context;
    int layoutResourceId;  
    rowPrzychodyRodziny []data = null;
	
	public rowPrzychodyRodzinyAdapter(Context context, int layoutResourceId, rowPrzychodyRodziny[] data) {
		super(context, layoutResourceId, data);
		this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
	}
	
	public View getView(int position, View convertView, ViewGroup parent){
		View row = convertView;
    	rowPrzychodyRodzinyHolder holder = null;

    	if(row == null){
    		LayoutInflater inflater = ((Activity)context).getLayoutInflater();
    		row = inflater.inflate(layoutResourceId,parent, false);
    		holder = new rowPrzychodyRodzinyHolder();
    		holder.ID = (TextView)row.findViewById(R.id.ID);
    		holder.dane = (TextView)row.findViewById(R.id.Dane);
    		holder.zarobki = (TextView)row.findViewById(R.id.Zarobki);
    		row.setTag(holder);
    	}else{
    		holder = (rowPrzychodyRodzinyHolder)row.getTag();
    	}
    	rowPrzychodyRodziny object = data[position];
    	holder.ID.setText(position+"");
    	holder.dane.setText(object.dane);
    	holder.zarobki.setText(object.zarobki);
    	return row;
    	
	}
	
	static class rowPrzychodyRodzinyHolder{
		TextView ID;
		TextView dane;
		TextView zarobki;
	}

}
