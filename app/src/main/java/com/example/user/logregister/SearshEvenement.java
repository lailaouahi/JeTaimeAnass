package com.example.user.logregister;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;

public class SearshEvenement extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searsh_evenement);
    }
    @Override
    public void onClick(View v){
        String username = getIntent().getStringExtra("USERNAME");
        DatePicker dateAdehrer = (DatePicker) findViewById(R.id.dateAdherer);
        String date = String.valueOf(dateAdehrer.getDayOfMonth())+"/"+String.valueOf(dateAdehrer.getMonth())+"/"+String.valueOf(dateAdehrer.getYear());
        switch (v.getId()) {
            case R.id.btnSuivant :
                Intent intent = new Intent(this,AdhererActivity.class);
                intent.putExtra("DATEAD", date);
                intent.putExtra("user", username);
                startActivity(intent);
                break;
        }
    }
}
