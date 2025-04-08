DROP DATABASE db_s2_ETU003303;
CREATE DATABASE db_s2_ETU003303;

use db_s2_ETU003303;
CREATE TABLE Prevision(
    idPrevision int AUTO_INCREMENT PRIMARY KEY,
    nom varchar(20),
    montant int, 
    dateDebut DATE,
    dateFin DATE
);

CREATE TABLE Depense(
    idDepense int AUTO_INCREMENT PRIMARY KEY,
    idPrevision int,
    montant int,
    dateDepense DATE,
    FOREIGN KEY (idPrevision) REFERENCES Prevision(idPrevision)
);