-- database: ../../DataBase/AJDataBase.sqlite

DROP TABLE IF EXISTS AJPaises;
DROP TABLE IF EXISTS AJRegiones;
DROP TABLE IF EXISTS AJProvincias;
DROP TABLE IF EXISTS AJSexo;
DROP TABLE IF EXISTS AJIngestaNativa;
DROP TABLE IF EXISTS AJGenoAlimento;
DROP TABLE IF EXISTS AJTipoAlimento;
DROP TABLE IF EXISTS AJAlimento;
DROP TABLE IF EXISTS AJHormigas;

CREATE TABLE AJPaises(
    idAJPais            INTEGER PRIMARY KEY AUTOINCREMENT,
    NombrePais          VARCHAR(50) NOT NULL UNIQUE,
    Estado              CHAR(1) NOT NULL DEFAULT('A') CHECK(Estado IN ('A', 'X')),
    FechaCreacion       DATETIME NOT NULL DEFAULT(datetime('now', 'localtime'))
);

CREATE TABLE AJRegiones(
    idAJRegion          INTEGER PRIMARY KEY AUTOINCREMENT,
    NombreRegion        VARCHAR(50) NOT NULL UNIQUE,
    idPais              INTEGER NOT NULL,
    Estado              CHAR(1) NOT NULL DEFAULT('A') CHECK(Estado IN ('A', 'X')),
    FechaCreacion       DATETIME NOT NULL DEFAULT(datetime('now', 'localtime')),
    CONSTRAINT          fk_Pais FOREIGN KEY(idPais) REFERENCES AJPaises(idAJPais)
);

CREATE TABLE AJProvincias(
    idAJProvincia       INTEGER PRIMARY KEY AUTOINCREMENT,
    NombreProvincia     VARCHAR(50) NOT NULL UNIQUE,
    idRegion            INTEGER NOT NULL,
    Estado              CHAR(1) NOT NULL DEFAULT('A') CHECK(Estado IN ('A', 'X')),
    FechaCreacion       DATETIME NOT NULL DEFAULT(datetime('now', 'localtime')),
    CONSTRAINT          fk_Region FOREIGN KEY(idRegion) REFERENCES AJRegiones(idAJRegion)
);

CREATE TABLE AJSexo(
    idAJSexo            INTEGER PRIMARY KEY AUTOINCREMENT,
    NombreSexo          VARCHAR(10) NOT NULL UNIQUE, 
    Estado              CHAR(1) NOT NULL DEFAULT('A') CHECK(Estado IN ('A', 'X')),
    FechaCreacion       DATETIME NOT NULL DEFAULT(datetime('now', 'localtime'))
);

CREATE TABLE AJIngestaNativa(
    idAJIngestaNativa   INTEGER PRIMARY KEY AUTOINCREMENT,
    NombreIngestaNativa VARCHAR(30) NOT NULL UNIQUE,
    Estado              CHAR(1) NOT NULL DEFAULT('A') CHECK(Estado IN ('A', 'X')),
    FechaCreacion       DATETIME NOT NULL DEFAULT(datetime('now', 'localtime'))
);

CREATE TABLE AJGenoAlimento(
    idAJGenoAlimento    INTEGER PRIMARY KEY AUTOINCREMENT,
    NombreGenoAlimento  VARCHAR(10) NOT NULL UNIQUE,
    Estado              CHAR(1) NOT NULL DEFAULT('A') CHECK(Estado IN ('A', 'X')),
    FechaCreacion       DATETIME NOT NULL DEFAULT(datetime('now', 'localtime'))
);

CREATE TABLE AJTipoAlimento(
    idAJTipoAlimento    INTEGER PRIMARY KEY AUTOINCREMENT,
    TipoAlimento        VARCHAR(20) NOT NULL,
    Estado              CHAR(1) NOT NULL DEFAULT('A') CHECK(Estado IN ('A', 'X')),
    FechaCreacion       DATETIME NOT NULL DEFAULT(datetime('now', 'localtime')) 
);

CREATE TABLE AJAlimento(
    idAJAlimento        INTEGER PRIMARY KEY AUTOINCREMENT,
    NombreAlimento      VARCHAR(20) NOT NULL UNIQUE,
    idTipoAlimento      INTEGER NOT NULL,
    CONSTRAINT          fk_TipoAlimento FOREIGN KEY (idTipoAlimento) REFERENCES AJTipoAlimento(idAJTipoAlimento)
);

CREATE TABLE AJHormigas(
    idAJHormiga         INTEGER PRIMARY KEY AUTOINCREMENT,
    TipoHormiga         VARCHAR(50) NOT NULL UNIQUE,
    idSexo              INTEGER NOT NULL,
    idProvincia         INTEGER NOT NULL,
    idGenoAlimento      INTEGER NOT NULL,
    idIngestaNativa     INTEGER NOT NULL,
    Estado              CHAR(1) DEFAULT('A') CHECK(Estado IN ('A', 'X')),
    FechaCreacion       DATETIME NOT NULL DEFAULT(datetime('now', 'localtime')),
    CONSTRAINT          fk_Sexo FOREIGN KEY (idSexo) REFERENCES AJSexo(idAJSexo),
    CONSTRAINT          fk_Provincia FOREIGN KEY (idProvincia) REFERENCES AJProvincias(idAJProvincia),
    CONSTRAINT          fk_GenoAlimento FOREIGN KEY (idGenoAlimento) REFERENCES AJGenoAlimento(idAJGenoAlimento),
    CONSTRAINT          fk_IngestaNativa FOREIGN KEY (idIngestaNativa) REFERENCES AJIngestaNativa(idAJIngestaNativa)
);