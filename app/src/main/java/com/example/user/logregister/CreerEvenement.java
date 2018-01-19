package com.example.user.logregister;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

public class CreerEvenement extends AppCompatActivity implements View.OnClickListener{
    Button submitBtn;
    EditText nameEven, ville, activite, lieu, nbrMax;
    DatePicker date;
    TimePicker time;
    double lat;
    double lng;
    DataBaseHelper helper = new DataBaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creer_evenement);
        submitBtn = (Button) findViewById(R.id.idSubmitCréation);
        submitBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String username = getIntent().getStringExtra("USERNAME");
        switch (view.getId()){
            case R.id.idSubmitCréation :
                submitBtn = (Button) findViewById(R.id.idSubmitCréation);
                nameEven = (EditText) findViewById(R.id.idNomEvenement);
                ville = (EditText) findViewById(R.id.IdNomVille);
                activite = (EditText) findViewById(R.id.idActivite);
                lieu = (EditText) findViewById(R.id.idLieu);
                nbrMax = (EditText) findViewById(R.id.idNbrMaxParticipants);
                date = (DatePicker) findViewById(R.id.idDate);
                time = (TimePicker) findViewById(R.id.idTime);
            helper.saveEvenement(nameEven,ville,activite,lieu,nbrMax,date,time,username);
                Intent intent = new Intent(this,ListEvenement.class);
                intent.putExtra("USERNAME", username);
                startActivity(intent);
                break;
            case R.id.idTrouverLieu :
                intent = new Intent(this,MapsLocation.class);
                startActivityForResult(intent,1);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1) {
            if(resultCode == Activity.RESULT_OK){
                lat=data.getDoubleExtra("lat",0);
                lng = data.getDoubleExtra("long",0);
                lieu = (EditText) findViewById(R.id.idLieu);
                lieu.setText(String.valueOf(lat).concat(",").concat(String.valueOf(lng)));
                lieu.setEnabled(false);
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                //Write your code if there's no result
            }
        }
    }
}
