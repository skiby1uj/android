package com.example.grzegorz.managertynkow;


import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;


/**
 * Created by grzegorz on 24.02.17.
 */

public class RowAdapter extends ArrayAdapter<RowBean> {

    Context context = null;
    int layoutResourceId;
    RowBean data[] = null;

    public RowAdapter(Context context, int layoutResourceId, RowBean[] data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View row = convertView;
        RowBeanHolder holder = null;
        if(row == null){
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new RowBeanHolder();
            holder.data_rozpoczecia = (TextView)row.findViewById(R.id.data_rozpoczecia);
            holder.name = (TextView)row.findViewById(R.id.name);
            holder.delete = (CheckBox)row.findViewById(R.id.checkBoxDelete);

            row.setTag(holder);
        }
        else {
            holder = (RowBeanHolder)row.getTag();
        }

        RowBean object = data[position];

        holder.data_rozpoczecia.setText(object.data_rozpoczecia);
        holder.name.setText(object.name);
        holder.delete.setChecked(object.checked);

        return row;
    }

    static class RowBeanHolder{
        TextView data_rozpoczecia;
        TextView name;
        CheckBox delete;
    }
}
