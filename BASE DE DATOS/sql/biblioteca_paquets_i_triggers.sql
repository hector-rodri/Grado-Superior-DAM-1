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

    FUNCTION get_llibres_by_editorial(v_id_editorial llibre.id_editorial%type) RETURN nested_llibres;

    FUNCTION get_llibre_by_id(v_id  LLIBRE.id%TYPE) RETURN LLIBRE%ROWTYPE;

    FUNCTION get_llibres_by_genere(v_genere  GENERE.nom%TYPE) RETURN nested_llibres;
    
    FUNCTION search_by_titol(v_text_usuari  VARCHAR2) RETURN nested_llibres;

END LLIBRES_API;


CREATE OR REPLACE PACKAGE BODY LLIBRES_API AS

    FUNCTION get_llibres_by_editorial(v_id_editorial llibre.id_editorial%type) RETURN nested_llibres
    IS
    v_aux nested_llibres;
    BEGIN
    SELECT * BULK COLLECT INTO v_aux FROM LLIBRE WHERE id_editorial = v_id_editorial;
    RETURN v_aux;
    END get_llibres_by_editorial;

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

--TRIGGERS

-- 1. Crea un trigger de manera que qualsevol llibre amb exemplars negatius que s'introdueixi quedi a 0 exemplars

CREATE OR REPLACE TRIGGER exemplars_negatius
BEFORE INSERT
ON LLIBRE
FOR EACH ROW
BEGIN
    IF (:NEW.exemplars < 0) THEN
    :NEW.exemplars := 0;
    END IF;
END;

-- 2. Crea un trigger que asseguri que totes les editorials que s'introdueixin tenguin el nom en majúscula

CREATE OR REPLACE TRIGGER editorial_mayus
BEFORE INSERT OR UPDATE
ON EDITORIAL
FOR EACH ROW
BEGIN
    :NEW.NOM := UPPER(:NEW.NOM);
END;

/*3. Crea un trigger que s'activi si s'introdueix un llibre sense editorial, 
de manera que al llibre se li assigni qualsevol editorial de la base de dades.*/

CREATE OR REPLACE TRIGGER llibre_sense_editorial
BEFORE INSERT 
ON LLIBRE 
FOR EACH ROW
DECLARE
    v_id_editorial NUMBER;
BEGIN
    IF (:NEW.ID_editorial IS NULL) THEN
    SELECT ID INTO v_id_editorial FROM EDITORIAL FETCH FIRST ROW ONLY;
    :NEW.ID_editorial := v_id_editorial;
    END IF;
END;

/*4. Crea un trigger que faci que, quan s'introdueix un llibre amb seqüela a LLIBRES,
es copiin automàticament l'autor i gèneres del llibre anterior.*/

CREATE OR REPLACE TRIGGER copiar_datos_secuela
AFTER INSERT 
ON LLIBRE
FOR EACH ROW
DECLARE
    v_autor_secuela VA
BEGIN
    IF (:NEW.ID_sequela_de IS NOT NULL) THEN
        FOR gen IN (SELECT nom_genere FROM LLIBRE_GENERE WHERE id_llibre = :NEW.ID_sequela_de) LOOP
			INSERT INTO LLIBRE_GENERE(id_llibre, nom_genere) VALUES (:NEW.ID, gen.nom_genere);
		END LOOP;
        FOR aut IN (SELECT id_autor FROM AUTOR_LLIBRE WHERE id_llibre = :NEW.ID_sequela_de) LOOP
			INSERT INTO AUTOR_LLIBRE(id_autor, id_llibre) VALUES (aut.id_autor, :NEW.ID);
		END LOOP;
    END IF;
END;


/*5. Crea un trigger que faci que, quan s'introdueix l'autor d'un llibre que encara no té gènere,
s'introduexi automàticament el gènere més freqüent d'aquell autor.*/
CREATE OR REPLACE TRIGGER trg_afegir_genere_frequent
BEFORE INSERT ON AUTOR_LLIBRE
FOR EACH ROW
DECLARE
    v_max_count NUMBER := 0;
    v_max_genere VARCHAR2(50);
    v_aux NUMBER := 0;
BEGIN
    SELECT COUNT(*) INTO v_aux
    FROM LLIBRE_GENERE
    WHERE ID_llibre = :NEW.ID_llibre;

    IF v_aux = 0 THEN
        FOR r IN (
            SELECT LG.nom_genere, COUNT(*) AS total
            FROM AUTOR_LLIBRE AL
            JOIN LLIBRE_GENERE LG ON AL.ID_llibre = LG.ID_llibre
            WHERE AL.ID_autor = :NEW.ID_autor
            GROUP BY LG.nom_genere
        ) LOOP
            IF r.total > v_max_count THEN
                v_max_count := r.total;
                v_max_genere := r.nom_genere;
            END IF;
        END LOOP;

        IF v_max_count > 0 THEN
            INSERT INTO LLIBRE_GENERE (ID_llibre, nom_genere)
            VALUES (:NEW.ID_llibre, v_max_genere);
        END IF;
    END IF;
END;

INSERT INTO LLIBRE(titol, an, exemplars, id_editorial, id_sequela_de)
VALUES (
    'sadfrt',
    2007,
    5,
    (SELECT ID FROM EDITORIAL WHERE NOM = 'Planeta'),''
);
INSERT INTO AUTOR_LLIBRE(ID_AUTOR, ID_LLIBRE) VALUES (2, (SELECT MAX(ID) FROM LLIBRE)); --Posar autor Manuel de Pedrolo


CREATE OR REPLACE PACKAGE AUTORS_API AS
    TYPE autores_registros AS TABLE OF AUTOR%ROWTYPE;
    FUNCTION get_autors_by_nacionalitat(v_autor_nacionalitat AUTOR.nacionalitat%type) RETURN autores_registros;
END AUTORS_API;

CREATE OR REPLACE PACKAGE BODY AUTORS_API AS
    FUNCTION get_autors_by_nacionalitat(v_autor_nacionalitat AUTOR.nacionalitat%type) RETURN autores_registros
    IS
    v_aux autores_registros;
    BEGIN
    SELECT * BULK COLLECT INTO v_aux FROM AUTOR WHERE nacionalitat = v_autor_nacionalitat;
    RETURN v_aux;
    END;
END AUTORS_API;
-- === APUNTS BÀSICS DE PL/SQL PER L'EXAMEN ===

-- Bloc bàsic
BEGIN
  -- instruccions
EXCEPTION
  WHEN error THEN
    -- gestió d'error
END;
/

-- IF-THEN
IF condició THEN
  -- acció
END IF;

-- Bucle FOR sobre col·lecció
FOR i IN 1..coleccio.COUNT LOOP
  -- accions
END LOOP;

-- Output
DBMS_OUTPUT.PUT_LINE('Text');

-- WHILE loop
i := 1;
WHILE i <= v_exemple.COUNT LOOP
  DBMS_OUTPUT.PUT_LINE(v_exemple(i).titol);
  i := i + 1;
END LOOP;


-- === SUBPROGRAMES ===

-- PROCEDURE: executa codi
-- FUNCTION: executa codi i retorna un valor

-- NESTED PROCEDURE (dins bloc anònim)
DECLARE
  PROCEDURE mostra_hola IS
  BEGIN
    DBMS_OUTPUT.PUT_LINE('Hola!');
  END;
BEGIN
  mostra_hola;
END;
/

-- STANDALONE PROCEDURE
CREATE OR REPLACE PROCEDURE mostra_data IS
BEGIN
  DBMS_OUTPUT.PUT_LINE('Avui és: ' || SYSDATE);
END;
/

-- STANDALONE FUNCTION
CREATE OR REPLACE FUNCTION doble_valor(num NUMBER)
RETURN NUMBER IS
BEGIN
  RETURN num * 2;
END;
/

-- Eliminar subprogrames
-- DROP PROCEDURE mostra_data;
-- DROP FUNCTION doble_valor;


-- === PARÀMETRES DE SUBPROGRAMES ===
-- nom_parametre [IN | OUT | IN OUT] tipus

-- Exemple:
-- PROCEDURE exemple(par1 IN NUMBER, par2 OUT NUMBER)
-- par1 entra valor, par2 retorna valor


-- === EXECUCIÓ DE PROCEDURES / FUNCTIONS ===
-- dins bloc: nom_proc(par1);
-- o: EXECUTE nom_proc(par1);

-- === PAQUETS ===

-- SPEC
CREATE OR REPLACE PACKAGE paquet_util IS
  PROCEDURE hola;
  FUNCTION doble(num NUMBER) RETURN NUMBER;
END paquet_util;
/

-- BODY
CREATE OR REPLACE PACKAGE BODY paquet_util IS
  PROCEDURE hola IS
  BEGIN
    DBMS_OUTPUT.PUT_LINE('Hola des del paquet!');
  END;

  FUNCTION doble(num NUMBER) RETURN NUMBER IS
  BEGIN
    RETURN num * 2;
  END;
END paquet_util;
/

-- Crida: paquet_util.hola;
--        paquet_util.doble(5);


-- === CURSORS ===

-- Cursor simple amb bucle FOR
DECLARE
  CURSOR c_llibres IS
    SELECT titol FROM LLIBRE;

BEGIN
  FOR llibre IN c_llibres LOOP
    DBMS_OUTPUT.PUT_LINE('Títol: ' || llibre.titol);
  END LOOP;
END;
/

-- === TRIGGERS ===

-- Trigger bàsic BEFORE INSERT
CREATE OR REPLACE TRIGGER trigger_insercio
BEFORE INSERT ON LLIBRE
FOR EACH ROW
BEGIN
  DBMS_OUTPUT.PUT_LINE('Inserint nou llibre...');
END;
/

-- Exemple pràctic: evitar valors negatius
CREATE OR REPLACE TRIGGER evitar_exemplars_negatius
BEFORE INSERT OR UPDATE ON LLIBRE
FOR EACH ROW
BEGIN
  IF :NEW.exemplars < 0 THEN
    RAISE_APPLICATION_ERROR(-20001, 'No es permeten exemplars negatius!');
  END IF;
END;
/

-- AFTER / BEFORE → quan s'executa.
-- FOR EACH ROW → per cada fila afectada.
-- :NEW.camp → accés al nou valor.
-- :OLD.camp → accés al valor anterior.