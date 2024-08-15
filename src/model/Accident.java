/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class Accident {
    String typeAcc,date,lieu;
    int fo;

    public String getTypeAcc() {
        return typeAcc;
    }

    public void setTypeAcc(String typeAcc) {
        this.typeAcc = typeAcc;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public int getFo() {
        return fo;
    }

    public void setFo(int fo) {
        this.fo = fo;
    }

    public Accident(String typeAcc, String date, String lieu, int fo) {
        this.typeAcc = typeAcc;
        this.date = date;
        this.lieu = lieu;
        this.fo = fo;
    }
    public Accident(){}         
}
