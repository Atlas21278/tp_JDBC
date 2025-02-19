package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Update {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            // Configuration de la connexion
            String strClassName = "com.mysql.jdbc.Driver";
            String dbName = "tp_jdbc";
            String login = "root";
            String motdepasse = "";
            String strUrl = "jdbc:mysql://localhost:3306/" + dbName + "?useSSL=false";

            // Demander les informations à l'utilisateur
            System.out.println("Entrez l'ID de la personne à modifier : ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Vider le buffer

            System.out.println("Entrez le nouveau statut : ");
            String nouveauStatut = scanner.nextLine();

            // Connexion à la base de données
            Class.forName(strClassName);
            Connection conn = DriverManager.getConnection(strUrl, login, motdepasse);
            Statement stmt = conn.createStatement();
            
            // Exécution de la modification
            String query = "UPDATE Acces SET statut = '" + nouveauStatut + "' WHERE id = " + id;
            stmt.executeUpdate(query);
            
            System.out.println("Statut modifié avec succès !");
            
            // Fermeture des ressources
            conn.close();
            scanner.close();
        }
        catch(ClassNotFoundException e) {
            System.err.println("Driver non chargé !");
            e.printStackTrace();
        }
        catch(SQLException e) {
            System.err.println("Erreur SQL !");
            e.printStackTrace();
        }
    }
}