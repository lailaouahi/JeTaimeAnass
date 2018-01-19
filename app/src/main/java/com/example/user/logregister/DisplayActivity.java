package com.example.user.logregister;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class DisplayActivity extends AppCompatActivity implements View.OnClickListener {

    DataBaseHelper helper = new DataBaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        String username = getIntent().getStringExtra("username");
        String date = getIntent().getStringExtra("DateEvenement");
        String name = getIntent().getStringExtra("NameEvenement");
        String id = getIntent().getStringExtra("idEvenement");
        TextView txname = (TextView) findViewById(R.id.nameEvnTxt);
        TextView txdate = (TextView) findViewById(R.id.dateEvTxt);
        txname.setText(name);
        txdate.setText(date);
    }

    @Override
    public void onClick(View v) {
        String username = getIntent().getStringExtra("username");
        String date = getIntent().getStringExtra("DateEvenement");
        String name = getIntent().getStringExtra("NameEvenement");
        String id = getIntent().getStringExtra("idEvenement");
        String lieu = getIntent().getStringExtra("lieuEv");
        switch (v.getId()) {
            case (R.id.btnViewMap):
                Intent intent = new Intent(this,DisplayLocationActivity.class);
                intent.putExtra("lieuuu",lieu);
                startActivity(intent);
                break;
            case (R.id.btnAdhererSubmit):
                helper.saveAdhesion(username,id);
                Toast pass = Toast.makeText(DisplayActivity.this,"Vous avez adhèrer l'activiter avec success",Toast.LENGTH_SHORT);
                pass.show();
                break;
        }
    }
}
