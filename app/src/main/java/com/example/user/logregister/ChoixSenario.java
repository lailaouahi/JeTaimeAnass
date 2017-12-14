package com.example.user.logregister;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChoixSenario extends AppCompatActivity implements View.OnClickListener {
    Button btnChoixCreate, btnChoixAdherer, btnChoixLieu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choix_senario);
    }
    @Override
    public void onClick(View v){
        switch (v.getId()) {
            case R.id.idCréerEvènement :
                startActivity(new Intent(this,CreerEvenement.class));
        }
    }
}
