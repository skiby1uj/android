package com.example.budzetdomowy2_0;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class rowWydatkiCykliczneAdapter extends ArrayAdapter<rowWydatkiCykliczne> {
	Context context;
    int layoutResourceId;  
    rowWydatkiCykliczne data[] = null;
	
	public rowWydatkiCykliczneAdapter(Context context, int layoutResourceId, rowWydatkiCykliczne[] data) {
		super(context, layoutResourceId, data);
		// TODO Auto-generated constructor stub
		this.context = context;
		this.layoutResourceId = layoutResourceId;
		this.data = data;
	}
	
	public View getView(int position, View convertView, ViewGroup parent){
		View row = convertView;
    	rowWydatkiCykliczneHolder holder = null;

    	if(row == null){
    		LayoutInflater inflater = ((Activity)context).getLayoutInflater();
    		row = inflater.inflate(layoutResourceId,parent, false);
    		holder = new rowWydatkiCykliczneHolder();
    		holder.ID = (TextView)row.findViewById(R.id.ID);
    		holder.opis = (TextView)row.findViewById(R.id.Dane);
    		//holder.dane = (TextView)row.findViewById(R.id.Dane);
    		holder.koszt = (TextView)row.findViewById(R.id.Koszt);
    		row.setTag(holder);
    	}else{
    		holder = (rowWydatkiCykliczneHolder)row.getTag();
    	}
    	rowWydatkiCykliczne object = data[position];
    	holder.ID.setText(position+"");
    	holder.opis.setText(object.opis);
    	//holder.dane.setText(object.dane);
    	holder.koszt.setText(object.koszt);
    	return row;
	}
	
	static class rowWydatkiCykliczneHolder{
		TextView ID;
		TextView opis;
		TextView koszt;
	}
	
}
