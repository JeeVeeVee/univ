-- proglangs.sql
-- ============================================================
-- Copyright (C) 2015-2016 Universiteit Gent
--
-- Bijlage bij het vak 'Programmeren 2'.
--
-- Auteur: Kris Coolsaet
--

-- Dit bestand kan je gebruiken om de tabellen aan te maken die dienen voor
-- de voorbeelden uit prog2.proglangs.
-- Bovendien worden er al enkele gegevens ingevuld.
--
-- (Dit sql-script is bedoeld voor Java DB.)

-- bevat een lijst van programmeertalen
create table proglangs (
    name varchar(256) primary key
);

-- bevat de voorkeuren van de gebruiker
create table prefs (
    name varchar(256) primary key references proglangs,
    checked boolean
);

-- alternatieve manier om de voorkeuren van de gebruiker op te slaan
-- enkel de voorkeuren van de gebruiker zijn hier opgeslagen
create table chosen (
    name varchar(256) primary key references proglangs
);

insert into proglangs(name) values
  'C', 'C++', 'C#', 'Java', 'Javascript', 'PHP', 'Python 2', 'Python 3', 'Ruby', 'Scala', 'VB.Net';

insert into prefs
    select name, false from proglangs;




