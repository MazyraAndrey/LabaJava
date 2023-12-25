create table students(
                         id serial NOT NULL PRIMARY KEY,
                         name varchar NOT NULL,
                         passport_series int NOT NULL,
                         passport_number int NOT NULL,
                         UNIQUE(passport_series, passport_number)
);
create table subjects(
                         id serial NOT NULL,
                         namesubjects varchar NOT NULL PRIMARY KEY
);

create table progress(
                         id serial NOT NULL PRIMARY KEY,
                         student int NOT NULL  REFERENCES students(id) ON DELETE CASCADE,
                         subject varchar NOT NULL,
                         FOREIGN KEY (subject) REFERENCES subjects(namesubjects) ON DELETE CASCADE,
                         mark smallint NOT NULL
                             CHECK(mark >= 2 AND mark <= 5)
);

insert into students(id, name, passport_series, passport_number)
values
    (1, 'Дмитрий', 4546, 123465),
    (2, 'Денис', 4566, 123746),
    (3, 'Лев', 3321, 123456),
    (4, 'Матвей', 4567, 124746),
    (5, 'Андрей', 5565, 654123);

insert into subjects(id, namesubjects)
values
    (1, 'Физика'),
    (2, 'Русский язык'),
    (3, 'Математика'),
    (4, 'Информатика');

insert into progress(id, student, subject, mark)
values
    (1, 1,'Физика', 2),
    (2, 2, 'Физика', 2),
    (3, 3, 'Физика', 2),
    (4, 4, 'Физика', 2),
    (5, 5, 'Физика', 2),
    (6, 1, 'Русский язык', 3),
    (7, 2, 'Русский язык', 5),
    (8, 3, 'Русский язык', 3),
    (9, 4, 'Русский язык', 4),
    (10, 5, 'Русский язык', 5),
    (11, 1, 'Математика', 5),
    (12, 2, 'Математика', 2),
    (13, 3, 'Математика', 5),
    (14, 4, 'Математика', 5),
    (15, 5, 'Математика', 2),
    (16, 1, 'Информатика', 4),
    (17, 2, 'Информатика', 5),
    (18, 3, 'Информатика', 4),
    (19, 4, 'Информатика', 3),
    (20, 5, 'Информатика', 4);

SELECT students.id, students.name, progress.mark
FROM students
         JOIN progress ON students.id = progress.student
WHERE progress.subject = 'Физика' AND progress.mark > 3;

SELECT AVG(p.mark) AS "Средний балл"
FROM progress p
         INNER JOIN subjects s ON p.subject = s.namesubjects
WHERE s.namesubjects = 'Физика';

SELECT students.name, AVG(progress.mark) AS "Средний балл"
FROM students
         JOIN progress ON students.id = progress.student
WHERE students.name = 'Дмитрий'
GROUP BY students.name;

SELECT subject, COUNT(*) AS succes
FROM progress
WHERE progress.mark > 2
GROUP BY subject ORDER BY succes DESC
    limit 3;
