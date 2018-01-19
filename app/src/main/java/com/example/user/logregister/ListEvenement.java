package com.example.user.logregister;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.List;

public class ListEvenement extends AppCompatActivity {
    DataBaseHelper helper = new DataBaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.evenement);
        DisplayEvenement();
    }


    private void DisplayEvenement() {
        final String username1 = getIntent().getStringExtra("USERNAME");
        final String username2 = getIntent().getStringExtra("user");
        String date = getIntent().getStringExtra("DATEAD");
        String activite = getIntent().getStringExtra("ACTIVITE");
        String ville = getIntent().getStringExtra("VILLE");
        if(username1 != null){
            final List<Evenement> myEvenement = helper.getMyEvenement(username1);
            ArrayAdapter<Evenement> adapter = new ArrayAdapter<Evenement>(this,R.layout.evn,myEvenement);
            ListView lv = (ListView) findViewById(R.id.listEvn);
            lv.setAdapter(adapter);

        }
        if(date != null && activite != null && ville != null){
            final List<Evenement> myEvenement = helper.getEvenementToAdherer(date,activite,ville);
            ArrayAdapter<Evenement> adapter = new ArrayAdapter<Evenement>(this,R.layout.evn,myEvenement);
            ListView lv = (ListView) findViewById(R.id.listEvn);
            lv.setAdapter(adapter);
            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Evenement evenement = new Evenement();
                    evenement = myEvenement.get(position);
                    Intent intent = new Intent(ListEvenement.this, DisplayActivity.class);
                    intent.putExtra("NameEvenement",evenement.getNameEvenement().toString());
                    intent.putExtra("DateEvenement",evenement.getDate().toString());
                    intent.putExtra("idEvenement",evenement.getIdEvenement().toString());
                    intent.putExtra("lieuEv",evenement.getLieu().toString());
                    intent.putExtra("username",username2);
                    startActivity(intent);
                }
            });
        }
    }
}
