/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controler;

import java.sql.*;
import java.util.*;
import javax.swing.*;
import model.*;
public class Factory {
 private static Connection conn=null;
private static Statement stm;
private static PreparedStatement ps=null;
private static ResultSet rs=null;
public static Connection getConnection(){
    String serveur="localhost";
    int port=3306;
    String database="gestion_accident";
    String username="root";
    String password="";
try{
    Class.forName("com.mysql.jdbc.Driver").newInstance();
    String url="jdbc:mysql://"+serveur+":"+port+"/"+database+"?characterEncoding=latin1";
    conn=DriverManager.getConnection(url,username,password);
    System.out.println("Connected");
    return conn;
} catch (Exception e){
    e.printStackTrace();
    return null;
} 
}
public static void ModifAccidentById(String type,String date,String lieu,int fo,int m){ 
    try{
        conn=getConnection();
        stm=conn.createStatement();
        String re=("update accident SET Type_Acc='"+type+"',Date_Acc='"+date+"',lieu='"+lieu+"',IDFO='"+fo+"'WHERE IDAcc='"+m+"'");
        stm.executeUpdate(re);
        conn.close();
}catch(SQLException ex){
   JOptionPane.showConfirmDialog(null, ex.getMessage());
}
}
public static void supprimerAccidentById(int n){
    try{
        conn=getConnection();
        stm=conn.createStatement();
        String req=("delete from accident WHERE IDAcc='"+n+"'");
    
        stm.executeUpdate(req);
        conn.close();
}catch(SQLException ex){
   JOptionPane.showConfirmDialog(null, ex.getMessage());
}
}
public static void insererAccidentaire(Accidentaire cr){    
    try{
        conn=getConnection();
       ps=conn.prepareStatement("insert into gestion_accident.accidentaire(NomVict,PrenomVict,sexe,age,statut,Etat,IDVeh)values(?,?,?,?,?,?,?)");
    ps.setString(1, cr.getNom());
       ps.setString(2, cr.getPrenom());
    ps.setString(3, cr.getSexe());
    ps.setInt(4, cr.getAnnee());
    ps.setString(5, cr.getStatut());
     ps.setString(6, cr.getEtat());
     ps.setInt(7, cr.getVehicule());
    ps.executeUpdate();
    conn.close();
    }catch(Exception e){
        JOptionPane.showConfirmDialog(null, e.getMessage());
    }
}
public static void insererVehicule(Vehicule cr){    
    try{
        conn=getConnection();
       ps=conn.prepareStatement("insert into gestion_accident.vehicule(Modele,Immatriculation,anneefabrication)values(?,?,?)");
    ps.setString(1, cr.getModele());
       ps.setString(2, cr.getImmatricule());   
       ps.setInt(3, cr.getAnnee());   
    ps.executeUpdate();
    conn.close();
    }catch(Exception e){
        JOptionPane.showConfirmDialog(null, e.getMessage());
    }
}
public static void insererFO(ForceOrdre cr){
    try{
        conn=getConnection();
       ps=conn.prepareStatement("insert into forceordre(NomFO,Agent,Immatriculation,Rapport)values(?,?,?,?)");
    ps.setString(1, cr.getNom());
    ps.setString(2, cr.getAgent());
    ps.setInt(3, cr.getImmatricule());
    ps.setString(4, cr.getRapport());
    ps.executeUpdate();
    conn.close();
    }catch(Exception e){
        JOptionPane.showConfirmDialog(null, e.getMessage());
    }
}
public static void ModifFOById(String nm,String agent,String immatricule,String rapport,int m){
    try{
        conn=getConnection();
        stm=conn.createStatement();
        String re=("update forceordre SET NomFO='"+nm+"',Agent='"+agent+"',Immatriculation='"+immatricule+"',Rapport='"+rapport+"'WHERE IDFO='"+m+"'");
        stm.executeUpdate(re);
        conn.close();
}catch(SQLException ex){
   JOptionPane.showConfirmDialog(null, ex.getMessage());
}
}
public static void ModifVehiculeById(String modele,String immatricule,int annee,int m){
    try{
        conn=getConnection();
        stm=conn.createStatement();
        String re=("update vehicule SET Modele='"+modele+"',Immatriculation='"+immatricule+"',anneefabrication='"+annee+"' WHERE IDVeh='"+m+"'");
        stm.executeUpdate(re);
        conn.close();
}catch(SQLException ex){
   JOptionPane.showConfirmDialog(null, ex.getMessage());
}
}
public static ArrayList<ForceOrdre> getFO(){
    ArrayList<ForceOrdre>lic=new ArrayList();
   ForceOrdre ma=null;
    try{
        conn=getConnection();
        stm=conn.createStatement();
        rs=stm.executeQuery("select * from forceordre");
        while(rs.next()){
            ma=new ForceOrdre();
            ma.setNom(rs.getString("NomFO"));
            ma.setAgent(rs.getString("Agent"));
            ma.setImmatricule(rs.getInt("Immatriculation"));
            ma.setRapport(rs.getString("Rapport"));  
            lic.add(ma);
        }
        conn.close();
        stm.close();
    }
    catch(Exception e){
        
    }return lic;
}
public static ArrayList<Accidentaire> getAccidentaire(){
    ArrayList<Accidentaire>lic=new ArrayList();
   Accidentaire ma=null;
    try{
        conn=getConnection();
        stm=conn.createStatement();
        rs=stm.executeQuery("select * from accidentaire");
        while(rs.next()){
            ma=new Accidentaire();
            ma.setNom(rs.getString("NomVict"));
            ma.setPrenom(rs.getString("PrenomVict"));
            ma.setSexe(rs.getString("sexe"));
            ma.setAnnee(rs.getInt("age"));
            ma.setStatut(rs.getString("statut"));  
            ma.setEtat(rs.getString("Etat"));
            ma.setVehicule(rs.getInt("IDVeh"));
            lic.add(ma);
        }
        conn.close();
        stm.close();
    }
    catch(Exception e){
        
    }return lic;
}
public static ArrayList<Accident> getAccident(){
    ArrayList<Accident>lic=new ArrayList();
  Accident ma=null;
    try{
        conn=getConnection();
        stm=conn.createStatement();
        rs=stm.executeQuery("select * from accident");
        while(rs.next()){
            ma=new Accident();
            ma.setTypeAcc(rs.getString("Type_Acc"));
            ma.setDate(rs.getString("Date_Acc"));
            ma.setLieu(rs.getString("lieu"));
            ma.setFo(rs.getInt("IDFO"));  
            lic.add(ma);
        }
        conn.close();
        stm.close();
    }
    catch(Exception e){
        
    }return lic;
}
public static ArrayList<Vehicule> getVehicule(){
    ArrayList<Vehicule>lic=new ArrayList();
  Vehicule ma=null;
    try{
        conn=getConnection();
        stm=conn.createStatement();
        rs=stm.executeQuery("select * from vehicule");
        while(rs.next()){
            ma=new Vehicule();
            ma.setModele(rs.getString("Modele"));
            ma.setImmatricule(rs.getString("Immatriculation"));
            ma.setAnnee(rs.getInt("anneefabrication"));
            lic.add(ma);
        }
        conn.close();
        stm.close();
    }
    catch(Exception e){
        
    }return lic;
} 
public static void supprimerFOById(int n){
    try{
        conn=getConnection();
        stm=conn.createStatement();
        String req=("delete from forceordre WHERE IDFO='"+n+"'");
        stm.executeUpdate(req);
        conn.close();
}catch(SQLException ex){
   JOptionPane.showConfirmDialog(null, ex.getMessage());
}
}
public static void supprimerVehiculeById(int n){
    try{
        conn=getConnection();
        stm=conn.createStatement();
        String req=("delete from vehicule WHERE IDVeh='"+n+"'");
        stm.executeUpdate(req);
        conn.close();
}catch(SQLException ex){
   JOptionPane.showConfirmDialog(null, ex.getMessage());
}
}
   public static ForceOrdre getFOById(int nm){
  ForceOrdre cl=null;
    try{
        conn=getConnection();
        stm=conn.createStatement();
        rs=stm.executeQuery("select * from forceordre where IDFO='"+nm+"'");
        if(rs.next()){
            cl=new ForceOrdre();
            cl.setNom(rs.getString("NomFO"));
            cl.setAgent(rs.getString("Agent"));
            cl.setImmatricule(rs.getInt("Immatriculation"));
            cl.setRapport(rs.getString("Rapport"));
        }
        conn.close();
        stm.close();
        return cl;
    }
    catch(Exception e){
        JOptionPane.showConfirmDialog(null, e.getMessage());
        return null;
    }
}
     public static Vehicule getVehiculeById(int nm){
  Vehicule cl=null;
    try{
        conn=getConnection();
        stm=conn.createStatement();
        rs=stm.executeQuery("select * from vehicule where IDVeh='"+nm+"'");
        if(rs.next()){
            cl=new Vehicule();
            cl.setModele(rs.getString("Modele"));
            cl.setImmatricule(rs.getString("Immatriculation"));
            cl.setAnnee(rs.getInt("anneefabrication"));
        }
        conn.close();
        stm.close();
        return cl;
    }
    catch(Exception e){
        JOptionPane.showConfirmDialog(null, e.getMessage());
        return null;
    }
}
}
