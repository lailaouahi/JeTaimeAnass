package com.example.user.logregister;

import android.content.Intent;
import android.graphics.Region;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends AppCompatActivity implements View.OnClickListener {
    Button blogin;
    EditText Usernamee,Passwordd;
    TextView LienCréationCpmte;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Usernamee = (EditText) findViewById(R.id.idUsername);
        Passwordd = (EditText) findViewById(R.id.idPassword);
        blogin = (Button) findViewById(R.id.idLogin);
        LienCréationCpmte = (TextView) findViewById(R.id.idCréerCompte);

        blogin.setOnClickListener(this);
        LienCréationCpmte.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.idLogin:


                break;
            case R.id.idCréerCompte:
                startActivity(new Intent(this,Register.class));


                break;
        }
    }
}
