CREATE DATABASE librarydb;

USE librarydb;

CREATE TABLE `book` (
  `id` varchar(100) NOT NULL,
  `name` varchar(100) NOT NULL,
  `author` varchar(100) DEFAULT NULL,
  `status` int NOT NULL,
  `date_created` datetime NOT NULL,
  `date_updated` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `libstatus` (
  `id` int NOT NULL,
  `name` varchar(100) NOT NULL,
  `code` int NOT NULL,
  `date_created` datetime NOT NULL,
  `date_updated` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `student` (
  `id` varchar(100) NOT NULL,
  `name` varchar(100) NOT NULL,
  `date_created` datetime NOT NULL,
  `date_updated` datetime NOT NULL,
  `status` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `loan` (
  `id` int NOT NULL,
  `loan_code` varchar(100) NOT NULL,
  `book_id` int NOT NULL,
  `student_id` int NOT NULL,
  `date_created` datetime NOT NULL,
  `date_updated` datetime NOT NULL,
  `status` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO 
	student (id, name, date_created , date_updated, status)
VALUES
	('Rudy',NOW(), NOW(), 1),
	('Christine',NOW(), NOW(), 1),
	('David',NOW(), NOW(), 1),
	('Elysia',NOW(), NOW(), 1),
	('Blaire',NOW(), NOW(), 1);
	
INSERT INTO 
	libstatus (id, name, code, date_created , date_updated)
VALUES
	(1,'Active',1, NOW(), NOW()),
	(2,'Inactive',2, NOW(), NOW()),
	(3,'Pending',3,NOW(),NOW()),
	(4,'Available',4,NOW(),NOW()),
	(5,'NonAvailable',5,NOW(),NOW());

INSERT INTO 
	book (id, name, author, status, date_created , date_updated)
VALUES
	('BL0001','How to Mitigate Stress','Raiden Mei',4, NOW(), NOW()),
	('BL0002','Outer Disciples','Ginga',4, NOW(), NOW()),
	('BL0003','Way of The Wind','Michael Straw',4, NOW(),NOW());