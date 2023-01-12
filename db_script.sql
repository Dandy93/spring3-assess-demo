CREATE DATABASE librarydb;

USE librarydb;

CREATE TABLE `book` (
  `id` int NOT NULL,
  `name` varchar(100) NOT NULL,
  `author` varchar(100) DEFAULT NULL,
  `status` int NOT NULL,
  `book_code` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
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
  `id` int NOT NULL,
  `name` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `date_created` datetime NOT NULL,
  `date_updated` datetime NOT NULL,
  `status` int NOT NULL,
  `department_id` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `department` (
  `id` int NOT NULL,
  `name` varchar(100) NOT NULL,
  `code` varchar(100) NOT NULL,
  `status` int NOT NULL
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
	(1, 'Rudy',NOW(), NOW(), 1),
	(2, 'Christine',NOW(), NOW(), 1),
	(3, 'David',NOW(), NOW(), 1),
	(4, 'Elysia',NOW(), NOW(), 1),
	(5, 'Blaire',NOW(), NOW(), 1);
	
INSERT INTO 
	libstatus (id, name, code, date_created , date_updated)
VALUES
	(1,'Active',1, NOW(), NOW()),
	(2,'Inactive',2, NOW(), NOW()),
	(3,'Pending',3,NOW(),NOW()),
	(4,'Available',4,NOW(),NOW()),
	(5,'NonAvailable',5,NOW(),NOW());

INSERT INTO 
	book (id, name, author, book_code, status, date_created , date_updated)
VALUES
	(1, 'How to Mitigate Stress','Raiden Mei','BL0001',4, NOW(), NOW()),
	(2, 'Outer Disciples','Ginga','BL0002',4, NOW(), NOW()),
	(3, 'Way of The Wind','Michael Straw','BL0003',4, NOW(),NOW());