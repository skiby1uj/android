package com.example.grzegorz.ready4s2;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;

import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import android.Manifest;

import org.json.JSONArray;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;


public class MapsActivity extends Fragment{

    private GoogleMap googleMap;
    private MapView mapView;
    private View v;
    private point p[];
    private DbPlace dbPlace;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.activity_maps, container, false);

        dbPlace = new DbPlace(v.getContext());
        mapView = (MapView) v.findViewById(R.id.map);
        mapView.getMapAsync(new OnMapReadyCallback() {

            @Override
            public void onMapReady(GoogleMap g) {
                googleMap = g;
                googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                new WebServiceHandler().execute(getHttp());
                setLocation();
                googleMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                    @Override
                    public boolean onMarkerClick(Marker marker) {
                        Intent intent = new Intent(v.getContext(), Details.class);
                        intent.putExtra("id", marker.getTitle());
                        dbPlace.insert(getPointWithId(Integer.parseInt(marker.getTitle())));

                        startActivity(intent);
                        return true;
                    }
                });

            }
        });
        mapView.onCreate(savedInstanceState);
        mapView.onResume();
        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return v;
    }

    private point getPointWithId(int id){
        int i = 0;
        while(p[i].id != id){
            i++;
        }
        return p[i];
    }

    private void setLocation() {
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ActivityCompat.checkSelfPermission(v.getContext(),
                    Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                googleMap.setMyLocationEnabled(true);
            }
        } else {
            googleMap.setMyLocationEnabled(true);
        }
    }

    private Location getLocation(){//do dopracowania zeby byla najlepsza a nie pierwsza mozliwa
        LocationManager lm = (LocationManager)v.getContext().getSystemService(Context.LOCATION_SERVICE);
        List<String> providers = lm.getProviders(true);
        Location loc = null;
        for (String provider : providers){
            if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (ActivityCompat.checkSelfPermission(v.getContext(),
                        Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                    loc = lm.getLastKnownLocation(provider);
                }
            } else {
                loc = lm.getLastKnownLocation(provider);
            }
            if (loc != null){
                return loc;
            }
        }
        return null;
    }

    private String getHttp(){

        String http = "https://interview-ready4s.herokuapp.com/geo?";//lat=12.2&lng=12.2";
        Location loc = getLocation();

        if (loc != null ) {
            http = http + "lat=" + loc.getLatitude();
            http = http + "&lng=" + loc.getLongitude();
        }

        return http;
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    private class WebServiceHandler extends AsyncTask<String, Void, String> {

        private ProgressDialog dialog = new ProgressDialog(v.getContext());

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog.setMessage("Czekaj...");
            dialog.show();
        }

        @Override
        protected String doInBackground(String... urls) {
            try {
                URL url = new URL(urls[0]);
                URLConnection connection = url.openConnection();
                InputStream in = new BufferedInputStream(connection.getInputStream());

                return streamToString(in);
            } catch (Exception e) {
                Log.d(MainActivity.class.getSimpleName(), e.toString());
                return null;
            }

        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            dialog.dismiss();
            int arrlength = 0;
            try {
                JSONArray arrJson = new JSONArray(result);
                arrlength = arrJson.length();
                p = new point[arrlength];
                LatLngBounds.Builder builder = new LatLngBounds.Builder();
                for(int i = 0; i < arrlength; i++){
                    p[i] = new point(arrJson.getJSONObject(i));
                    LatLng ltln = new LatLng(p[i].latitude,p[i].longitude);
                    builder.include(ltln);
                    googleMap.addMarker(new MarkerOptions().position(ltln).title(p[i].id+""));
                }
                LatLngBounds bounds = builder.build();
                googleMap.animateCamera(CameraUpdateFactory.newLatLngBounds(bounds, 20));

            } catch (Exception e) {
                Log.d(MainActivity.class.getSimpleName(), e.toString());
            }
        }

        public String streamToString(InputStream is) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            StringBuilder stringBuilder = new StringBuilder();
            String line = null;
            try {
                while ((line = reader.readLine()) != null) {
                    stringBuilder.append(line + "\n");
                }
                reader.close();

            } catch (IOException e) {
                Log.d(MainActivity.class.getSimpleName(), e.toString());
            }
            return stringBuilder.toString();
        }
    }
}
