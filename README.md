Configuration API_COWORKIA
L'API utilise des variables d'environnement pour les informations de connexion à la base de données (H2 Console).

Avant de lancer le projet dans Eclipse :

Ouvrir Run > Run Configurations...
Sélectionner la configuration Spring Boot de l'application.
Onglet Environment.
Ajouter les variables suivantes :
DB_URL=jdbc:h2:mem:coworkia
DB_USER=choisir_votre_identifiant
DB_PASSWORD=choisir_votre_mot_de_passe
Appliquer les modifications puis lancer l'application.
Cette configuration permet de ne pas stocker les identifiants directement dans le fichier application.properties.
