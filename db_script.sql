CREATE DATABASE librarydb;

USE librarydb;

CREATE TABLE `book` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `author` varchar(100) DEFAULT NULL,
  `status` int NOT NULL,
  `book_code` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `date_created` datetime NOT NULL,
  `date_updated` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `department` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `code` varchar(100) NOT NULL,
  `status` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `libstatus` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `code` int NOT NULL,
  `date_created` datetime NOT NULL,
  `date_updated` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `loan` (
  `id` int NOT NULL AUTO_INCREMENT,
  `loan_code` varchar(100) NOT NULL,
  `book_id` int NOT NULL,
  `student_id` int NOT NULL,
  `date_created` datetime NOT NULL,
  `date_updated` datetime NOT NULL,
  `status` int NOT NULL,
  `borrower` varchar(255) DEFAULT NULL,
  `book_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `student` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `pass` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `date_created` datetime NOT NULL,
  `date_updated` datetime NOT NULL,
  `status` int NOT NULL,
  `department_id` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO 
	student (id, name, email , pass , date_created , date_updated, status, department_id)
VALUES
	(1, 'Rudy', 'rudy@gmail.com', 'rudy32', NOW(), NOW(), 1, 1),
	(2, 'Christine', 'chc@outlook.com', 'chr9000', NOW(), NOW(), 1, 1),
	(3, 'David', 'dave@test.com', 'dvd300', NOW(), NOW(), 1, 1),
	(4, 'Elysia', 'elyhoh@hi.com', 'fc13', NOW(), NOW(), 1, 1),
	(5, 'Blaire', 'bloria@testing.com', 'asdasd',NOW(), NOW(), 1, 1);
	
INSERT INTO 
	libstatus (id, name, code, date_created , date_updated)
VALUES
	(1,'Active',1, NOW(), NOW()),
	(2,'Inactive',2, NOW(), NOW()),
	(3,'Pending',3,NOW(),NOW()),
	(4,'Available',4,NOW(),NOW()),
	(5,'NonAvailable',5,NOW(),NOW()),
	(6,'Done',6,NOW(),NOW()),
	(7,'Dued',7,NOW(),NOW());

INSERT INTO 
	book (id, name, author, book_code, status, date_created , date_updated)
VALUES
	(1, 'How to Mitigate Stress','Raiden Mei','BL0001',4, NOW(), NOW()),
	(2, 'Outer Disciples','Ginga','BL0002',4, NOW(), NOW()),
	(3, 'Way of The Wind','Michael Straw','BL0003',4, NOW(),NOW());
	
INSERT INTO 
	department (id, name, code, status)
VALUES
	(1, 'Information Technology','D01', 1),
	(2, 'Law','D02', 1),
	(3, 'Business','D03', 1);

INSERT INTO 
	loan (id, loan_code , book_id , student_id ,date_created , date_updated, status)
VALUES
	(1, 'LB0001',3,3, NOW(), NOW(), 1),
	(2, 'LB0002',2,4, NOW(), NOW(), 6),
	(3, 'LB0003',1,5, NOW(), NOW(), 7),
	(4, 'LB0004',1,2, NOW(), NOW(), 6);


	