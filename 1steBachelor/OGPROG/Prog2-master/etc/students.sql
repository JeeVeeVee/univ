-- students.sql
-- ============================================================
-- Copyright (C) 2012-2013 Universiteit Gent
-- 
-- Bijlage bij het vak 'Programmeren 2'.
-- 
-- Auteur: Kris Coolsaet
--

-- Dit bestand kan je gebruiken om de tabellen aan te maken uit de 
-- 'students'-database die in prog2.students wordt gebruikt.
--
-- (Dit sql-script is bedoeld voor Java DB.)

create table student (
    id integer primary key,
    last_name varchar(256),
    first_name varchar(256)
);

INSERT INTO student VALUES (100, 'Van Beethoven','Ludwig');
INSERT INTO student VALUES (101, 'Brahms',       'Johannes');
INSERT INTO student VALUES (102, 'Zappa',        'Frank');
INSERT INTO student VALUES (103, 'Mozart',       'Wolfgang A.');
INSERT INTO student VALUES (104, 'Bach' ,        'Johan S.');
INSERT INTO student VALUES (105, 'Verdi',        'Giuseppe');
INSERT INTO student VALUES (106, 'Mahler',       'Alma');
INSERT INTO student VALUES (107, 'Berlioz',      'Hector');
INSERT INTO student VALUES (108, 'Ravel',        'Maurice');
INSERT INTO student VALUES (109, 'Stravinski',   'Igor');
INSERT INTO student VALUES (110, 'Vivaldi',      'Antonio');
INSERT INTO student VALUES (111, 'Schumann',     'Robert');
INSERT INTO student VALUES (112, 'Schumann',     'Clara');
INSERT INTO student VALUES (113, 'Mahler',       'Gustav');
INSERT INTO student VALUES (114, 'Glass',        'Philip');
INSERT INTO student VALUES (115, 'Lennon',       'John');


create table course (
    id integer primary key,
    title varchar(256)
);

INSERT INTO course VALUES (3011, 'Applied theology');
INSERT INTO course VALUES (3012, 'Advanced procrastination');
INSERT INTO course VALUES (3013, 'Practical metaphysics');

create table mark (
    student_id integer references student,
    course_id integer references course,
    value integer,
    PRIMARY KEY (student_id, course_id)
);

INSERT INTO mark VALUES (100, 3011, 12);
INSERT INTO mark VALUES (101, 3011, 13);
INSERT INTO mark VALUES (102, 3011, 18);
INSERT INTO mark VALUES (103, 3011, 20);
INSERT INTO mark VALUES (104, 3011, 15);
INSERT INTO mark VALUES (105, 3011,  8);
INSERT INTO mark VALUES (106, 3011, 13);
INSERT INTO mark VALUES (107, 3011, 12);
INSERT INTO mark VALUES (108, 3011,  6);
INSERT INTO mark VALUES (109, 3011,  0);
INSERT INTO mark VALUES (110, 3011, 12);
INSERT INTO mark VALUES (111, 3011, 13);
INSERT INTO mark VALUES (112, 3011, 11);
INSERT INTO mark VALUES (113, 3011,  9);
INSERT INTO mark VALUES (114, 3011, 15);
INSERT INTO mark VALUES (115, 3011, 12);

INSERT INTO mark VALUES (100, 3012, 14);
INSERT INTO mark VALUES (101, 3012,  7);
INSERT INTO mark VALUES (102, 3012, 18);
INSERT INTO mark VALUES (103, 3012, 16);
INSERT INTO mark VALUES (104, 3012, 11);
INSERT INTO mark VALUES (105, 3012, 11);
INSERT INTO mark VALUES (106, 3012, 14);
INSERT INTO mark VALUES (107, 3012, 17);
INSERT INTO mark VALUES (108, 3012, 10);
INSERT INTO mark VALUES (109, 3012,  0);
INSERT INTO mark VALUES (110, 3012, 10);
INSERT INTO mark VALUES (111, 3012, 15);
INSERT INTO mark VALUES (112, 3012, 13);
INSERT INTO mark VALUES (113, 3012,  8);
INSERT INTO mark VALUES (114, 3012, 17);
INSERT INTO mark VALUES (115, 3012, 19);

INSERT INTO mark VALUES (100, 3013, 20);
INSERT INTO mark VALUES (101, 3013,  9);
INSERT INTO mark VALUES (102, 3013, 14);
INSERT INTO mark VALUES (103, 3013, 15);
INSERT INTO mark VALUES (104, 3013,  9);
INSERT INTO mark VALUES (105, 3013, 13);
INSERT INTO mark VALUES (106, 3013, 13);
INSERT INTO mark VALUES (107, 3013, 15);
INSERT INTO mark VALUES (108, 3013, 11);
INSERT INTO mark VALUES (109, 3013,  0);
INSERT INTO mark VALUES (110, 3013, 12);
INSERT INTO mark VALUES (111, 3013, 12);
INSERT INTO mark VALUES (112, 3013, 14);
INSERT INTO mark VALUES (113, 3013, 11);
INSERT INTO mark VALUES (114, 3013, 16);
INSERT INTO mark VALUES (115, 3013, 12);
