package main;
import java.sql.*;


public class select {

	
	
	public static void main(String[] args) {
		
		try { 
			String strClassName = "com.mysql.jdbc.Driver";
            String dbName = "tp_jdbc";
            String login = "root";
            String motdepasse = "";
            // Ajout de useSSL=false dans l'URL
            String strUrl = "jdbc:mysql://localhost:3306/" + dbName + "?useSSL=false";

			Class.forName(strClassName);
			Connection conn = DriverManager.getConnection(strUrl, login, motdepasse);
			Statement stUsers = conn.createStatement();  

			ResultSet rsUsers = stUsers.executeQuery("select * from Acces");  
			while(rsUsers.next()) {
				System.out.print("Id[" + rsUsers.getInt(1) + "]"
				+ rsUsers.getString(2)
				+ "[" + rsUsers.getString("statut") + "] "
				+ rsUsers.getInt("age") +"\n"); }  
			conn.close();
			}
			catch(ClassNotFoundException e) {  
				System.err.println("Driver non chargé !");  e.printStackTrace();
			} catch(SQLException e) {
				System.err.println("Autre erreur !");  e.printStackTrace();
			}

		
		
	}
}
