create database biblioteca;

use biblioteca;

create table Libro (
    Codice smallint primary key,
    Titolo varchar(50) not null,
    CopieDisponibili smallint not null
);

create table Edizione (
    ISBN char(14) primary key,
    AnnoStampa smallint not null,
    Edizione varchar(30) not null
);

create table Rivista (
    Codice smallint primary key,
    Titolo varchar(50) not null,
    Anno smallint not null ,
    Mese smallint not null ,
    Volume smallint not null ,
    Issue smallint not null
);

create table Copia (
    CodiceCatalogazione smallint primary key,
    Stato varchar(20) not null,
    CodiceLibro smallint not null,
    ISBN char(14) not null,

    foreign key(CodiceLibro) references Libro(Codice),
    foreign key(ISBN) references Edizione(ISBN)
);

create table Socio (
    Matricola smallint primary key,
    Nome varchar(20) not null,
    Cognome varchar(20) not null,
    DataNascita date not null,
    DataIscrizione date not null
);

create table Prestito (
    Matricola smallint,
    CodiceCatalogazione smallint,
    DataPrestito date,
    DataRestituzione date,
    DurataPrestito smallint not null,

    primary key(Matricola, CodiceCatalogazione, DataPrestito),
    foreign key(CodiceCatalogazione) references Copia(CodiceCatalogazione),
    foreign key(Matricola) references Socio(Matricola)
);

create table Consultazione (
    MatricolaSocio smallint,
    CodiceRivista smallint,

    primary key(MatricolaSocio, CodiceRivista),
    foreign key(MatricolaSocio) references Socio(Matricola),
    foreign key(CodiceRivista) references Rivista(Codice)
);

create table Genere (
    CodiceGenere smallint primary key,
    NomeGenere varchar(30) not null
);

create table Autore (
    CodiceAutore smallint primary key,
    Nome varchar(20) not null,
    Cognome varchar(20) not null,
    Nazionalità varchar(20) not null,
    DataNascita date not null,
    DataMorte date,
    Epoca varchar(20) not null
);

create table Appartenenza (
    CodiceAutore smallint,
    CodiceGenere smallint,

    primary key(CodiceAutore, CodiceGenere),
    foreign key(CodiceAutore) references Autore(CodiceAutore),
    foreign key(CodiceGenere) references Genere(CodiceGenere)
);

create table Scrittura (
    CodiceLibro smallint,
    CodiceAutore smallint,

    primary key(CodiceLibro, CodiceAutore),
    foreign key(CodiceLibro) references Libro(Codice),
    foreign key(CodiceAutore) references Autore(CodiceAutore)
);