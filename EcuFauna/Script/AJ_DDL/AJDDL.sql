-- database: ../../DataBase/AJDataBase.sqlite

DROP TABLE IF EXISTS Paises;
DROP TABLE IF EXISTS Regiones;
DROP TABLE IF EXISTS Provincias;

CREATE TABLE Paises(
    idPais              INTEGER PRIMARY KEY AUTOINCREMENT,
    NombrePais          VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE Regiones(
    idRegion            INTEGER PRIMARY KEY AUTOINCREMENT,
    NombreRegion        VARCHAR(50) NOT NULL UNIQUE,
    idPais              INTEGER NOT NULL,
    CONSTRAINT          fk_Pais FOREIGN KEY(idPais) REFERENCES Paises(idPais)
);
CREATE TABLE Provincias(
    idProvincia         INTEGER PRIMARY KEY AUTOINCREMENT,
    NombreProvincia     VARCHAR(50) NOT NULL UNIQUE,
    idRegion            INTEGER NOT NULL,
    CONSTRAINT          fk_Region FOREIGN KEY(idRegion) REFERENCES Regiones(idRegion)
);
CREATE TABLE IngestaNativa(
    idIngestaNativa     INTEGER PRIMARY KEY AUTOINCREMENT,
    NombreIngestaNativa VARCHAR(30) NOT NULL UNIQUE
);
CREATE TABLE GenoAlimento(
    idGenoAlimento      INTEGER PRIMARY KEY AUTOINCREMENT,
    NombreGenoAlimento  VARCHAR(10) NOT NULL UNIQUE
);

CREATE TABLE Alimentos(
    idAlimento          INTEGER PRIMARY KEY AUTOINCREMENT,
    idGenoAlimento      INTEGER NOT NULL, 
    idIngestaNativa     INTEGER NOT NULL,
    
);

