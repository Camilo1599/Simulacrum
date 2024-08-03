CREATE TABLE  contractAdministartor;

USE contractAdministartor;

create table Enterprise(
	id int primary key auto_increment,
    name varchar(100),
    location varchar(100)
);

create table Coder(
	id int primary key auto_increment,
	name varchar(255),
    lastname varchar(255),
    clan varchar(255),
    technology varchar(255)
);

create table Vacancy(
	id int primary key auto_increment,
    title varchar(150),
    description varchar(100),
    clan varchar(100),
    technology varchar(100),
    status enum('Pendiente', 'Activo', 'Inactivo') Default 'Inactivo',
    enterprise_id int,
    foreign key (enterprise_id) references Enterprise(id)

);

create table Contract(
	id int primary key auto_increment,
    technology varchar(255),
    status enum('Pendiente', 'Activo', 'Inactivo') Default 'Inactivo',
    coder_id int,
    vacancy_id int,
    foreign key (coder_id) references Coder(id),
    foreign key (vacancy_id) references Vacancy(id)

);
