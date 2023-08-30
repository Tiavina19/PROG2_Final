# Gestion de Salle de Cinéma

Ce projet de gestion de salle de cinéma implémente un système CRUD (Create, Read, Update, Delete) en utilisant Java pour les opérations côté application et PostgreSQL pour le stockage des données. Les scripts SQL fournis ont été utilisés pour créer les tables nécessaires dans la base de données.

## Fonctionnalités

L'application de gestion de salle de cinéma permet d'effectuer les opérations CRUD suivantes :

### Create (Créer)

- Ajouter de nouveaux films avec des détails tels que le titre, le réalisateur, la durée et le genre.
- Créer de nouvelles salles de cinéma en spécifiant le nom, la capacité et le type de projection.
- Planifier de nouvelles séances en associant un film, une salle, une date/heure et un prix de billet.
- Enregistrer de nouveaux clients avec leurs informations telles que le nom, le prénom, l'email et le numéro de téléphone.
- Faire des réservations en associant un client à une séance et en spécifiant le nombre de places réservées.

### Read (Lire)

- Récupérer la liste complète des films disponibles avec tous leurs détails.
- Obtenir des informations détaillées sur les salles de cinéma, y compris la capacité et le type de projection.
- Consulter les horaires des séances planifiées avec les détails du film et de la salle.
- Afficher la liste des clients enregistrés avec leurs coordonnées.
- Voir les réservations effectuées avec le nombre de places réservées.

### Update (Mettre à jour)

- Modifier les détails des films existants tels que le réalisateur, la durée ou le genre.
- Mettre à jour les informations sur les salles de cinéma, y compris le nom, la capacité ou le type de projection.
- Modifier les horaires des séances ou les prix des billets.
- Mettre à jour les informations des clients enregistrés comme leur nom, prénom, email ou numéro de téléphone.
- Modifier le nombre de places réservées pour une réservation donnée.

### Delete (Supprimer)

- Supprimer des films de la base de données.
- Retirer des salles de cinéma qui ne sont plus nécessaires.
- Annuler des séances planifiées.
- Supprimer les informations des clients.
- Annuler des réservations et libérer les places réservées.

## Lien de l'API :
