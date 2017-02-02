package com.example.budzetdomowy2_0;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class WynikiFinansowe extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_wyniki_finansowe);
		
		Intent intent = getIntent();
		TextView text = (TextView)findViewById(R.id.textView1);
		text.setText("W historii jest " + intent.getIntExtra("iloscMiesiecy", 0) + " miesiecy");
		
		GraphView graphView = (GraphView)findViewById(R.id.graph);
		ZarzadcaBazyHistoria z1 = null;
		
		DataPoint []dataPoint = new DataPoint[12];
		DataPoint []dataPoint2 = new DataPoint[12];
		int max = 0;
		for(int i = 1; i <= 12; i++){
			z1 = new ZarzadcaBazyHistoria(this, i);
			dataPoint[i-1] = new DataPoint(i-1, z1.getZarobkiMiesiaca());
			dataPoint2[i-1] = new DataPoint(i-1, z1.getWydatkiMiesiaca());
			if(max < z1.getZarobkiMiesiaca())
				max = z1.getZarobkiMiesiaca();
			if(max < z1.getWydatkiMiesiaca())
				max = z1.getWydatkiMiesiaca();
		}
		
		LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(dataPoint);
		graphView.addSeries(series);
		
		LineGraphSeries<DataPoint> series2 = new LineGraphSeries<DataPoint>(dataPoint2 );
		graphView.getSecondScale().addSeries(series2);
		graphView.getSecondScale().setMinY(0);
		graphView.getSecondScale().setMaxY(max);
		//Toast.makeText(this, max+"", Toast.LENGTH_LONG).show();
		
		series2.setColor(Color.RED);
		graphView.getGridLabelRenderer().setVerticalLabelsSecondScaleColor(Color.RED);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.wyniki_finansowe, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void DalejButton(View w){
		EditText text = (EditText)findViewById(R.id.editText1);//nr miesiaca do ktorego idziemy
		Intent intent = new Intent(this, HistoriaMiesiaca.class);
		intent.putExtra("miesiac", Integer.parseInt(text.getText()+""));
		Intent intent2 = getIntent();
		intent.putExtra("iloscMiesiecy", intent2.getIntExtra("iloscMiesiecy", 0));
		intent.putExtra("rok", intent2.getIntExtra("rok", 1));
		startActivity(intent);
	}
}
