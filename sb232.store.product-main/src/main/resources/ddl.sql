CREATE DATABASE IF NOT EXISTS customer DEFAULT CHARACTER SET utf8mb4 DEFAULT COLLATE utf8mb4_0900_ai_ci;
USE customer;

CREATE TABLE client(
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    PRIMARY KEY (id),
    cpf VARCHAR(11) NOT NULL,
    email VARCHAR(255) NOT NULL,
    hashpassword VARCHAR(64) NOT NULL
);