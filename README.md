# Exercice 5 - Réponses aux questions finales

## Ecrire un main pour faire tourner votre code… qu’en pensez-vous ?
Je pense que ce code est bien mieux organisé que les versions précédentes car maintenant :
* Je n'ai plus besoin de réécrire le code de connexion dans chaque classe
* Si je fais une erreur, je sais exactement où chercher
* C'est beaucoup plus simple à utiliser car j'ai juste à appeler mes méthodes (ajouter, supprimer, lister)
* Je peux facilement réutiliser ces méthodes dans d'autres parties de mon programme

## Que dois-je changer si je modifie ma base de données (l'adresse IP par exemple) ?
Je dois simplement modifier les constantes au début de ma classe DAOAcces. Par exemple :
* Pour changer l'IP : je modifie juste la partie "localhost" dans l'URL
* Pour changer de base : je modifie DB_NAME
* Pour changer les identifiants : je modifie LOGIN et PASSWORD

L'avantage, c'est que je n'ai qu'un seul endroit à modifier, pas besoin de chercher dans tout mon code !



# Exercice 6 - Comparaison des méthodes

Je trouve que les nouvelles méthodes sont meilleures car :
* Je manipule des objets plutôt que des paramètres séparés
* Les requêtes paramétrées sont plus sécurisées 
* Le code est mieux organisé avec une vraie classe Acces
* Je peux récupérer et manipuler les données plus facilement avec l'ArrayList
