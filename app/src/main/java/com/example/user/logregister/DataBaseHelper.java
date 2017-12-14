package com.example.user.logregister;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

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
    SQLiteDatabase db;
    private static final String createTable="CREATE TABLE Utilisateur(idUser varchar(30) primary key not null, " +
            " UserName text, Nom text, Prenom text, Telephone text, Email text, Sexe integer, password text);";

    public DataBaseHelper(Context context){super(context,DB_name,null,1);}
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(createTable);
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
        //values.put(Passwordcolumn, u.getPassword());
        values.put(Sexecolumn, u.getSexe());
        db.insert(Table_name,null, values);
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
                a = cursor.getString(2);
                if (a.equals(username)){
                    b = cursor.getString(3);
                    return a;
                }
            }while (cursor.moveToNext());
        }
        return cursor.getCount()+"";
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String q = "DROP TABLE IF EXISTS "+Table_name;
        db.execSQL(q);
        this.onCreate(db);
    }
}


