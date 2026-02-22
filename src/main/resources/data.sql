USE productdb;

 
SET SQL_SAFE_UPDATES = 0;
SET FOREIGN_KEY_CHECKS = 0;
 
TRUNCATE TABLE product;
TRUNCATE TABLE sub_category;
TRUNCATE TABLE category;
 
SET FOREIGN_KEY_CHECKS = 1;
 
INSERT INTO category (id, title, slug, meta_title, content) VALUES
(1, 'Electrónica', 'electronica', 'Equipos Electrónicos', 'Laptops y celulares'),
(2, 'Hogar', 'hogar', 'Cosas del Hogar', 'Muebles y decoración');
 
INSERT INTO sub_category (id, categoryid, description) VALUES
(1, 1, 'Gadgets'),
(2, 2, 'Dormitorio');

 
INSERT INTO product (title, summary, content, categoryid, subcategoryid, created_at, updated_at) VALUES
('UltraSoft Pillow', 'ComfortCo', 'A luxurious pillow made with the finest down feathers. Price: $49.99', 2, 2, NOW(), NOW()),
('EcoSmart LED Bulb', 'GreenTech', 'An energy-saving LED bulb with a lifespan of 25,000 hours. Price: $7.49', 2, 2, NOW(), NOW()),
('ProGaming Mouse', 'GamerPro', 'Ergonomic gaming mouse with customizable RGB lighting. Price: $59.99', 1, 1, NOW(), NOW()),
('SteelChef Knife Set', 'CulinaryMaster', 'A set of stainless steel knives with ergonomic handles. Price: $89.95', 2, 2, NOW(), NOW());

 
SET SQL_SAFE_UPDATES = 1;