package com.example.user.logregister;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChoixSenario extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choix_senario);
    }
    @Override
    public void onClick(View v){
        String username = getIntent().getStringExtra("USERNAME");
        switch (v.getId()) {
            case R.id.idCréerEvènement :
                Intent intent = new Intent(this,CreerEvenement.class);
                intent.putExtra("USERNAME", username);
                startActivity(intent);
                break;
            case R.id.idAdhérerEvènement:
                intent = new Intent(this, SearshEvenement.class);
                intent.putExtra("USERNAME", username);
                startActivity(intent);
                break;
            case R.id.idOffrirLieu :
                intent = new Intent(this, MapsLocation.class);
                intent.putExtra("ADDlocation", true);
                startActivity(intent);
                break;
        }
    }
}
