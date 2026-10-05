DROP
DATABASE IF EXISTS speedfast_db;
CREATE
DATABASE speedfast_db;
USE
speedfast_db;

-- Tabla repartidor
CREATE TABLE repartidor
(
    id     INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL
);

-- Tabla pedido
CREATE TABLE pedido
(
    id        INT AUTO_INCREMENT PRIMARY KEY,
    direccion VARCHAR(150) NOT NULL,
    tipo      VARCHAR(30)  NOT NULL,
    estado    VARCHAR(20)  NOT NULL,
    distancia_km DOUBLE NOT NULL DEFAULT 0.0
);

-- Tabla entrega
CREATE TABLE entrega
(
    id            INT AUTO_INCREMENT PRIMARY KEY,
    id_pedido     INT  NOT NULL,
    id_repartidor INT  NOT NULL,
    fecha         DATE NOT NULL,
    hora          TIME NOT NULL,
    FOREIGN KEY (id_pedido) REFERENCES pedido (id),
    FOREIGN KEY (id_repartidor) REFERENCES repartidor (id)
);

-- Repartidores
INSERT INTO repartidor (nombre)
VALUES ('Jose Luis Lucas Juan'),
       ('Philip J. Fry'),
       ('Policarpo'),
       ('Miguel Bosé'),
       ('Cosme Fulanito');

-- Pedidos iniciales
INSERT INTO pedido (direccion, tipo, estado, distancia_km)
VALUES ('Tangamandapio 213', 'COMIDA', 'PENDIENTE', 43.0),
       ('Titirilquen 23', 'ENCOMIENDA', 'PENDIENTE', 12.0),
       ('Alto Jahuel 333', 'EXPRESS', 'PENDIENTE', 4.0),
       ('Avenida Siempre Viva 742, Springfield', 'ENCOMIENDA', 'PENDIENTE', 12.0),
       ('Calle Wallaby 42, Sydney', 'COMIDA', 'PENDIENTE', 5.0),
       ('Muy Muy Lejano 54', 'EXPRESS', 'PENDIENTE', 6.0);

-- Verificaciones
SELECT *
FROM repartidor;
SELECT *
FROM pedido;