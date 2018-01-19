package com.example.user.logregister;

import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ConnectBD {
    private Connection conn ;
    public void init(){
        try {
            String driver = "com.mysql.jdbc.Driver";
            Class.forName(driver);
//            String connString = "jdbc:mysql://192.168.43.146:3306/teamfinder";
//            String username = "root";
//            String password = "root";
            conn = DriverManager.getConnection("jdbc:mysql://192.168.43.146:3306/teamfinder","root","root");
            Log.w("Connection","open");

        } catch (Exception e)
        {
            Log.w("Error connection","" + e.getMessage());
        }
    }

    public void insertUser(User u){
        init();
        Statement stmt = null;
        try {
            PreparedStatement preparedStatement = conn.prepareStatement("INSERT into username(UserName,Nom,Prenom,Telephone,Email,Sexe,password) values(?,?,?,?,?,?,?)");
            preparedStatement.setString(1,u.getUserName());
            preparedStatement.setString(2,u.getNom());
            preparedStatement.setString(3,u.getPrenom());
            preparedStatement.setString(4,u.getTele());
            preparedStatement.setString(5,u.getEmail());
            preparedStatement.setInt(6,u.getSexe());
            preparedStatement.setString(7,u.getPassword());
            preparedStatement.execute();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
