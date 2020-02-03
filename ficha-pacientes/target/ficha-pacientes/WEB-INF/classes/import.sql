-- Script de criaçao de objetos e carga de dados
--

-- You can use this file to load seed data into the database using SQL statements

create or replace table Especialidades (id int primary key, nome varchar(50) not null);
create or replace table PlanosDeSaude (id int primary key,nome varchar(50) not null);
create or replace table FichaPacientes (id int primary key,nomePaciente varchar(50) not null,idPlanoDeSaude int,idEspecialidade int,foreign key (idPlanoDeSaude) references PlanosDeSaude(id),foreign key (idEspecialidade) references Especialidades(id));

insert into ESPECIALIDADES (id, nome) values (1, 'Pediatria');
insert into ESPECIALIDADES (id, nome) values (2, 'Clinica');
insert into ESPECIALIDADES (id, nome) values (3, 'Urologia');
insert into ESPECIALIDADES (id, nome) values (4, 'Ortopedia');

insert into PLANOSDESAUDE (id, nome) values (1, 'UNIMED');
insert into PLANOSDESAUDE (id, nome) values (2, 'AMIL');
insert into PLANOSDESAUDE (id, nome) values (3, 'BRADESCO');
insert into PLANOSDESAUDE (id, nome) values (4, 'SULAMERICA');

INSERT INTO FICHAPACIENTES(id, NOMEPACIENTE, IDPLANODESAUDE, IDESPECIALIDADE) VALUES (1, 'JOAO PEDRO MUNHOZ', 1, 1);
INSERT INTO FICHAPACIENTES(id, NOMEPACIENTE, IDPLANODESAUDE, IDESPECIALIDADE) VALUES (2, 'KARIN SUYENE CARVALHO', 2, 2);
INSERT INTO FICHAPACIENTES(id, NOMEPACIENTE, IDPLANODESAUDE, IDESPECIALIDADE) VALUES (3, 'JOAO MIGUEL MARTINS CARVALHO', 1, 2);
INSERT INTO FICHAPACIENTES(id, NOMEPACIENTE, IDPLANODESAUDE, IDESPECIALIDADE) VALUES (4, 'TOMMY LEE JONES', 3, 3);
INSERT INTO FICHAPACIENTES(id, NOMEPACIENTE, IDPLANODESAUDE, IDESPECIALIDADE) VALUES (5, 'REGINA DUARTE', 2, 1);
INSERT INTO FICHAPACIENTES(id, NOMEPACIENTE, IDPLANODESAUDE, IDESPECIALIDADE) VALUES (6, 'CARLOS DRUMMOND', 1, 1);

