package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import classes.Admin;
import dao.Connexion;

public class AdminModels {
	public Connexion cnx ;
	public Statement st;
	public static  ResultSet resultat;
	
	public String login(String email) {
		String  p= "123";
		String req = "select password , email  from admins  where  email='"+email+"' ";
		try {
			cnx = new Connexion();
			st = (Statement) Connexion.getCon().createStatement();
			resultat =(ResultSet) st.executeQuery(req);
			
			while (resultat.next()) {
				p = resultat.getString("password"); 
				System.out.println(email);
				System.out.println(p);
			}
		} catch (SQLException e) {
			System.out.println("select elmail");
		}
			return p;	
		}
}
