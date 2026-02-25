CREATE DATABASE IF NOT EXISTS productdb;
USE productdb;

CREATE TABLE category (
    id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(100) NOT NULL,
    slug VARCHAR(100) NOT NULL,
    meta_title VARCHAR(150),
    content TEXT
);

CREATE TABLE sub_category (
    id INT PRIMARY KEY AUTO_INCREMENT,
    categoryid INT NOT NULL,
    description VARCHAR(100),
    FOREIGN KEY (categoryid) REFERENCES category(id)
);

CREATE TABLE product (
    id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(150) NOT NULL,
    summary VARCHAR(150),
    content TEXT,
    categoryid INT NOT NULL,
    subcategoryid INT,
    created_at DATETIME,
    updated_at DATETIME,
    FOREIGN KEY (categoryid) REFERENCES category(id),
    FOREIGN KEY (subcategoryid) REFERENCES sub_category(id)
);