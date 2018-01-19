package com.example.user.logregister;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by USER on 13/12/2017.
 */

public class DataBaseHelper extends SQLiteOpenHelper {

    private static final String DB_name = "dbproject.db";
    private static final String Table_name = "Utilisateur";
    private static final String idcolumn ="idUser";
    private static final String UserNamecolumn="UserName";
    private static final String Nomcolumn="Nom";
    private static final String Prenomcolumn="Prenom";
    private static final String Telephonecolumn="Telephone";
    private static final String Emailcolumn="Email";
    private static final String Sexecolumn="Sexe";
    private static final String Passwordcolumn="password";
    private static final String idEvcolumn ="idEvenement";
    private static final String Namecolumn="name";
    private static final String villecolumn="ville";
    private static final String activitecolumn="activite";
    private static final String lieucolumn="lieu";
    private static final String nbrmaxcolumn="nbrmax";
    private static final String dateEvcolumn="dateEv";
    private static final String timeEvcolumn="timeEv";
    private static final String creatorcolumn="creator";
    private static final String idAdhesioncolumn="idAdhesion";
    private static final String usercolumn="username";
    private static final String idLieucolumn="idLieu";
    private static final String latlngcolumn="latlng";
    SQLiteDatabase db;
    private static final String createTable="CREATE TABLE Utilisateur(idUser varchar(30) primary key not null, " +
            " UserName text, Nom text, Prenom text, Telephone text, Email text, Sexe integer, password text);";
    private static final String createTableEv="CREATE TABLE Evenement(idEvenement varchar(30) primary key not null, " +
            " name text, ville text, activite text, lieu text, nbrmax text, dateEv text, timeEv text, creator text);";
    private static final String createTableAdhesion="CREATE TABLE Adhesion(idAdhesion varchar(30) primary key not null, " +
            " idEvenement varchar(30), username varchar(30));";
    private static final String createTableLieu="CREATE TABLE Lieu(idLieu varchar(30) primary key not null, " +
            " latlng varchar(200));";

    public DataBaseHelper(Context context){super(context,DB_name,null,24);}
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(createTable);
        db.execSQL(createTableEv);
        db.execSQL(createTableAdhesion);
        db.execSQL(createTableLieu);
        this.db = db;
    }

    public void insertUser(User u){
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        String q = "Select * from Utilisateur";
        Cursor c = db.rawQuery(q, null);
        int count = c.getCount();
        values.put(idcolumn,count);
        values.put(UserNamecolumn, u.getUserName());
        values.put(Nomcolumn, u.getNom());
        values.put(Prenomcolumn, u.getPrenom());
        values.put(Telephonecolumn, u.getTele());
        values.put(Emailcolumn, u.getEmail());
        values.put(Sexecolumn, u.getSexe());
        values.put(Passwordcolumn, u.getPassword());
        db.insert(Table_name,null, values);
        db.close();
    }public void insertLieu(String latlng){
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        String q = "Select * from Lieu";
        Cursor c = db.rawQuery(q, null);
        int count = c.getCount();
        values.put(idLieucolumn,count);
        values.put(latlngcolumn, latlng);
        db.insert("Lieu",null, values);
        db.close();
    }

    public String searchPassword(String username){
        db = this.getReadableDatabase();
        String query = "SELECT * from "+Table_name;
        Cursor cursor = db.rawQuery(query, null);
        String a,b;
        b = "not found";
        if(cursor.moveToFirst()){
            do {
                a = cursor.getString(cursor.getColumnIndex("UserName"));
                if (a.equals(username)){
                    b = cursor.getString(cursor.getColumnIndex("password"));
                }
            }while (cursor.moveToNext());
        }
        return b;
    }


    public void saveEvenement(EditText nameEven, EditText ville, EditText activite, EditText lieu, EditText nbrMax, DatePicker date, TimePicker time, String userName) {
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        String q = "Select * from Evenement";
        Cursor c = db.rawQuery(q, null);
        int count = c.getCount();
        values.put(idEvcolumn,count);
        values.put(Namecolumn, nameEven.getText().toString());
        values.put(villecolumn, ville.getText().toString());
        values.put(activitecolumn, activite.getText().toString());
        values.put(lieucolumn, lieu.getText().toString());
        values.put(nbrmaxcolumn, nbrMax.getText().toString());
        values.put(dateEvcolumn, String.valueOf(date.getDayOfMonth())+"/"+String.valueOf(date.getMonth())+"/"+String.valueOf(date.getYear()));
        values.put(timeEvcolumn, "10:20");
        values.put(creatorcolumn, userName);
        db.insert("Evenement",null, values);
        db.close();
    }
    public void saveAdhesion(String username, String idEvenement) {
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        String q = "Select * from Adhesion";
        Cursor c = db.rawQuery(q, null);
        int count = c.getCount();
        values.put(idAdhesioncolumn,count);
        values.put(usercolumn, username.toString());
        values.put(idEvcolumn, idEvenement.toString());;
        db.insert("Adhesion",null, values);
        db.close();
    }

    public List<Evenement> getMyEvenement(String username){
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        String q = "Select * from Evenement ";
        Cursor c = db.rawQuery(q, null);
        String value = c.getColumnNames().toString();
        List<Evenement> listevenement = new ArrayList<>();
        int count = c.getCount();
        if(c.moveToFirst()) {
            do {
                Evenement evenement = new Evenement();
                int index = c.getColumnIndex("name");
                evenement.setNameEvenement(c.getString(index));
                evenement.setActivity(c.getString(c.getColumnIndex("activite")));
                evenement.setLieu(c.getString(c.getColumnIndex("lieu")));
                evenement.setNmbMax(c.getString(c.getColumnIndex("nbrmax")));
                evenement.setDate(c.getString(c.getColumnIndex("dateEv")));
                evenement.setVille(c.getString(c.getColumnIndex("ville")));
                evenement.setUsername(c.getString(c.getColumnIndex("creator")));
                evenement.setTime(c.getString(c.getColumnIndex("timeEv")));
                evenement.setIdEvenement(c.getString(c.getColumnIndex("idEvenement")));
                if (username.equals(c.getString(c.getColumnIndex("creator"))))
                listevenement.add(evenement);
            }while(c.moveToNext());
        }

        c.close();
        db.close();
        return listevenement;
    }
    public List<Evenement> getEvenementToAdherer(String date, String activite, String ville){
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        String q = "Select * from Evenement ";
        Cursor c = db.rawQuery(q, null);
        String value = c.getColumnNames().toString();
        List<Evenement> listevenement = new ArrayList<>();
        int count = c.getCount();
        if(c.moveToFirst()) {
            do {
                Evenement evenement = new Evenement();
                int index = c.getColumnIndex("name");
                evenement.setNameEvenement(c.getString(index));
                evenement.setActivity(c.getString(c.getColumnIndex("activite")));
                evenement.setLieu(c.getString(c.getColumnIndex("lieu")));
                evenement.setNmbMax(c.getString(c.getColumnIndex("nbrmax")));
                evenement.setDate(c.getString(c.getColumnIndex("dateEv")));
                evenement.setVille(c.getString(c.getColumnIndex("ville")));
                evenement.setUsername(c.getString(c.getColumnIndex("creator")));
                evenement.setTime(c.getString(c.getColumnIndex("timeEv")));
                evenement.setIdEvenement(c.getString(c.getColumnIndex("idEvenement")));
                if (date.equals(c.getString(c.getColumnIndex("dateEv"))) && ville.equals(c.getString(c.getColumnIndex("ville")))
                        && activite.equals(c.getString(c.getColumnIndex("activite"))))
                    listevenement.add(evenement);
            }while(c.moveToNext());
        }

        c.close();
        db.close();
        return listevenement;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String q = "DROP TABLE IF EXISTS "+Table_name;
        String qu = "DROP TABLE IF EXISTS Evenement";
        String quu = "DROP TABLE IF EXISTS Adhesion";
        String quuu = "DROP TABLE IF EXISTS Lieu";
        db.execSQL(q);
        db.execSQL(qu);
        db.execSQL(quu);
        db.execSQL(quuu);
        this.onCreate(db);
    }
}


