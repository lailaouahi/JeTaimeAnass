package com.example.user.logregister;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.Projection;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;

public class MapsLocation extends FragmentActivity implements OnMapReadyCallback {

    DataBaseHelper helper = new DataBaseHelper(this);
    private GoogleMap mMap;
    private Marker marker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_location);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setOnMapLongClickListener(new
           GoogleMap.OnMapLongClickListener() {
               @Override
               public void onMapLongClick (LatLng latLng){
                   Geocoder geocoder =
                           new Geocoder(MapsLocation.this);
                   List<Address> list;
                   try {
                       list = geocoder.getFromLocation(latLng.latitude,
                               latLng.longitude, 1);
                   } catch (IOException e) {
                       return;
                   }
                   Address address = list.get(0);
                   if (marker != null) {
                       marker.remove();
                   }

                   MarkerOptions options = new MarkerOptions()
                           .title(address.getLocality())
                           .position(new LatLng(latLng.latitude,
                                   latLng.longitude));

                   marker = mMap.addMarker(options);
               }
           });

//        clicableMarker();
        addLieu();
        if (getIntent().getBooleanExtra("ADDlocation",false))
        {
            Button button = (Button) findViewById(R.id.getLatLng);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {
                    Projection projection = mMap.getProjection();
                    LatLng markerLocation = marker.getPosition();
                    String lat = String.valueOf(markerLocation.latitude);
                    String lng = String.valueOf(markerLocation.longitude);
                    helper.insertLieu(lat.concat(",").concat(lng));
                    finish();
                }
            });
        }

    }

    private void addLieu() {
        Button button = (Button) findViewById(R.id.getLatLng);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Projection projection = mMap.getProjection();
                LatLng markerLocation = marker.getPosition();
                Intent returnIntent = new Intent();
                returnIntent.putExtra("long",markerLocation.longitude);
                returnIntent.putExtra("lat",markerLocation.latitude);
                setResult(Activity.RESULT_OK,returnIntent);
                finish();
            }
        });
    }

//    public void clicableMarker(){
//        Button button = (Button) findViewById(R.id.getLatLng);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v)
//            {
//                Projection projection = mMap.getProjection();
//                LatLng markerLocation = marker.getPosition();
//                Intent returnIntent = new Intent();
//                returnIntent.putExtra("long",markerLocation.longitude);
//                returnIntent.putExtra("lat",markerLocation.latitude);
//                setResult(Activity.RESULT_OK,returnIntent);
//                finish();
//            }
//        });
//    }

}
