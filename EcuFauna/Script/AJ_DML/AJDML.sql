-- database: ../../DataBase/AJDataBase.sqlite

INSERT INTO AJPaises
    (NombrePais) VALUES
    ('ECUADOR');

INSERT INTO AJRegiones
    (NombreRegion, idPais) VALUES
    ('COSTA', 1),
    ('SIERRA', 1),
    ('ORIENTE', 1),
    ('GALAPAGOS', 1);

INSERT INTO AJProvincias
    (NombreProvincia, idRegion) VALUES
    ('ESMERALDAS',                      1),
    ('MANABI',                          1),
    ('SANTO DOMINGO DE LOS TSACHILAS',  1),
    ('LOS RIOS',                        1),
    ('SANTA ELENA',                     1),
    ('GUAYAS',                          1),
    ('EL ORO',                          1),
    ('CARCHI',                          2),
    ('IMBABURA',                        2),
    ('PICHINCHA',                       2),
    ('COTOPAXI',                        2),
    ('TUNGURAHUA',                      2),
    ('BOLIVAR',                         2),
    ('CHIMBORAZO',                      2),
    ('CAÑAR',                           2),
    ('AZUAY',                           2),
    ('LOJA',                            2),
    ('SUCUMBIOS',                       3),
    ('ORELLANA',                        3),
    ('NAPO',                            3),
    ('PASTAZA',                         3),
    ('MORONA SANTIAGO',                 3),
    ('ZAMORA CHIMCHIPE',                3),
    ('GALAPAGOS',                       4);

INSERT INTO AJIngestaNativa
    (NombreIngestaNativa) VALUES 
    ('CARNIVORO'),
    ('HERBIVORO'),
    ('OMNIVORO'),
    ('INSECTIVORO');

INSERT INTO AJGenoAlimento
    (NombreGenoAlimento) VALUES 
    ('X'),
    ('XX'),
    ('XY');

INSERT INTO AJSexo
    (NombreSexo) VALUES 
    ('MACHO'),
    ('HEMBRA'),
    ('ASEXUAL');

INSERT INTO AJTipoAlimento
    (TipoAlimento) VALUES 
    ('GenoAlimento'),
    ('IngestaNativa');


SELECT NombreGenoAlimento, FechaCreacion FROM AJGenoAlimento WHERE idAJGenoAlimento > 0;

SELECT idAJProvincia, NombreProvincia, idRegion, FechaCreacion FROM AJProvincias 
        JOIN AJRegiones
        WHERE Estado LIKE 'A' ;

SELECT P.idAJProvincia, P.NombreProvincia, R.NombreRegion, PA.NombrePais FROM AJProvincias P 
        JOIN AJRegiones R ON P.idRegion = R.idAJRegion
        JOIN AJPaises PA ON R.idPais = PA.idAJPais
        WHERE P.Estado LIKE 'A' AND R.Estado LIKE 'A' AND PA.Estado LIKE 'A';

SELECT P.NombreProvincia, R.NombreRegion, PA.NombrePais FROM AJProvincias P  
        JOIN AJRegiones R ON P.idRegion = R.idAJRegion 
        JOIN AJPaises PA ON R.idPais = PA.idAJPais 
        WHERE P.Estado LIKE 'A' AND R.Estado LIKE 'A' AND PA.Estado LIKE 'A' AND idAJProvincia =   21;

SELECT H.TipoHormiga, S.NombreSexo, P.NombreProvincia, G.NombreGenoAlimento, I.NombreIngestaNativa, H.FechaCreacion
        FROM AJHormigas H
        JOIN AJSexo S ON H.idSexo = S.idAJSexo
        JOIN AJProvincias P ON H.idProvincia = P.idAJProvincia
        JOIN AJGenoAlimento G ON H.idGenoAlimento = G.idAJGenoAlimento 
        JOIN AJIngestaNativa I ON H.idIngestaNativa = I.idAJIngestaNativa 
        WHERE H.Estado LIKE 'A' AND S.Estado  LIKE 'A' AND P.Estado LIKE 'A' AND G.Estado LIKE 'A' AND I.Estado LIKE 'A';
SELECT H.TipoHormiga, S.NombreSexo, P.NombreProvincia, G.NombreGenoAlimento, I.NombreIngestaNativa, H.FechaCreacion
        FROM AJHormigas H
        JOIN AJSexo S ON H.idSexo = S.idAJSexo
        JOIN AJProvincias P ON H.idProvincia = P.idAJProvincia
        JOIN AJGenoAlimento G ON H.idGenoAlimento = G.idAJGenoAlimento 
        JOIN AJIngestaNativa I ON H.idIngestaNativa = I.idAJIngestaNativa 
        WHERE H.Estado LIKE 'A' AND S.Estado  LIKE 'A' AND P.Estado LIKE 'A' AND G.Estado LIKE 'A' AND I.Estado LIKE 'A' AND idAJHormiga = 1;

SELECT * FROM AJHormigas;
INSERT INTO AJHormigas
    (TipoHormiga, idSexo, idProvincia, idGenoAlimento, idIngestaNativa) VALUES
    ('Hormiga', 1, 10, 3, 3);