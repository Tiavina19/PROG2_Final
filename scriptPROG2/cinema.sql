

/* Table "Film" */
CREATE TABLE film (
    id_film INT PRIMARY KEY,
    titre VARCHAR(255) NOT NULL,
    realisateur VARCHAR(255),
    duree INT,
    genre VARCHAR(100)
);

/* Table "Salles" */
CREATE TABLE Salles (
    id_salle INT PRIMARY KEY,
    nom VARCHAR(255) NOT NULL,
    capacite INT,
    type_projection VARCHAR(100)
);

/* Table "Seances" */
CREATE TABLE Seances (
    id_seance INT PRIMARY KEY,
    id_film INT REFERENCES film(id_film),
    id_salle INT REFERENCES Salles(id_salle),
    date_heure timestamp,
    prix_billet float
);

/* Table "Clients" */
CREATE TABLE Clients (
    id_clients INT PRIMARY KEY,
    nom VARCHAR(255),
    prenom VARCHAR(255),
    email VARCHAR(255),
    numero_telephone VARCHAR(20)
);

/* Table "Reservations" */
CREATE TABLE Reservations (
    id_reservation INT PRIMARY KEY,
    id_clients INT REFERENCES Clients(id_clients),
    id_seance INT REFERENCES Seances(id_seance),
    nombre_places INT
);
