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
    ('INSECTIVORO'),
    ('NECTARIVOROS');

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

SELECT P.idAJProvincia, P.NombreProvincia, R.NombreRegion, PA.NombrePais FROM AJProvincias P 
        JOIN AJRegiones R ON P.idRegion = R.idAJRegion
        JOIN AJPaises PA ON R.idPais = PA.idAJPais
        WHERE P.Estado LIKE 'VIVO' AND R.Estado LIKE 'VIVO' AND PA.Estado LIKE 'VIVO';

SELECT P.NombreProvincia, R.NombreRegion, PA.NombrePais FROM AJProvincias P  
        JOIN AJRegiones R ON P.idRegion = R.idAJRegion 
        JOIN AJPaises PA ON R.idPais = PA.idAJPais 
        WHERE P.Estado LIKE 'VIVO' AND R.Estado LIKE 'VIVO' AND PA.Estado LIKE 'VIVO' AND idAJProvincia =   21;

SELECT H.TipoHormiga, S.NombreSexo, P.NombreProvincia, G.NombreGenoAlimento, I.NombreIngestaNativa, H.FechaCreacion
        FROM AJHormigas H
        JOIN AJSexo S ON H.idSexo = S.idAJSexo
        JOIN AJProvincias P ON H.idProvincia = P.idAJProvincia
        JOIN AJGenoAlimento G ON H.idGenoAlimento = G.idAJGenoAlimento 
        JOIN AJIngestaNativa I ON H.idIngestaNativa = I.idAJIngestaNativa 
        WHERE H.Estado LIKE 'VIVO' AND S.Estado  LIKE 'VIVO' AND P.Estado LIKE 'VIVO' AND G.Estado LIKE 'VIVO' AND I.Estado LIKE 'VIVO';
SELECT H.TipoHormiga, S.NombreSexo, P.NombreProvincia, G.NombreGenoAlimento, I.NombreIngestaNativa, H.FechaCreacion
        FROM AJHormigas H
        JOIN AJSexo S ON H.idSexo = S.idAJSexo
        JOIN AJProvincias P ON H.idProvincia = P.idAJProvincia
        JOIN AJGenoAlimento G ON H.idGenoAlimento = G.idAJGenoAlimento 
        JOIN AJIngestaNativa I ON H.idIngestaNativa = I.idAJIngestaNativa 
        WHERE H.Estado LIKE 'VIVO' AND S.Estado  LIKE 'VIVO' AND P.Estado LIKE 'VIVO' AND G.Estado LIKE 'VIVO' AND I.Estado LIKE 'VIVO' AND idAJHormiga = 1;

SELECT * FROM AJHormigas;
INSERT INTO AJHormigas
    (TipoHormiga, idSexo, idProvincia, idGenoAlimento, idIngestaNativa) VALUES
    ('Hormiga', 1, 10, 3, 3);

INSERT INTO AJHormigas (TipoHormiga, idSexo, idProvincia, idGenoAlimento, idIngestaNativa, Estado)
VALUES ('av', 1, 2, 3, 4, 'VIVO');

SELECT H.TipoHormiga, S.NombreSexo, P.NombreProvincia, G.NombreGenoAlimento, I.NombreIngestaNativa, H.FechaCreacion
 FROM AJHormigas H
 JOIN AJSexo S ON H.idSexo = S.idAJSexo
 JOIN AJProvincias P ON H.idProvincia = P.idAJProvincia
 JOIN AJGenoAlimento G ON H.idGenoAlimento = G.idAJGenoAlimento 
 JOIN AJIngestaNativa I ON H.idIngestaNativa = I.idAJIngestaNativa 
 WHERE H.Estado LIKE 'VIVO' AND S.Estado  LIKE 'VIVO' AND P.Estado LIKE 'VIVO' AND G.Estado LIKE 'VIVO' AND I.Estado LIKE 'VIVO' AND idAJHormiga = 1;


 INSERT INTO AJHormigas 
                        (TipoHormiga, idSexo, idProvincia) VALUES ('larva', 'asexual', 'quito');

INSERT INTO AJHormigas 
    (TipoHormiga, idSexo, idProvincia) VALUES 
    ('larva', 3, 4); 

SELECT P.idAJProvincia, P.NombreProvincia, R.NombreRegion, PA.NombrePais FROM AJProvincias P  
 JOIN AJRegiones R ON P.idRegion = R.idAJRegion 
 JOIN AJPaises PA ON R.idPais = PA.idAJPais 
 WHERE P.Estado LIKE 'VIVO' AND R.Estado LIKE 'VIVO' AND PA.Estado LIKE 'VIVO' AND idAJProvincia =  1;

 SELECT H.idAJHormiga, H.TipoHormiga, P.NombreProvincia, S.NombreSexo, H.FechaCreacion
 FROM AJHormigas H 
 JOIN AJSexo S ON H.idSexo = S.idAJSexo 
 JOIN AJProvincias P ON H.idProvincia = P.idAJProvincia 
 WHERE H.Estado LIKE 'VIVO' AND S.Estado  LIKE 'VIVO' AND P.Estado LIKE 'VIVO'  AND idAJHormiga = 1;

SELECT H.idAJHormiga, H.TipoHormiga, P.NombreProvincia, S.NombreSexo, G.NombreGenoAlimento, I.NombreIngestaNativa, H.FechaCreacion
FROM AJHormigas H
JOIN AJSexo S ON H.idSexo = S.idAJSexo
JOIN AJProvincias P ON H.idProvincia = P.idAJProvincia
LEFT JOIN AJGenoAlimento G ON H.idGenoAlimento = G.idAJGenoAlimento AND G.Estado LIKE 'VIVO'
LEFT JOIN AJIngestaNativa I ON H.idIngestaNativa = I.idAJIngestaNativa AND I.Estado LIKE 'VIVO'
WHERE H.Estado LIKE 'VIVO' 
  AND S.Estado LIKE 'VIVO' 
  AND P.Estado LIKE 'VIVO' 
  AND idAJHormiga = 1;
