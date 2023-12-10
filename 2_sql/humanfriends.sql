CREATE DATABASE IF NOT EXISTS human_friends;
USE human_friends;

-- 8 Создать таблицы с иерархией из диаграммы в БД

DROP TABLE IF EXISTS `packanimalstypes`;
CREATE TABLE `packanimalstypes` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `packAnimalType` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));
INSERT INTO `packAnimalsTypes` (`packAnimalType`) VALUES ('horse');
INSERT INTO `packAnimalsTypes` (`packAnimalType`) VALUES ('camel');
INSERT INTO `packAnimalsTypes` (`packAnimalType`) VALUES ('donkey'); 
DROP TABLE IF EXISTS `petAnimalsTypes`;
CREATE TABLE `petAnimalsTypes` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `petAnimalType` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));
INSERT INTO `petAnimalsTypes` (`petAnimalType`) VALUES ('dog');
INSERT INTO `petAnimalsTypes` (`petAnimalType`) VALUES ('cat');
INSERT INTO `petAnimalsTypes` (`petAnimalType`) VALUES ('humster'); 
DROP TABLE IF EXISTS `petAnimals`;
CREATE TABLE `petAnimals` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(45) NOT NULL,
  `BirthDate` DATE NOT NULL,
  `Comands` VARCHAR(85) NULL,
  `typeId` INT NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`typeId`)
  REFERENCES `petAnimalstypes` (`id`)
  );
 DROP TABLE IF EXISTS `packAnimals`;
CREATE TABLE `packAnimals` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(45) NOT NULL,
  `BirthDate` DATE NOT NULL,
  `Comands` VARCHAR(85) NULL,
  `typeId` INT NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`typeId`)
  REFERENCES `packAnimalstypes` (`id`)
  );

-- 9 Заполнить низкоуровневые таблицы именами(животных), командами
-- которые они выполняют и датами рождения

INSERT INTO `petAnimals` (`Name`, `BirthDate`, `Comands`, `typeId`) VALUES ('Rex', '2020-12-11', 'lay, stand', '1');
INSERT INTO `petAnimals` (`Name`, `BirthDate`, `Comands`, `typeId`) VALUES ('Bars', '2020-04-10', 'meow', '2');
INSERT INTO `petAnimals` (`Name`, `BirthDate`, `Comands`, `typeId`) VALUES ('Berserc', '2021-11-11', 'sleep', '3');
INSERT INTO `petAnimals` (`Name`, `BirthDate`, `Comands`, `typeId`) VALUES ('Behemot', '2012-05-04', 'bite', '2');

INSERT INTO `packAnimals` (`Name`, `BirthDate`, `Comands`, `typeId`) VALUES ('Rosinant', '2020-12-11', 'go, stop', '1');
INSERT INTO `packAnimals` (`Name`, `BirthDate`, `Comands`, `typeId`) VALUES ('Yuliy', '2020-04-10', 'go, stop', '1');
INSERT INTO `packAnimals` (`Name`, `BirthDate`, `Comands`, `typeId`) VALUES ('Karacum', '2021-11-11', 'lay, stand', '2');
INSERT INTO `packAnimals` (`Name`, `BirthDate`, `Comands`, `typeId`) VALUES ('Emperor', '2012-05-04', 'lay, stand', '2');
INSERT INTO `packAnimals` (`Name`, `BirthDate`, `Comands`, `typeId`) VALUES ('Ia', '2012-05-04', 'voice', '3');

SELECT * FROM `petAnimals`;
SELECT * FROM `packAnimals`;

-- 10 Удалив из таблицы верблюдов, т.к. верблюдов решили перевезти в другой
-- питомник на зимовку. Объединить таблицы лошади, и ослы в одну таблицу.

DELETE FROM `packAnimals` WHERE typeId = 2;
SELECT * FROM `packAnimals`;

-- 12 Объединить все таблицы в одну, при этом сохраняя поля, указывающие на
-- прошлую принадлежность к старым таблицам.

CREATE TEMPORARY TABLE all_animals
SELECT a.name, a.birthdate, a.comands, t.packanimaltype
FROM `packAnimals` a
LEFT JOIN `packAnimalsTypes` t
ON a.typeId = t.id
UNION
SELECT a.name, a.birthdate, a.comands, t.petanimaltype
FROM `petAnimals` a
LEFT JOIN `petAnimalsTypes` t
ON a.typeId = t.id;

SELECT * FROM all_animals;

-- 11 Создать новую таблицу “молодые животные” в которую попадут все
-- животные старше 1 года, но младше 3 лет и в отдельном столбце с точностью
-- до месяца подсчитать возраст животных в новой таблице
CREATE TEMPORARY TABLE young_animals
SELECT * , datediff(curdate(), birthdate) DIV 30 AS `ageInMonth`
FROM all_animals
WHERE date_add(birthdate, INTERVAL 1 YEAR) < curdate() AND date_add(birthdate, INTERVAL 3 YEAR) > curdate();

SELECT * FROM young_animals;



  