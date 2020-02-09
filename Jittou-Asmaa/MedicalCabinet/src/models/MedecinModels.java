package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import classes.Medecin;
import dao.Connexion;

public class MedecinModels {

	public Connexion cnx ;
	public Statement st;
	public static  ResultSet resultat;
	
	public void addMedecin(Medecin medecin) throws SQLException{
		try{
			System.out.println("great1");
			String query="INSERT INTO `medecins` (`version`, `titre`, `nom`, `prenom`) VALUES('"+medecin.getVersion()+"','"+medecin.getTitre()+"','"+medecin.getNom()+"','"+medecin.getPrenom()+"')";
			st= (Statement) Connexion.con.createStatement();
			System.out.println("great2");
			st.executeUpdate(query);
			System.out.println("great3");
			System.out.println("Adding medecin est effectuée avec succés!!!!");
		}
		catch(Exception E){
			System.out.println("Erreurs dans la reqeute Adding medecin");
		}
	}
	
	public void supprimerMedecin(int id) {
		try{
			System.out.println("great1");
			String query="DELETE FROM medecins WHERE id='"+id+"'";
			st= (Statement) Connexion.con.createStatement();
			st.executeUpdate(query);
			System.out.println("deleting Medecin succés!!!!");
		}
		catch(Exception E){
			System.out.println("Erreurs dans la reqeute deleting Medecin");
		}
	}
    public void modifierMedecin(int id, Medecin medecin) {
   String query = "UPDATE medecins SET version='"+medecin.getVersion()+"',titre='"+medecin.getTitre()+"',nom='"+medecin.getNom()+"',prenom='"+medecin.getPrenom()+"' WHERE Id= '"+id+ "' ";
	try {
		st= (Statement) Connexion.con.createStatement();
		st.executeUpdate(query);
		System.out.println("great updating medecin");
	} catch (SQLException e) {

		System.out.println("Erreurs dans la reqeute updating medecin");
	}
	
    }
	public  ArrayList<Medecin> listeDesMedecins() {
		ArrayList<Medecin>  medecins = new ArrayList<Medecin>();
		
		try{
			cnx = new Connexion();
			st= (Statement) Connexion.getCon().createStatement();
			resultat= (ResultSet) st.executeQuery("SELECT id , version, titre, nom, prenom from medecins");
					while (resultat.next()) {
						Medecin medecin =new Medecin();
						medecin.setId(resultat.getInt("id"));
						medecin.setVersion(resultat.getInt("version"));
					    medecin.setTitre(resultat.getString("titre"));
						medecin.setNom(resultat.getString("nom"));
						medecin.setPrenom(resultat.getString("prenom"));
						medecins.add(medecin);
					}
			
			System.out.println("medecin est affiche avec succé");
		}
		catch(Exception E){
			System.out.println("Erreurs dans la reqeute affichages des  medecins");
		}
		return medecins;
	}
}
