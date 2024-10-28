CREATE DATABASE IF NOT EXISTS human_friends;

USE human_friends;

CREATE TABLE IF NOT EXISTS Dogs  (
    id INT AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(50),
    commands VARCHAR(255),
    birthday DATE
);

CREATE TABLE IF NOT EXISTS Cats (
    id INT AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(50),
    commands VARCHAR(255),
    birthday DATE
);

CREATE TABLE IF NOT EXISTS Hamsters (
    id INT AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(50),
    commands VARCHAR(255),
    birthday DATE
);

CREATE TABLE IF NOT EXISTS Horses (
    id INT AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(50),
    commands VARCHAR(255),
    birthday DATE
);

CREATE TABLE IF NOT EXISTS Camels (
    id INT AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(50),
    commands VARCHAR(255),
    birthday DATE
);

CREATE TABLE IF NOT EXISTS Donkeys (
    id INT AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(50),
    commands VARCHAR(255),
    birthday DATE
);


INSERT INTO Dogs (`name`, commands, birthday) 
VALUES ('Бобик', 'сидеть, голос', '2021-05-15'),
       ('Шарик', 'апорт, лежать', '2022-03-10');

INSERT INTO Cats (`name`, commands, birthday) 
VALUES ('Мурка', 'сидеть, мяу', '2021-08-25');

INSERT INTO Humsters (`name`, commands, birthday) 
VALUES ('Пузатик', 'есть, бег', '2021-11-25');

INSERT INTO Horses (`name`, commands, birthday) 
VALUES ('Буцефал', 'бег, стой', '2020-02-18');

INSERT INTO Camels (`name`, commands, birthday) 
VALUES ('Генрих', 'стой', '2019-12-10');

INSERT INTO Donkeys (`name`, commands, birthday) 
VALUES ('Освальд', 'прыжок', '2020-04-12');

DELETE FROM Camels;

CREATE TABLE IF NOT EXISTS Pack_Animals AS
SELECT * FROM Horses
UNION ALL
SELECT * FROM Donkeys;

CREATE TABLE IF NOT EXISTS Young_Animals AS
SELECT 'Cat' AS type, id, name, birthday, TIMESTAMPDIFF(MONTH, birthday, CURDATE()) AS age_in_months FROM Cats WHERE TIMESTAMPDIFF(YEAR, birthday, CURDATE()) BETWEEN 1 AND 3
UNION ALL
SELECT 'Dog' AS type, id, name, birthday, TIMESTAMPDIFF(MONTH, birthday, CURDATE()) AS age_in_months FROM Dogs WHERE TIMESTAMPDIFF(YEAR, birthday, CURDATE()) BETWEEN 1 AND 3
UNION ALL
SELECT 'Hamster' AS type, id, name, birthday, TIMESTAMPDIFF(MONTH, birthday, CURDATE()) AS age_in_months FROM Hamsters WHERE TIMESTAMPDIFF(YEAR, birthday, CURDATE()) BETWEEN 1 AND 3
UNION ALL
SELECT 'Donkey' AS type, id, name, birthday, TIMESTAMPDIFF(MONTH, birthday, CURDATE()) AS age_in_months FROM Donkeys WHERE TIMESTAMPDIFF(YEAR, birthday, CURDATE()) BETWEEN 1 AND 3
UNION ALL
SELECT 'Horse' AS type, id, name, birthday, TIMESTAMPDIFF(MONTH, birthday, CURDATE()) AS age_in_months FROM Horses WHERE TIMESTAMPDIFF(YEAR, birthday, CURDATE()) BETWEEN 1 AND 3;

CREATE TABLE IF NOT EXISTS All_Animals AS
SELECT 'Cat' AS original_table, id, name, birthday FROM Cats
UNION ALL
SELECT 'Dog' AS original_table, id, name, birthday FROM Dogs
UNION ALL
SELECT 'Hamster' AS original_table, id, name, birthday FROM Hamsters
UNION ALL
SELECT 'Donkey' AS original_table, id, name, birthday FROM Donkeys
UNION ALL
SELECT 'Horse' AS original_table, id, name, birthday FROM Horses;

