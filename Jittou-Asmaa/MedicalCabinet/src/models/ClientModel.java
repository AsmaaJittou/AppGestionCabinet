package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import classes.Client;
import dao.Connexion;

public class ClientModel {

	public Connexion cnx ;
	public Statement st;
	public static  ResultSet resultat;
	
	public void addClient(Client client) throws SQLException{
		try{
			System.out.println("great1");
			String query="INSERT INTO `clients` (`version`, `titre`, `nom`, `prenom`) VALUES('"+client.getVersion()+"','"+client.getTitre()+"','"+client.getNom()+"','"+client.getPrenom()+"')";
			st= (Statement) Connexion.con.createStatement();
			System.out.println("great2");
			st.executeUpdate(query);
			System.out.println("great3");
			System.out.println("Adding Client est effectuée avec succés!!!!");
		}
		catch(Exception E){
			System.out.println("Erreurs dans la reqeute Adding Client");
		}
	}
	
	public void supprimerClient(int id) {
		try{
			System.out.println("great1");
			String query="DELETE FROM clients WHERE id='"+id+"'";
			st= (Statement) Connexion.con.createStatement();
			st.executeUpdate(query);
			System.out.println("deleting Client succés!!!!");
		}
		catch(Exception E){
			System.out.println("Erreurs dans la reqeute deleting Client");
		}
	}
    public void modifierClient(int id, Client client) {
   String query = "UPDATE clients SET version='"+client.getVersion()+"',titre='"+client.getTitre()+"',nom='"+client.getNom()+"',prenom='"+client.getPrenom()+"' WHERE Id= '"+id+ "' ";
	try {
		st= (Statement) Connexion.con.createStatement();
		st.executeUpdate(query);
		System.out.println("great updating Client");
	} catch (SQLException e) {

		System.out.println("Erreurs dans la reqeute updating Client");
	}
	
    }
	public  ArrayList<Client> listeDesclients() {
		ArrayList<Client>  clients = new ArrayList<Client>();
		
		try{
			cnx = new Connexion();
			st= (Statement) Connexion.getCon().createStatement();
			resultat= (ResultSet) st.executeQuery("SELECT id , version, titre, nom, prenom from clients");
					while (resultat.next()) {
						Client client =new Client();
						client.setId(resultat.getInt("id"));
						client.setVersion(resultat.getInt("version"));
					    client.setTitre(resultat.getString("titre"));
						client.setNom(resultat.getString("nom"));
						client.setPrenom(resultat.getString("prenom"));
						clients.add(client);
					}
			
			System.out.println("Client est affiche avec succé");
		}
		catch(Exception E){
			System.out.println("Erreurs dans la reqeute affichages des  Clients");
		}
		return clients;
	}
	public static void main(String [] args) {
	ClientModel md = new ClientModel();
	Client client = new Client();
	client.setNom("bouhamed");
	md.modifierClient(1, client);
	}
}
