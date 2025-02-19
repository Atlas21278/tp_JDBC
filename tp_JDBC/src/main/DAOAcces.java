package main;

import java.sql.*;
import java.util.ArrayList;

public class DAOAcces {
    private Connection conn;
    private Statement stmt;
    
    // Configuration de la base de données
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_NAME = "tp_jdbc";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "";
    private static final String URL = "jdbc:mysql://localhost:3306/" + DB_NAME + "?useSSL=false";
    
    // Constructeur
    public DAOAcces() throws ClassNotFoundException, SQLException {
        Class.forName(DRIVER);
        conn = DriverManager.getConnection(URL, LOGIN, PASSWORD);
        stmt = conn.createStatement();
    }
    
    // Méthode pour fermer la connexion
    public void fermerConnexion() throws SQLException {
        if (stmt != null) stmt.close();
        if (conn != null) conn.close();
    }
    
    // Anciennes méthodes de l'exercice 5
    public void lister() throws SQLException {
        String query = "SELECT * FROM Acces";
        ResultSet rs = stmt.executeQuery(query);
        
        while (rs.next()) {
            System.out.println(
                "ID: " + rs.getInt("id") +
                ", Prénom: " + rs.getString("prenom") +
                ", Login: " + rs.getString("login") +
                ", Statut: " + rs.getString("statut") +
                ", Age: " + rs.getInt("age")
            );
        }
        rs.close();
    }
    
    public void ajouter(int id, String prenom, String login, String password, 
                       String statut, int age) throws SQLException {
        String query = "INSERT INTO Acces VALUES (" + 
            id + ", '" + prenom + "', '" + login + "', '" + 
            password + "', '" + statut + "', " + age + ")";
        stmt.executeUpdate(query);
    }
    
    public void supprimer(int id) throws SQLException {
        String query = "DELETE FROM Acces WHERE id = " + id;
        stmt.executeUpdate(query);
    }
    
    // Nouvelles méthodes pour l'exercice 6 avec requêtes paramétrées
    public ArrayList<Acces> listerDAO() throws SQLException {
        ArrayList<Acces> listeAcces = new ArrayList<>();
        String query = "SELECT * FROM Acces";
        PreparedStatement pstmt = conn.prepareStatement(query);
        ResultSet rs = pstmt.executeQuery();
        
        while (rs.next()) {
            listeAcces.add(new Acces(
                rs.getInt("id"),
                rs.getString("prenom"),
                rs.getString("login"),
                rs.getString("password"),
                rs.getString("statut"),
                rs.getInt("age")
            ));
        }
        rs.close();
        pstmt.close();
        return listeAcces;
    }
    
    public void ajouterDAO(Acces a) throws SQLException {
        String query = "INSERT INTO Acces VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(query);
        
        pstmt.setInt(1, a.getId());
        pstmt.setString(2, a.getPrenom());
        pstmt.setString(3, a.getLogin());
        pstmt.setString(4, a.getPassword());
        pstmt.setString(5, a.getStatut());
        pstmt.setInt(6, a.getAge());
        
        pstmt.executeUpdate();
        pstmt.close();
    }
    
    public void supprimerDAO(Acces a) throws SQLException {
        String query = "DELETE FROM Acces WHERE id = ?";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setInt(1, a.getId());
        pstmt.executeUpdate();
        pstmt.close();
    }
}