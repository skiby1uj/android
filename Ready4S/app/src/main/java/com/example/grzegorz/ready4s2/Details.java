package com.example.grzegorz.ready4s2;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Details extends AppCompatActivity {

    private Context context;
    private DbPlace dbPlace;
    private TextView nazwa_miejsca;
    private TextView dl_geograficzna;
    private TextView szer_geograficzna;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        context = this;
        ImageView avatar = (ImageView)findViewById(R.id.ImageAvatarId);
        nazwa_miejsca = (TextView)findViewById(R.id.nazwa_miejsca);
        dl_geograficzna = (TextView)findViewById(R.id.dl_geograficzna);
        szer_geograficzna = (TextView)findViewById(R.id.szer_geograficzna);
        dbPlace = new DbPlace(context);
        Bundle extras = getIntent().getExtras();
        point p = dbPlace.selectAllwithId(Integer.parseInt(extras.getString("id")));
        new ImageLoadTask(p.avatar, avatar).execute();
        nazwa_miejsca.setText(nazwa_miejsca.getText() + p.name);
        dl_geograficzna.setText(dl_geograficzna.getText().toString() + p.longitude);
        szer_geograficzna.setText(szer_geograficzna.getText().toString() + p.latitude);



    }



    private class ImageLoadTask extends AsyncTask<Void, Void, Bitmap> {

        private String url;
        private ImageView imageView;

        public ImageLoadTask(String url, ImageView imageView) {
            this.url = url;
            this.imageView = imageView;
        }

        private ProgressDialog dialog = new ProgressDialog(context);

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog.setMessage("Czekaj...");
            dialog.show();
        }

        @Override
        protected Bitmap doInBackground(Void... voids) {
            try {
                URL urlConnection = new URL(url);
                HttpURLConnection connection = (HttpURLConnection) urlConnection
                        .openConnection();
                connection.setDoInput(true);
                connection.connect();
                InputStream input = connection.getInputStream();
                Bitmap myBitmap = BitmapFactory.decodeStream(input);
                return myBitmap;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
        @Override
        protected void onPostExecute(Bitmap result) {
            super.onPostExecute(result);
            dialog.dismiss();
            imageView.setImageBitmap(result);
        }
    }
}
