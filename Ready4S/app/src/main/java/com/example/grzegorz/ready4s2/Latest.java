package com.example.grzegorz.ready4s2;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class Latest extends Fragment {

    private View view;
    private Context context;
    private static ArrayList<LatestRow> latestRows;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.view = inflater.inflate(R.layout.activity_latest, container, false);
        this.context = view.getContext();

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerViewId);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this.context));

        recyclerView.setItemAnimator(new DefaultItemAnimator());

        latestRows = new DbPlace(context).selectAllRowTOLatestList();

        recyclerView.setAdapter(new LatestAdapter(latestRows, recyclerView));
        return view;
    }

    public static void addToLatestList(int id, String name, double latitude, double longitude){
        latestRows.add(new LatestRow(id, name, latitude, longitude));
    }

}