package com.example.user.logregister;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class Register extends AppCompatActivity implements View.OnClickListener{
    DataBaseHelper helper = new DataBaseHelper(this);
    EditText vNom,vPrénom,vEmail,vTéléphone,vUsername,vPassword;
    Button Senregistrer;
    RadioButton sexH,sexF,sexA;

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
        sexH = (RadioButton) findViewById(R.id.sexehomme);
        sexF = (RadioButton) findViewById(R.id.sexefemme);
        sexA = (RadioButton) findViewById(R.id.sexeautre);
        Senregistrer.setOnClickListener(this);
    }
    public int getSexe(){
        if(!sexH.getText().toString().equals(null))
            return 1;
        if(!sexF.getText().toString().equals(null))
            return 2;
        if(!sexA.getText().toString().equals(null))
            return 3;
        return 1;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.idSenregistrer:
                User u = new User();
                u.setNom(vNom.getText().toString());
                u.setPrenom(vPrénom.getText().toString());
                u.setUserName(vUsername.getText().toString());
                u.setPassword(vPassword.getText().toString());
                u.setTele(vTéléphone.getText().toString());
                u.setEmail(vEmail.getText().toString());
                u.setSexe(this.getSexe());
                helper.insertUser(u);
                Toast pass = Toast.makeText(Register.this,"Bienvenu",Toast.LENGTH_SHORT);
                pass.show();
                break;

        }
    }
}
