/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class Vehicule {
    String modele,immatricule;
    int annee;

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }
    

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public String getImmatricule() {
        return immatricule;
    }

    public void setImmatricule(String immatricule) {
        this.immatricule = immatricule;
    }
    public String getVeh(){
        return getModele()+"-"+getImmatricule();
    }

    public Vehicule(String modele, String immatricule,int annee) {
        this.modele = modele;
        this.immatricule = immatricule;
        this.annee=annee;
    }
    public Vehicule(){}
}
