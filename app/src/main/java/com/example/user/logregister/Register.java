package com.example.user.logregister;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Register extends AppCompatActivity implements View.OnClickListener{
    EditText vNom,vPrénom,vEmail,vTéléphone,vUsername,vPassword;
    Button Senregistrer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        vNom = (EditText) findViewById(R.id.idNom);
        vPrénom = (EditText) findViewById(R.id.idPrénom);
        vEmail = (EditText) findViewById(R.id.idEmail);
        vTéléphone = (EditText) findViewById(R.id.idTel);
        vUsername = (EditText) findViewById(R.id.idUsername);
        vPassword = (EditText) findViewById(R.id.idPassword);
        Senregistrer = (Button) findViewById(R.id.idSenregistrer);

        Senregistrer.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.idSenregistrer:


                break;
        }
    }
}
