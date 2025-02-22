CREATE TABLE ALUMNE(
    DNI VARCHAR2(9) PRIMARY KEY,
    nom varchar2(50),
    llinatge1 varchar2(50),
    llinatge2 varchar2(50),
    email varchar2(50)
);

CREATE TABLE PROFESSOR(
    DNI VARCHAR2(9) PRIMARY KEY,
    nom VARCHAR2(50),
    llinatge1 VARCHAR2(50),
    llinatge2 VARCHAR2(50),
    email VARCHAR2(50),
	salari NUMBER
);

CREATE TABLE GRAU(
    ID NUMBER GENERATED AS IDENTITY PRIMARY KEY,
    nom VARCHAR2(50),
    cursos NUMBER
);

CREATE TABLE ASSIGNATURA(
    ID NUMBER GENERATED AS IDENTITY PRIMARY KEY,
    nom VARCHAR2(50),
    id_grau NUMBER,
    pla NUMBER(4),
    dni_professor VARCHAR2(9),
    credits_ects NUMBER(2,0) DEFAULT 6,
    FOREIGN KEY (dni_professor) REFERENCES PROFESSOR(DNI),
    FOREIGN KEY (id_grau) REFERENCES GRAU(ID)
);

CREATE TABLE NOTA(
    ID NUMBER GENERATED AS IDENTITY PRIMARY KEY,
    dni_alumne VARCHAR2(9),
    ID_assignatura NUMBER,
    convocatoria NUMBER(4),
    nota NUMBER,
    FOREIGN KEY (ID_assignatura) REFERENCES ASSIGNATURA(ID),
    FOREIGN KEY (dni_alumne) REFERENCES ALUMNE(DNI),
    UNIQUE(dni_alumne, ID_assignatura, convocatoria)
);

--DADES
-- Inserció d'alumnes
INSERT INTO ALUMNE (DNI, nom, llinatge1, llinatge2, email) VALUES ('12345678A', 'Laura', 'Martí', 'Soler', 'laura.marti@example.com');
INSERT INTO ALUMNE (DNI, nom, llinatge1, llinatge2, email) VALUES ('23456789B', 'Marc', 'Garcia', 'López', 'marc.garcia@example.com');
INSERT INTO ALUMNE (DNI, nom, llinatge1, llinatge2, email) VALUES ('34567890C', 'Anna', 'Puig', 'Casas', 'anna.puig@example.com');
INSERT INTO ALUMNE (DNI, nom, llinatge1, llinatge2, email) VALUES ('45678901D', 'David', 'Ferrer', 'Prat', 'david.ferrer@example.com');
INSERT INTO ALUMNE (DNI, nom, llinatge1, llinatge2, email) VALUES ('56789012E', 'Sara', 'Navarro', 'Vidal', 'sara.navarro@example.com');
INSERT INTO ALUMNE (DNI, nom, llinatge1, llinatge2, email) VALUES ('67890123F', 'Oriol', 'González', 'Moreno', 'oriol.gonzalez@example.com');
INSERT INTO ALUMNE (DNI, nom, llinatge1, llinatge2, email) VALUES ('78901234G', 'Clara', 'Sánchez', 'Molina', 'clara.sanchez@example.com');
INSERT INTO ALUMNE (DNI, nom, llinatge1, llinatge2, email) VALUES ('89012345H', 'Jordi', 'Ruiz', 'Dominguez', 'jordi.ruiz@example.com');
INSERT INTO ALUMNE (DNI, nom, llinatge1, llinatge2, email) VALUES ('90123456I', 'Mireia', 'Blanco', 'Torres', 'mireia.blanco@example.com');
INSERT INTO ALUMNE (DNI, nom, llinatge1, llinatge2, email) VALUES ('01234567J', 'Pau', 'Ortega', 'Castro', 'pau.ortega@example.com');

