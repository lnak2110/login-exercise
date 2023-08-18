CREATE DATABASE db_loginexercise;
USE db_loginexercise;

CREATE TABLE User(
    id INT AUTO_INCREMENT,
    email VARCHAR(50),
    password VARCHAR(50),
    
    PRIMARY KEY(id)
);

INSERT INTO User(email,password) VALUES
('admin@test.com','1234');