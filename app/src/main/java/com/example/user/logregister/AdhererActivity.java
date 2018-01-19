package com.example.user.logregister;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class AdhererActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adherer);
        String[] arraySpinner = new String[] {
                "Football", "Basketball", "Cardio", "Yoga", "Autre"
        };
        Spinner s = (Spinner) findViewById(R.id.activitespin);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinner);
        adapter.setDropDownViewResource(R.layout.evn);
        s.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        String date = getIntent().getStringExtra("DATEAD");
        String username = getIntent().getStringExtra("user");
        Spinner s = (Spinner) findViewById(R.id.activitespin);
        EditText ville = (EditText) findViewById(R.id.villetxt);
        String activite  = s.getSelectedItem().toString();
        String villeActivite = ville.getText().toString();
        switch (v.getId()){
            case R.id.btnfindactivite:
                Intent intent = new Intent(this,ListEvenement.class);
                intent.putExtra("DATEAD", date);
                intent.putExtra("VILLE", villeActivite);
                intent.putExtra("ACTIVITE", activite);
                intent.putExtra("user", username);
                startActivity(intent);
                break;
        }
    }
}
