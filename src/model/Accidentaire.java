            /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class Accidentaire {
    String nom,prenom,sexe,statut,etat;
    int annee,vehicule;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public int getVehicule() {
        return vehicule;
    }

    public void setVehicule(int vehicule) {
        this.vehicule = vehicule;
    }

    public int getAnnee() {
//        int age=2024-annee;
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public Accidentaire(String nom, String prenom, String sexe, String statut, String etat,int vehicule, int annee) {
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.statut = statut;
        this.etat = etat;
        this.vehicule = vehicule;
        this.annee = annee;
    }
    public Accidentaire() {}                

}
