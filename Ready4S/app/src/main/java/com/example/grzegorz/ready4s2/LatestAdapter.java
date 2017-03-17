package com.example.grzegorz.ready4s2;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by grzegorz on 04.03.17.
 */

public class LatestAdapter extends RecyclerView.Adapter {

    private ArrayList<LatestRow> latestRows = new ArrayList<>();
    private RecyclerView recyclerView;

    private class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public TextView localization;
        public TextView id;

        public MyViewHolder(View itemView) {
            super(itemView);
            name = (TextView)itemView.findViewById(R.id.name);
            localization = (TextView)itemView.findViewById(R.id.localization);
            id = (TextView)itemView.findViewById(R.id.id);
        }
    }

    public LatestAdapter(ArrayList<LatestRow> latestRows, RecyclerView recyclerView) {
        this.latestRows = latestRows;
        this.recyclerView = recyclerView;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        final View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_latest_row, viewGroup, false);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textViewId = (TextView)v.findViewById(R.id.id);

                Intent intent = new Intent(v.getContext(), Details.class);
                intent.putExtra("id", textViewId.getText());
                v.getContext().startActivity(intent);
            }
        });
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        LatestRow latestRow = this.latestRows.get(position);
        ((MyViewHolder) holder).name.setText(latestRow.getName());
        ((MyViewHolder) holder).localization.setText(latestRow.getLocalization());
        ((MyViewHolder) holder).id.setText(latestRow.getId()+"");
    }

    @Override
    public int getItemCount() {
        return this.latestRows.size();
    }
}
