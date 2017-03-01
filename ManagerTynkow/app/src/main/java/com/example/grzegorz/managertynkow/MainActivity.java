package com.example.grzegorz.managertynkow;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.grzegorz.Model.DaneZleceniaModel;

public class MainActivity extends AppCompatActivity {

    private ListView list;
    private static DbTools db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("String", "message");
        db = new DbTools(this);

        db.daneZleceniaModel.add(2, "jakas nazwa","16-03-1994", 2);
        String columns[] = {DaneZleceniaModel.nazwa_column, DaneZleceniaModel.data_rozpoczecia_column, DaneZleceniaModel.data_zakonczenia_column};
        showListaZlecen(columns);
        addListener();
//        db.addKlient("Grzegorz", "Krzeszowski", "692184800", "Krakow");
//        db.addPomieszczenie(1, "qqq");
//        db.addRodzajSciany("eee");
//        db.addSciana(1,1,2);


    }

    private void showListaZlecen(String [] columns){
        Cursor cursor = db.daneZleceniaModel.getReadableDatabase().query("dane_zlecenia",columns, null, null, null, null, null );
        RowBean data[] = new RowBean[cursor.getCount()];
        int ite = 0;
        while (cursor.moveToNext()){
            data[ite] = new RowBean(cursor.getString(0), cursor.getString(1));
            ite++;
        }

        RowAdapter adapter = new RowAdapter(this, R.layout.row_element, data);
        list = (ListView)findViewById(R.id.listView);
        list.setAdapter(adapter);
    }

    private void addListener(){
        list.setClickable(true);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,int position, long id) {

                TextView t = (TextView) view.findViewById(R.id.data_rozpoczecia);
                Toast.makeText(getApplicationContext(), t.getText() + "", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void addNewZlecenie(View v){
        Intent intent = new Intent(this, addZlecenie.class);
        startActivity(intent);
//        Toast.makeText(this, "Add new zlecenie", Toast.LENGTH_LONG).show();
    }
}
