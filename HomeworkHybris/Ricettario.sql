DROP DATABASE IF EXISTS Ricettario; #delete db if it exists

CREATE DATABASE Ricettario #create  new database
	DEFAULT CHARACTER SET latin1
	DEFAULT COLLATE latin1_general_ci;
    
USE Ricettario;

ALTER DATABASE Ricettario #chance parameter of db
	DEFAULT CHARACTER SET utf8
	DEFAULT COLLATE utf8_unicode_ci;

DROP TABLE IF EXISTS Ricetta;

CREATE TABLE Ricetta (  #create table ricetta
    id INT(10) NOT NULL AUTO_INCREMENT,
    nome VARCHAR(20) NOT NULL,
    tempoCottura INT(10),
    portata VARCHAR(10),
    calorie INT(10),
    paeseProvenienza VARCHAR(15),
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS Ingrediente;

CREATE TABLE Ingrediente (  #create table ingredienti
    nome VARCHAR(20) NOT NULL,
    provenienza VARCHAR(20) NOT NULL,
    tipo VARCHAR(20),
    PRIMARY KEY (nome)
);

DROP TABLE IF EXISTS Dose;

CREATE TABLE Dose (  #create table dosi
	ricetta INT(10) NOT NULL,
    ingrediente VARCHAR(20) NOT NULL,
    quantita INT(10) NOT NULL,
    FOREIGN KEY (ricetta) REFERENCES Ricetta(id),
    FOREIGN KEY (ingrediente) REFERENCES Ingrediente(nome)
);

