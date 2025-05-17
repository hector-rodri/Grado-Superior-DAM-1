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

CREATE OR REPLACE PACKAGE LLIBRES_API AS

    TYPE nested_llibres IS TABLE OF LLIBRE%ROWTYPE;

    llibre_sequela_no_existeix EXCEPTION;
    exemplars_negatius      EXCEPTION;
    editorial_no_existeix   EXCEPTION;

    PROCEDURE alta_llibre(
        v_titol  LLIBRE.titol%TYPE,
        v_any  LLIBRE.an%TYPE,
        v_exemplars  LLIBRE.exemplars%TYPE,
        v_id_editorial  LLIBRE.id_editorial%TYPE,
        v_id_sequela_de  LLIBRE.id_sequela_de%TYPE DEFAULT NULL
    );

    FUNCTION get_llibre_by_id(v_id  LLIBRE.id%TYPE) RETURN LLIBRE%ROWTYPE;

    FUNCTION get_llibres_by_genere(v_genere  GENERE.nom%TYPE) RETURN nested_llibres;
    
    FUNCTION search_by_titol(v_text_usuari  VARCHAR2) RETURN nested_llibres;

END LLIBRES_API;


CREATE OR REPLACE PACKAGE BODY LLIBRES_API AS
    PROCEDURE alta_llibre(
        v_titol          LLIBRE.titol%TYPE,
        v_any            LLIBRE.an%TYPE,
        v_exemplars      LLIBRE.exemplars%TYPE,
        v_id_editorial   LLIBRE.id_editorial%TYPE,
        v_id_sequela_de  LLIBRE.id_sequela_de%TYPE DEFAULT NULL
    ) IS
        v_count NUMBER;
    BEGIN
        IF v_exemplars < 0 THEN
            RAISE exemplars_negatius;
        END IF;

        SELECT COUNT(*) INTO v_count
        FROM EDITORIAL
        WHERE id = v_id_editorial;

        IF v_count = 0 THEN
            RAISE editorial_no_existeix;
        END IF;
        
        IF v_id_sequela_de IS NOT NULL THEN
            SELECT COUNT(*) INTO v_count
            FROM LLIBRE
            WHERE id = v_id_sequela_de;

            IF v_count = 0 THEN
                RAISE llibre_sequela_no_existeix;
            END IF;
        END IF;

        INSERT INTO LLIBRE(titol, an, exemplars, id_editorial, id_sequela_de)
        VALUES (v_titol, v_any, v_exemplars, v_id_editorial, v_id_sequela_de);
    END alta_llibre;


    FUNCTION get_llibre_by_id(v_id LLIBRE.id%TYPE) RETURN LLIBRE%ROWTYPE IS
        v_llibre LLIBRE%ROWTYPE;
    BEGIN
        SELECT * INTO v_llibre
        FROM LLIBRE
        WHERE id = v_id;
        RETURN v_llibre;
    END get_llibre_by_id;

    FUNCTION get_llibres_by_genere(v_genere GENERE.nom%TYPE) RETURN nested_llibres IS
        v_llibres nested_llibres;
    BEGIN
        SELECT l.*
        BULK COLLECT INTO v_llibres
        FROM LLIBRE l
        JOIN LLIBRE_GENERE lg ON l.id = lg.id_llibre
        WHERE lg.nom_genere = v_genere
        ORDER BY l.titol;
        RETURN v_llibres;
    END get_llibres_by_genere;


    FUNCTION search_by_titol(v_text_usuari VARCHAR2) RETURN nested_llibres IS
        v_resultats nested_llibres;
    BEGIN
        SELECT *
        BULK COLLECT INTO v_resultats
        FROM LLIBRE
        WHERE LOWER(titol) LIKE LOWER('%' || v_text_usuari || '%');
        RETURN v_resultats;
    END search_by_titol;
END LLIBRES_API;

CREATE TABLE LLIBRES_LOG(
    ID_LLIBRE NUMBER,
    EJEMPLARES_OLD NUMBER,
    FECHA DATE
);

CREATE OR REPLACE TRIGGER guardar_datos_LLIBRES_LOG
BEFORE UPDATE 
ON LLIBRE 
FOR EACH ROW
BEGIN
    IF (:NEW.exemplars != :OLD.exemplars) THEN
    INSERT INTO LLIBRES_LOG(ID_LLIBRE,EJEMPLARES_OLD,FECHA) VALUES (:OLD.ID,:OLD.exemplars,SYSDATE);
    END IF;
END;