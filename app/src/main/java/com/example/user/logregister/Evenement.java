package com.example.user.logregister;


public class Evenement {
    private String idEvenement;
    private String nameEvenement;
    private String ville;
    private String activity;
    private String lieu;
    private String nmbMax;
    private String date;
    private String time;
    private String username;

    public String getIdEvenement() {
        return idEvenement;
    }

    public void setIdEvenement(String idEvenement) {
        this.idEvenement = idEvenement;
    }

    public String getNameEvenement() {
        return nameEvenement;
    }

    public void setNameEvenement(String nameEvenement) {
        this.nameEvenement = nameEvenement;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public String getNmbMax() {
        return nmbMax;
    }

    public void setNmbMax(String nmbMax) {
        this.nmbMax = nmbMax;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return nameEvenement +" (plus de détails...)";
    }
}
