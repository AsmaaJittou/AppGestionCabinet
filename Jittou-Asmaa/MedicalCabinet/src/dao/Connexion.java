package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {
 public static Connection con;
 static {
		 try {	
			 Class.forName("com.mysql.jdbc.Driver");
			 System.out.println("GREAAAT Driver!!!!");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_medical","root","");
			 System.out.println("GREAAAT CNX!!!!");
		}catch(ClassNotFoundException e) {
			 System.out.println("bad driver");
		 } catch (SQLException e) {
			 System.out.println("problem in cnx DB !!!");
		}
	 }
 public static Connection getCon() {
	 return con;
 }
 }

