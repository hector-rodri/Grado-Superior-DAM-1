CREATE TABLE EDITORIAL(
    ID number generated as identity primary key,
    nom varchar2(50)
);

CREATE TABLE LLIBRE (
    ID number generated as identity primary key,
    titol varchar2(50),
    an number,
    exemplars number,
    ID_editorial number NOT NULL,
    ID_sequela_de number,
    foreign key (ID_editorial) references EDITORIAL(ID),
    foreign key (ID_sequela_de) references LLIBRE(ID)
);

CREATE TABLE AUTOR (
    ID number generated as identity primary key,
    nom varchar2(50),
    cognoms varchar2(50),
    data_naix date,
    nacionalitat varchar2(3)
);

CREATE TABLE AUTOR_LLIBRE(
    ID_autor number,
    ID_llibre number,
    primary key(ID_autor, ID_llibre),
    foreign key (ID_autor) references AUTOR(ID),
    foreign key (ID_llibre) references LLIBRE(ID)
);

CREATE TABLE GENERE(
    nom varchar2(50) primary key
);

CREATE TABLE LLIBRE_GENERE(
    ID_llibre number,
    nom_genere varchar2(50),
    foreign key (ID_llibre) references LLIBRE(ID),
    foreign key (nom_genere) references GENERE(nom),
    primary key (ID_llibre, nom_genere)
);

INSERT INTO EDITORIAL (nom) VALUES ('LaButxaca');
INSERT INTO EDITORIAL (nom) VALUES ('Letras hispánicas');
INSERT INTO EDITORIAL (nom) VALUES ('Planeta');
INSERT INTO EDITORIAL (nom) VALUES ('Anaya');

INSERT INTO GENERE VALUES ('Misteri');
INSERT INTO GENERE VALUES ('Poesia');
INSERT INTO GENERE VALUES ('Fantasia');
INSERT INTO GENERE VALUES ('Aventura');
INSERT INTO GENERE VALUES ('Filosofia');

INSERT INTO AUTOR(nom, cognoms, data_naix, nacionalitat) VALUES ('Federico', 'García Lorca', DATE'1898-06-05', 'ESP');
INSERT INTO AUTOR(nom, cognoms, data_naix, nacionalitat) VALUES ('Manuel', 'de Pedrolo i Molina', DATE'1918-04-01', 'ESP');
INSERT INTO AUTOR(nom, cognoms, data_naix, nacionalitat) VALUES ('Joanne', 'Rowling', DATE'1965-07-31', 'GBR');
INSERT INTO AUTOR(nom, cognoms, data_naix, nacionalitat) VALUES ('Stephen', 'King', DATE'1947-09-21', 'USA');
INSERT INTO AUTOR(nom, cognoms, data_naix, nacionalitat) VALUES ('Owen', 'King', DATE'1977-02-21', 'USA');
INSERT INTO AUTOR(nom, cognoms, data_naix, nacionalitat) VALUES ('Shigeru', 'Miyamoto', DATE'1952-09-16', 'JPN');
INSERT INTO AUTOR(nom, cognoms, data_naix, nacionalitat) VALUES ('Hidetaka', 'Miyazaki', DATE'1974-09-19', 'JPN');

INSERT INTO LLIBRE(titol, an, exemplars, id_editorial) VALUES ('Bodas de sangre', 1933, 10, (SELECT ID FROM EDITORIAL WHERE NOM = 'Letras hispánicas'));
INSERT INTO LLIBRE(titol, an, exemplars, id_editorial) VALUES ('Yerma', 1934, 0, (SELECT ID FROM EDITORIAL WHERE NOM = 'Letras hispánicas'));
INSERT INTO LLIBRE(titol, an, exemplars, id_editorial) VALUES ('La casa de Bernarda Alba', 1936, 12, (SELECT ID FROM EDITORIAL WHERE NOM = 'Letras hispánicas'));
INSERT INTO LLIBRE(titol, an, exemplars, id_editorial) VALUES ('Poeta en Nueva York', 1940, 5, (SELECT ID FROM EDITORIAL WHERE NOM = 'Letras hispánicas'));
INSERT INTO LLIBRE(titol, an, exemplars, id_editorial) VALUES ('Romancero gitano', 1928, 1, (SELECT ID FROM EDITORIAL WHERE NOM = 'Letras hispánicas'));
INSERT INTO LLIBRE(titol, an, exemplars, id_editorial) VALUES ('El Lazarillo de Tormes', 1554, 2, (SELECT ID FROM EDITORIAL WHERE NOM = 'Letras hispánicas'));

INSERT INTO LLIBRE(titol, an, exemplars, id_editorial) VALUES ('Mecanoscrit del segon origen', 1974, 1, (SELECT ID FROM EDITORIAL WHERE NOM = 'LaButxaca'));
INSERT INTO LLIBRE(titol, an, exemplars, id_editorial) VALUES ('Totes les bèsties de càrrega', 1965, 5, (SELECT ID FROM EDITORIAL WHERE NOM = 'LaButxaca'));
INSERT INTO LLIBRE(titol, an, exemplars, id_editorial) VALUES ('Joc brut', 1965, 2, (SELECT ID FROM EDITORIAL WHERE NOM = 'LaButxaca'));
INSERT INTO LLIBRE(titol, an, exemplars, id_editorial) VALUES ('Trajecte final', 1981, 6, (SELECT ID FROM EDITORIAL WHERE NOM = 'LaButxaca'));
INSERT INTO LLIBRE(titol, an, exemplars, id_editorial) VALUES ('Es vessa una sang fàcil', 1954, 5, (SELECT ID FROM EDITORIAL WHERE NOM = 'LaButxaca'));

INSERT INTO LLIBRE(titol, an, exemplars, id_editorial) VALUES ('Harry Potter i la pedra filosofal', 1997, 0, (SELECT ID FROM EDITORIAL WHERE NOM = 'Planeta'));
INSERT INTO LLIBRE(titol, an, exemplars, id_editorial, id_sequela_de) VALUES ('Harry Potter i la cambra secreta', 1998, 7, (SELECT ID FROM EDITORIAL WHERE NOM = 'Planeta'), (SELECT ID FROM LLIBRE WHERE TITOL = 'Harry Potter i la pedra filosofal'));
INSERT INTO LLIBRE(titol, an, exemplars, id_editorial, id_sequela_de) VALUES ('Harry Potter i el pres d''Azkaban', 1999, 6, (SELECT ID FROM EDITORIAL WHERE NOM = 'Planeta'), (SELECT ID FROM LLIBRE WHERE TITOL = 'Harry Potter i la cambra secreta'));
INSERT INTO LLIBRE(titol, an, exemplars, id_editorial, id_sequela_de) VALUES ('Harry Potter i el calze de foc', 2000, 5, (SELECT ID FROM EDITORIAL WHERE NOM = 'Planeta'), (SELECT ID FROM LLIBRE WHERE TITOL = 'Harry Potter i el pres d''Azkaban'));
INSERT INTO LLIBRE(titol, an, exemplars, id_editorial, id_sequela_de) VALUES ('Harry Potter i l''orde del Fènix', 2003, 4, (SELECT ID FROM EDITORIAL WHERE NOM = 'Planeta'), (SELECT ID FROM LLIBRE WHERE TITOL = 'Harry Potter i el calze de foc'));
INSERT INTO LLIBRE(titol, an, exemplars, id_editorial) VALUES ('Bellas durmientes', 2017, 3, (SELECT ID FROM EDITORIAL WHERE NOM = 'Planeta'));

INSERT INTO AUTOR_LLIBRE SELECT (SELECT id FROM AUTOR WHERE nom = 'Federico'), id FROM LLIBRE WHERE id_editorial = (SELECT id from EDITORIAL WHERE nom = 'Letras hispánicas') and titol != 'El Lazarillo de Tormes';
INSERT INTO AUTOR_LLIBRE SELECT (SELECT id FROM AUTOR WHERE nom = 'Manuel'), id FROM LLIBRE WHERE id_editorial = (SELECT id from EDITORIAL WHERE nom = 'LaButxaca');
INSERT INTO AUTOR_LLIBRE SELECT (SELECT id FROM AUTOR WHERE nom = 'Joanne'), id FROM LLIBRE WHERE id_editorial = (SELECT id from EDITORIAL WHERE nom = 'Planeta') and titol LIKE 'Harry%';
INSERT INTO AUTOR_LLIBRE SELECT (SELECT id FROM AUTOR WHERE nom = 'Stephen'), id FROM LLIBRE WHERE id_editorial = (SELECT id from EDITORIAL WHERE nom = 'Planeta') and titol NOT LIKE 'Harry%';
INSERT INTO AUTOR_LLIBRE SELECT (SELECT id FROM AUTOR WHERE nom = 'Owen'), id FROM LLIBRE WHERE id_editorial = (SELECT id from EDITORIAL WHERE nom = 'Planeta') and titol NOT LIKE 'Harry%';

INSERT INTO LLIBRE_GENERE SELECT id_llibre, 'Poesia' FROM AUTOR_LLIBRE WHERE id_autor = (SELECT id FROM AUTOR WHERE NOM = 'Federico');
INSERT INTO LLIBRE_GENERE SELECT id_llibre, 'Fantasia' FROM AUTOR_LLIBRE WHERE id_autor = (SELECT id FROM AUTOR WHERE NOM = 'Joanne');
INSERT INTO LLIBRE_GENERE SELECT id_llibre, 'Aventura' FROM AUTOR_LLIBRE WHERE id_autor = (SELECT id FROM AUTOR WHERE NOM = 'Manuel') AND rownum < 3;
INSERT INTO LLIBRE_GENERE SELECT id_llibre, 'Misteri' FROM AUTOR_LLIBRE WHERE id_autor = (SELECT id FROM AUTOR WHERE NOM = 'Manuel') AND id_llibre not in (SELECT id_llibre FROM LLIBRE_GENERE);

DELETE FROM LLIBRE_GENERE WHERE id_llibre = (SELECT ID FROM LLIBRE WHERE TITOL = 'Totes les bèsties de càrrega');
DELETE FROM LLIBRE_GENERE WHERE id_llibre = (SELECT ID FROM LLIBRE WHERE TITOL = 'Harry Potter i el calze de foc');
DELETE FROM LLIBRE_GENERE WHERE id_llibre = (SELECT ID FROM LLIBRE WHERE TITOL = 'Bellas durmientes');

--PRACTICA SIN JOIN
SELECT NOM, TITOL FROM EDITORIAL,LLIBRE WHERE EDITORIAL.ID = LLIBRE.ID;

SELECT NOM, TITOL FROM EDITORIAL,LLIBRE WHERE EDITORIAL.ID = LLIBRE.ID AND EDITORIAL.NOM != 'Planeta';

SELECT LL.TITOL, AU.NOM FROM LLIBRE LL, AUTOR AU, AUTOR_LLIBRE AULL WHERE LL.ID= AULL.ID_LLIBRE AND AU.ID= AULL.ID_AUTOR;

SELECT LL.TITOL, AU.NOM FROM LLIBRE LL, AUTOR AU, AUTOR_LLIBRE AULL WHERE LL.ID= AULL.ID_LLIBRE AND AU.ID= AULL.ID_AUTOR AND LL.AN < 1950;

--PRACTICA CON JOIN
SELECT NOM, TITOL FROM LLIBRE L JOIN EDITORIAL E ON E.ID = L.ID;

SELECT NOM, TITOL FROM LLIBRE L JOIN EDITORIAL E ON E.ID = L.ID AND E.NOM != 'Planeta';

SELECT NOM,TITOL FROM LLIBRE L
    JOIN AUTOR_LLIBRE AL ON L.ID = AL.ID_LLIBRE
    JOIN AUTOR A ON A.ID = AL.ID_AUTOR;

SELECT NOM,TITOL FROM LLIBRE L
    JOIN AUTOR_LLIBRE AL ON L.ID = AL.ID_LLIBRE
    JOIN AUTOR A ON A.ID = AL.ID_AUTOR
    AND L.AN < 1950;

SELECT G.NOM FROM GENERE G
    LEFT JOIN LLIBRE_GENERE LG ON G.NOM = LG.NOM_GENERE
    WHERE LG.NOM_GENERE IS NULL;

SELECT DISTINCT G.NOM FROM GENERE G
    JOIN LLIBRE_GENERE LG ON G.NOM = LG.NOM_GENERE;

--Sense JOIN
--1. Llista els llibres (títol) amb el seu gènere (nom).
SELECT LL.TITOL, LLGE.NOM_GENERE FROM LLIBRE LL, LLIBRE_GENERE LLGE WHERE  LLGE.ID_LLIBRE = LL.ID;
--2. Llista els títols i autor (nom i llinatge) dels llibres d'autors espanyols.
SELECT LL.TITOL, AU.NOM, AU.COGNOMS FROM LLIBRE LL, AUTOR AU, AUTOR_LLIBRE AULL WHERE AU.NACIONALITAT = 'ESP' AND LL.ID = AULL.ID_LLIBRE AND AU.ID = AULL.ID_AUTOR;
--3. Llista els títols, el gènere (nom) i l'autor (nom i llinatges) de cada llibre. (Si un llibre té més d'un autor o gènere, el seu títol sortir repetit).
SELECT LL.TITOL, GEN.NOM, AU.NOM, AU.COGNOMS FROM LLIBRE LL, AUTOR AU, GENERE GEN , AUTOR_LLIBRE AULL, LLIBRE_GENERE LLGEN WHERE LL.ID = AULL.ID_LLIBRE AND AU.ID = AULL.ID_AUTOR AND LL.ID = LLGEN.ID_LLIBRE AND GEN.NOM = LLGEN.NOM_GENERE;
--4. Llista els llibres (títol) amb més d'un autor. (Pista: HAVING)
SELECT LL.TITOL FROM LLIBRE LL, AUTOR_LLIBRE AULL WHERE LL.ID = AULL.ID_LLIBRE GROUP BY LL.TITOL HAVING COUNT(AULL.ID_AUTOR) > 1;
--5. Llista el nombre d'exemplars totals de l'autor "Federico García Lorca".
SELECT LL.EXEMPLARS FROM LLIBRE LL, AUTOR AU, AUTOR_LLIBRE AULL WHERE LL.ID = AULL.ID_LLIBRE AND AU.NOM = 'Federico';
--6. Llista el nombre d'exemplars totals de cada autor.
SELECT NOM, COGNOMS, SUM(EXEMPLARS) FROM LLIBRE LL, AUTOR AU, AUTOR_LLIBRE AULL WHERE LL.ID = AULL.ID_LLIBRE AND AULL.ID_AUTOR = AU.ID GROUP BY NOM, COGNOMS;

--Amb JOIN
--1. Llista els autors (nom i llinatges) sense llibres.
SELECT A.NOM, A.COGNOMS FROM AUTOR A
    LEFT JOIN AUTOR_LLIBRE AL ON A.ID = AL.ID_AUTOR
    WHERE AL.ID_AUTOR IS NULL;

--2. Llista els llibres (títol) amb el seu gènere (nom).
SELECT L.TITOL, G.NOM FROM LLIBRE L
    LEFT JOIN LLIBRE_GENERE LG ON L.ID=LG.ID_LLIBRE
	LEFT JOIN GENERE G ON G.NOM = LG.NOM_GENERE;

--3. Llista els llibres (títol) sense gènere.
SELECT L.TITOL FROM LLIBRE L 
    LEFT JOIN LLIBRE_GENERE LG ON L.ID = LG.ID_LLIBRE
	WHERE LG.NOM_GENERE IS NULL;

--4. Llista els llibres (títol) sense autor.
SELECT L.TITOL FROM LLIBRE L
    LEFT JOIN AUTOR_LLIBRE AL ON L.ID = AL.ID_LLIBRE
    WHERE AL.ID_AUTOR IS NULL;

--5. Llista els títols i autor (nom i llinatge) dels llibres d'autors espanyols.
SELECT L.TITOL, A.NOM, A.COGNOMS FROM LLIBRE L
    JOIN AUTOR_LLIBRE AL ON L.ID = AL.ID_LLIBRE
    JOIN AUTOR A ON A.ID = AL.ID_AUTOR
    WHERE A.NACIONALITAT = 'ESP';

--6. Llista els títols, el gènere (nom) i l'autor (nom i llinatges) de cada llibre. (Si un llibre té més d'un autor o gènere, el seu títol sortir repetit). Mostra només els que tenen autor conegut i gènere.
SELECT L.TITOL, G.NOM, A.NOM, A.COGNOMS FROM LLIBRE L
    JOIN AUTOR_LLIBRE AL ON L.ID = AL.ID_LLIBRE
    JOIN AUTOR A ON A.ID = AL.ID_AUTOR
    JOIN LLIBRE_GENERE LG ON L.ID = LG.ID_LLIBRE
    JOIN GENERE G ON G.NOM = LG.NOM_GENERE;

--7. Repeteix la consulta anterior, però també han de poder sortir els llibres sense gènere ni autor.
SELECT TITOL, NOM_GENERE, NOM, COGNOMS FROM LLIBRE L 
    LEFT JOIN LLIBRE_GENERE LG ON L.ID = LG.ID_LLIBRE 
    LEFT JOIN GENERE G ON LG.NOM_GENERE = G.NOM 
    LEFT JOIN AUTOR_LLIBRE AL ON L.ID = AL.ID_LLIBRE 
    LEFT JOIN AUTOR A ON AL.ID_AUTOR = A.ID;

--8. Llista els llibres (títol) amb més d'un autor. (Pista: HAVING)
SELECT TITOL FROM LLIBRE L 
INNER JOIN AUTOR_LLIBRE AL ON L.ID = AL.ID_LLIBRE 
GROUP BY TITOL 
HAVING COUNT(*) > 1;

--9. Llista el nombre d'exemplars totals de l'autor "Federico García Lorca".
SELECT SUM(EXEMPLARS) FROM LLIBRE L 
    INNER JOIN AUTOR_LLIBRE AL ON L.ID = AL.ID_LLIBRE 
    INNER JOIN AUTOR A ON AL.ID_AUTOR = A.ID 
    WHERE A.NOM = 'FEDERICO';

--10. Llista el nombre d'exemplars totals de cada autor.
SELECT NOM, COGNOMS, SUM(EXEMPLARS) FROM LLIBRE L 
    INNER JOIN AUTOR_LLIBRE AL ON L.ID = AL.ID_LLIBRE 
    INNER JOIN AUTOR A ON AL.ID_AUTOR = A.ID 
    GROUP BY NOM, COGNOMS;