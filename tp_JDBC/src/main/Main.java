package main;

import java.util.ArrayList;

public class Main {
   public static void main(String[] args) {
       try {
           // Création de l'objet DAO
           DAOAcces dao = new DAOAcces();

           System.out.println("----------- TEST DES ANCIENNES MÉTHODES (Exercice 5) -----------");
           System.out.println("\n1. Liste initiale avec l'ancienne méthode :");
           dao.lister();

           System.out.println("\n2. Ajout d'un utilisateur avec l'ancienne méthode :");
           dao.ajouter(6, "Marie", "marie123", "mdp123", "Etudiant", 20);
           dao.lister();

           System.out.println("\n3. Suppression avec l'ancienne méthode :");
           dao.supprimer(6);
           dao.lister();

           System.out.println("\n----------- TEST DES NOUVELLES MÉTHODES (Exercice 6) -----------");
           
           System.out.println("\n4. Liste avec la nouvelle méthode DAO :");
           ArrayList<Acces> liste = dao.listerDAO();
           for(Acces a : liste) {
               System.out.println("ID: " + a.getId() + 
                                ", Prénom: " + a.getPrenom() + 
                                ", Login: " + a.getLogin() + 
                                ", Statut: " + a.getStatut() + 
                                ", Age: " + a.getAge());
           }

           System.out.println("\n5. Ajout avec la nouvelle méthode DAO :");
           Acces nouvelAcces = new Acces(6, "Paul", "paul123", "mdp456", "Etudiant", 22);
           dao.ajouterDAO(nouvelAcces);
           dao.lister();

           System.out.println("\n6. Suppression avec la nouvelle méthode DAO :");
           dao.supprimerDAO(nouvelAcces);
           dao.lister();

           // Fermeture de la connexion
           dao.fermerConnexion();
           
       } catch (Exception e) {
           System.err.println("Erreur : " + e.getMessage());
           e.printStackTrace();
       }
   }
}