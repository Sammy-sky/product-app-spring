USE productdb;

-- 1. Limpieza de seguridad
SET SQL_SAFE_UPDATES = 0;
SET FOREIGN_KEY_CHECKS = 0;

TRUNCATE TABLE product;
TRUNCATE TABLE sub_category;
TRUNCATE TABLE category;

SET FOREIGN_KEY_CHECKS = 1;

-- 2. Categorías Principales
INSERT INTO category (id, title, slug, meta_title, content) VALUES
(1, 'Electrónica', 'electronica', 'Tecnología y Gadgets', 'Equipos de alta tecnología y periféricos'),
(2, 'Hogar', 'hogar', 'Artículos para el Hogar', 'Muebles, decoración e iluminación'),
(3, 'Oficina', 'oficina', 'Equipamiento de Oficina', 'Todo para tu espacio de trabajo'),
(4, 'Deportes', 'deportes', 'Vida Saludable', 'Equipos de entrenamiento y outdoor'),
(5, 'Belleza', 'belleza', 'Cuidado Personal', 'Productos de estética y salud');

-- 3. Subcategorías (Relacionadas por categoryid)
INSERT INTO sub_category (id, categoryid, description) VALUES
(1, 1, 'Gadgets'),
(2, 1, 'Periféricos'),
(3, 2, 'Dormitorio'),
(4, 2, 'Iluminación'),
(5, 3, 'Mobiliario'),
(6, 4, 'Fitness'),
(7, 5, 'Cuidado Personal');

-- 4. Productos Iniciales (Prueba de carga masiva)
INSERT INTO product (title, summary, content, categoryid, subcategoryid, created_at, updated_at) VALUES
-- Electrónica
('ProGaming Mouse', 'GamerPro', 'Mouse con 16000 DPI y luces RGB. Precio: $59.99', 1, 2, NOW(), NOW()),
('Auriculares Bluetooth X', 'AudioMax', 'Cancelación de ruido activa. Precio: $120.00', 1, 1, NOW(), NOW()),
-- Hogar
('UltraSoft Pillow', 'ComfortCo', 'Almohada de plumas de ganso. Precio: $49.99', 2, 3, NOW(), NOW()),
('Lámpara LED Inteligente', 'EcoSmart', 'Control por voz y 16M de colores. Precio: $25.00', 2, 4, NOW(), NOW()),
-- Oficina
('Silla Ergonómica Pro', 'OfficeDesign', 'Soporte lumbar y ajuste de altura. Precio: $180.00', 3, 5, NOW(), NOW()),
('Escritorio Elevable', 'WorkSpace', 'Escritorio eléctrico para trabajar de pie. Precio: $350.00', 3, 5, NOW(), NOW()),
-- Deportes
('Pesas Hexagonales 5kg', 'IronGym', 'Recubiertas en caucho para mayor durabilidad. Precio: $30.00', 4, 6, NOW(), NOW()),
-- Belleza
('Secador de Pelo Ion', 'BeautyTech', 'Secado rápido sin dañar el cabello. Precio: $45.00', 5, 7, NOW(), NOW());

SET SQL_SAFE_UPDATES = 1;