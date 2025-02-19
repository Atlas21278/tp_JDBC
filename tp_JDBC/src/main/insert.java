package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class insert {
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
            Statement stAddUser = conn.createStatement();
            stAddUser.executeUpdate("insert into Acces values (6,'Tom','tomahawk','indien','Etudiant',22)");

            System.out.println("Insertion réussie !"); // Ajout d'un message de confirmation
            
            conn.close();
        }
        catch(ClassNotFoundException e) {
            System.err.println("Driver non chargé !");
            e.printStackTrace();
        }
        catch(SQLException e) {
            System.err.println("Autre erreur !");
            e.printStackTrace();
        }
    }
}