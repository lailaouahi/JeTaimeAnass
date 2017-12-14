package com.example.user.logregister;

/**
 * Created by Anass on 13/12/2017.
 */

public class User {
    private String idUser;
    private String UserName;
    private String password;
    private String Nom;
    private String Prenom;
    private String Tele;
    private String Email;
    private int Sexe;

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String prenom) {
        Prenom = prenom;
    }

    public String getTele() {
        return Tele;
    }

    public void setTele(String tele) {
        Tele = tele;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public int getSexe() {
        return Sexe;
    }

    public void setSexe(int sexe) {
        Sexe = sexe;
    }
}
