package com.example.user.logregister;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class DisplayLocationActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_location);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        String lieu = getIntent().getStringExtra("lieuuu");
        String latString = lieu.substring(0,lieu.indexOf(","));
        String lngStrinf = lieu.substring(lieu.indexOf(",")+1);
        Double lat = Double.parseDouble(latString);
        Double lng = Double.parseDouble(lngStrinf);
        LatLng activite = new LatLng(lat, lng);
        mMap.addMarker(new MarkerOptions().position(activite).title("Votre activité"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(activite));
    }
}
