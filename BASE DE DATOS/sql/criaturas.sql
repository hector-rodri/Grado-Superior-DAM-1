Create table Entrenador ( 
	DNI varchar2(9), 
    medalles number, 
    primary key(DNI) 
);

Create table Tipus ( 
    nom varchar2(50), 
	guanya_a varchar2(50),
    primary key(nom),
	foreign key(guanya_a) references Tipus(nom)
);

Create table Especie ( 
    nom varchar2(50), 
    nom_tipus varchar2(50), 
    primary key(nom), 
    foreign key (nom_tipus) references Tipus(nom) 
);

Create table Criatura ( 
    codi number, 
    nom_especie varchar2(50), 
    dni_entrenador varchar2(50), 
    nivell number, 
    nom_propi varchar2(50), 
    primary key(codi), 
    foreign key (dni_entrenador) references Entrenador(DNI), 
    foreign key (nom_especie) references Especie(nom) 
);

Create table Indret ( 
    codi number, 
    tipus_bioma varchar2(50), 
    nom varchar2(50), 
    primary key(codi)
);

Create table Habitat_Especie ( 
    codi_indret number, 
    nom_especie varchar2(50), 
    nivell_max number, 
    nivell_min number, 
    primary key(codi_indret, nom_especie), 
    foreign key (codi_indret) references Indret(codi), 
    foreign key (nom_especie) references Especie(nom) 
);