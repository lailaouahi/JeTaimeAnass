package com.example.user.logregister;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by USER on 13/12/2017.
 */

public class RegisterBD extends SQLiteOpenHelper {
    private static final String DB_name = "dbproject";
    private static final String Table_name = "Utilisateur";
    private static final String BaseDeDonées="dbprojet";
    private static final String idcolumn ="idUser";
    private static final String UserNamecolumn="UserName";
    private static final String Nomcolumn="Nom";
    private static final String Prénomcolumn="Prénom";
    private static final String Téléphonecolumn="Téléphone";
    private static final String Emailcolumn="Email";
    private static final String Sexecolumn="Sexe";
    private static final String Passwordcolumn="Password";
    public RegisterBD(Context context){super(context,Table_name,null,1);}
    @Override
    public void onCreate(SQLiteDatabase db) {
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
    public boolean checkConnection (){
        SQLiteDatabase check= null;
        try{
            check= SQLiteDatabase.openDatabase("/data/data/"+)
        }
    }
    public boolean AddData (String a){
        SQLiteDatabase BD = this.getWritableDatabase();
        ContentValues CV = new ContentValues();
        CV.put(idcolumn ,a);
        long result = BD.insert(Table_name,null,CV);
        return (result!=-1);
    }
}


