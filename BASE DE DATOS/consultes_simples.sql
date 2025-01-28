create table llibres(
  codi number generated as identity,
  titol varchar(60) not null,
  autor varchar(30),
  editorial varchar(15),
  preu number(5,2),
  primary key (codi)
);

insert into llibres (titol, autor, editorial, preu) values('El principito','Antonine de Saint','Planeta',15);
insert into llibres (titol, autor, editorial, preu) values('La Cocinera de Castamar','Fernando J. Múñez','Planeta',40);
insert into llibres (titol, autor, editorial, preu) values('Yerma','Federico García Lorca','Planeta',40);
insert into llibres (titol, autor, editorial, preu) values('Cómo hacer que te pasen cosas buenas','Marián Rojas','Espasa',18.20);
insert into llibres (titol, autor, editorial, preu) values('Mecanoscrit del segon origen','Manuel de Pedrolo','Espasa',15);
insert into llibres (titol, autor, editorial, preu) values('Magia y enigma','Henry Kamen','Espasa',22.20);
insert into llibres (titol, autor, editorial, preu) values('Matilda','Roald Dahl','Alfaguara',36.40);
insert into llibres (titol, autor, editorial, preu) values('Momo', 'Michael Ende', 'Alfaguara',30.80);
insert into llibres (titol, autor, editorial, preu) values('Mujercitas','Louisa May Alcott','Alfaguara',45.00);
insert into llibres (titol, autor, editorial, preu) values('La historia interminable','Michael Ende','Alfaguara',46.00);
insert into llibres (titol, autor, editorial, preu) values('Peter Pan','J.M. Barrie','Alfaguara',null);

select * from llibres;
--1
select editorial, count(*) from llibres group by editorial;
--2
select editorial, count(*) from llibres group by editorial having count(*) > 4;
--3
select editorial, avg(preu) from llibres group by editorial order by avg(preu) desc;
--4
select editorial, avg(preu) from llibres group by editorial having avg(preu) > 25;
--5
select editorial, count(*) from llibres where editorial != 'Planeta' group by editorial;
--6
select editorial, count(*) from llibres where editorial != 'Planeta' and preu is NOT NULL group by editorial;
--7
select editorial, avg(preu) from llibres group by editorial having count(*) > 2;
--8
select editorial, max(preu) from llibres group by editorial order by max(preu) desc;
--9
select editorial, max(preu) from llibres where preu > 30 group by editorial;
--10
select titol, autor from llibres where titol like 'M%' and autor like '%h%';
--11
select autor, count(*) from llibres group by autor order by count(*) desc;
--12
select substr(titol, 1, 1), avg(preu) from llibres group by substr(titol, 1, 1) order by avg(preu) asc;