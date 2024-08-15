/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class ForceOrdre {
    String nom,agent,rapport;
    int immatricule;
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    public int getImmatricule() {
        return immatricule;
    }

    public void setImmatricule(int immatricule) {
        this.immatricule = immatricule;
    }

    

    public String getRapport() {
        return rapport;
    }
public String getFO() {
        return getNom()+"-"+getAgent();
    }
    public void setRapport(String rapport) {
        this.rapport = rapport;
    }

    public ForceOrdre(String nom, String agent, int immatricule, String rapport) {
        this.nom = nom;
        this.agent = agent;
        this.immatricule = immatricule;
        this.rapport = rapport;
    }
    public ForceOrdre(){};
}
