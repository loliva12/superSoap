use superSoap;

-- Eliminar tablas intermedias y tablas con claves foráneas primero
DROP TABLE IF EXISTS dbo.provincias_localidades;
DROP TABLE IF EXISTS dbo.tipos_productos_marcas;
DROP TABLE IF EXISTS dbo.productos_sucursales;
DROP TABLE IF EXISTS dbo.productos;
DROP TABLE IF EXISTS dbo.categorias_productos;
DROP TABLE IF EXISTS dbo.rubros_productos;
DROP TABLE IF EXISTS dbo.tipos_servicios_sucursales;
DROP TABLE IF EXISTS dbo.tipos_servicios_supermercado;
DROP TABLE IF EXISTS dbo.horarios_sucursales;
DROP TABLE IF EXISTS dbo.sucursales;
DROP TABLE IF EXISTS dbo.supermercado;
DROP TABLE IF EXISTS dbo.marcas_productos;
DROP TABLE IF EXISTS dbo.tipos_productos;
DROP TABLE IF EXISTS dbo.localidades;
DROP TABLE IF EXISTS dbo.provincias;
DROP TABLE IF EXISTS dbo.paises;
DROP TABLE IF EXISTS dbo.empresas_externas;


/* -------------------------------------
   TABLA PAISES
   ------------------------------------- */
-- Crear tabla de paises
CREATE TABLE dbo.paises (
    cod_pais INT PRIMARY KEY,
    nom_pais VARCHAR(100) NOT NULL,
);
-- Insert tabla de paises
INSERT INTO dbo.paises (cod_pais, nom_pais) VALUES
(1, 'Argentina');


/* -------------------------------------
   TABLA PROVINCIAS
   ------------------------------------- */
-- Crear tabla de provincias
CREATE TABLE dbo.provincias (
    cod_provincia INT PRIMARY KEY,
    nom_provincia VARCHAR(100) NOT NULL
);
-- Insert tabla de provincias
INSERT INTO dbo.provincias (cod_provincia, nom_provincia) VALUES
(1, 'Cordoba');

/* -------------------------------------
   TABLA LOCALIDADES
   ------------------------------------- */
-- Crear tabla de localidades
CREATE TABLE dbo.localidades (
    nro_localidad INT PRIMARY KEY,
    nom_localidad VARCHAR(100) NOT NULL
);
INSERT INTO dbo.localidades (nro_localidad, nom_localidad) VALUES
(1, 'Capital'),
(2, 'Saldan'),
(3, 'Santa Rosa'),
(4, 'Villa Allende');

/* -------------------------------------
   TABLA PROVINCIAS-LOCALIDADES
   ------------------------------------- */
-- Crear tabla intermedia entre provincias y localidades
CREATE TABLE dbo.provincias_localidades (
    cod_provincia INT,
    nro_localidad INT,
    PRIMARY KEY (cod_provincia, nro_localidad),
    FOREIGN KEY (cod_provincia) REFERENCES provincias(cod_provincia),
    FOREIGN KEY (nro_localidad) REFERENCES localidades(nro_localidad)
);
-- Insert tabla intermedia entre provincias y localidades
INSERT INTO dbo.provincias_localidades (cod_provincia, nro_localidad) VALUES
(1, 1),
(1, 2),
(1, 3),
(1, 4);

/* -------------------------------------
   TABLAEMPRESAS EXTERNAS
   ------------------------------------- */
-- Crear tabla de empresas_externas
CREATE TABLE dbo.empresas_externas (
    nro_empresa INT PRIMARY KEY,
    razon_social VARCHAR(100) NOT NULL,
    cuit_empresa VARCHAR(20) NOT NULL,
    token_servicio VARCHAR(100)
);
-- Insert tabla de empresas externas
INSERT INTO dbo.empresas_externas (nro_empresa, razon_social, cuit_empresa, token_servicio) VALUES
(1, 'Distribuidora XYZ', '30-12345678-9', 'TOKEN123'),
(2, 'Logística ABC', '30-87654321-0', 'TOKEN456'),
(3, 'Servicios 123', '30-11223344-5', 'TOKEN789');

/* -------------------------------------
   TABLA SUPERMERCADO
   ------------------------------------- */
-- Crear tabla de supermercado
CREATE TABLE dbo.supermercado (
    razon_social VARCHAR(100) NOT NULL,
    calle VARCHAR(100) NOT NULL,
    nro_calle INT,
    telefonos VARCHAR(50)
);
-- Insert tabla de supermercado
INSERT INTO dbo.supermercado (razon_social, calle, nro_calle, telefonos) VALUES
('Supermercado CORDOBA', 'Calle 12', 345, '221-1234567');

/* -------------------------------------
   TABLA SUCURSALES
   ------------------------------------- */
-- Crear tabla de sucursales
CREATE TABLE dbo.sucursales (
    nro_sucursal INT PRIMARY KEY,
    calle VARCHAR(100) NOT NULL,
    nro_calle INT,
    telefonos VARCHAR(50),
    coord_latitud FLOAT,
    coord_longitud FLOAT,
    nro_localidad INT FOREIGN KEY REFERENCES localidades(nro_localidad),
    habilitada VARCHAR NOT NULL
);
-- Inser tabla de sucursales
INSERT INTO dbo.sucursales (nro_sucursal, calle, nro_calle, telefonos, coord_latitud, coord_longitud, nro_localidad, habilitada) VALUES
(1, 'Calle Principal', 123, '351-1234567', -31.4160, -64.1830, 1, 'S'),
(2, 'Avenida Central', 456, '351-2345678', -31.3386, -64.3024, 2, 'S'),
(3, 'Calle Comercio', 789, '351-3456789', -32.0667, -64.3000, 3, 'S'),
(4, 'Boulevard Norte', 101, '351-4567890', -31.2946, -64.2777, 4, 'S');

/* -------------------------------------
   TABLA HORARIO SUCURSALES
   ------------------------------------- */
-- Crear tabla de horarios_sucursales
CREATE TABLE dbo.horarios_sucursales (
    nro_sucursal INT FOREIGN KEY REFERENCES sucursales(nro_sucursal),
    dia_semana VARCHAR(20) NOT NULL,
    hora_desde TIME NOT NULL,
    hora_hasta TIME NOT NULL,
    PRIMARY KEY (nro_sucursal, dia_semana)
);
-- Insert tabla de horarios sucursales
INSERT INTO dbo.horarios_sucursales (nro_sucursal, dia_semana, hora_desde, hora_hasta) VALUES
(1, 'Lunes', '08:00:00', '18:00:00'),
(1, 'Martes', '08:00:00', '18:00:00'),
(1, 'Miércoles', '08:00:00', '18:00:00'),
(1, 'Jueves', '08:00:00', '18:00:00'),
(1, 'Viernes', '08:00:00', '18:00:00'),

(2, 'Lunes', '09:00:00', '19:00:00'),
(2, 'Martes', '09:00:00', '19:00:00'),
(2, 'Miércoles', '09:00:00', '19:00:00'),
(2, 'Jueves', '09:00:00', '19:00:00'),
(2, 'Viernes', '09:00:00', '19:00:00'),

(3, 'Lunes', '08:30:00', '17:30:00'),
(3, 'Martes', '08:30:00', '17:30:00'),
(3, 'Miércoles', '08:30:00', '17:30:00'),
(3, 'Jueves', '08:30:00', '17:30:00'),
(3, 'Viernes', '08:30:00', '17:30:00'),

(4, 'Lunes', '10:00:00', '20:00:00'),
(4, 'Martes', '10:00:00', '20:00:00'),
(4, 'Miércoles', '10:00:00', '20:00:00'),
(4, 'Jueves', '10:00:00', '20:00:00'),
(4, 'Viernes', '10:00:00', '20:00:00');

/* -------------------------------------
   TABLA TIPOS SERVICIOS SUPERMERCADO
   ------------------------------------- */
-- Crear tabla de tipos_servicios_supermercado
CREATE TABLE dbo.tipos_servicios_supermercado (
    nro_tipo_servicio INT PRIMARY KEY,
    nom_tipo_servicio VARCHAR(100) NOT NULL
);
-- Insert tabla de tipos servicios supermercado
INSERT INTO dbo.tipos_servicios_supermercado (nro_tipo_servicio, nom_tipo_servicio) VALUES
(1, 'Delivery'),
(2, 'Compra Online');

/* -------------------------------------
   TABLA TIPOS SERVICIOS SUCURSALES
   ------------------------------------- */
-- Crear tabla de tipos_servicios_sucursales
CREATE TABLE dbo.tipos_servicios_sucursales (
    nro_sucursal INT FOREIGN KEY REFERENCES sucursales(nro_sucursal),
    nro_tipo_servicio INT FOREIGN KEY REFERENCES tipos_servicios_supermercado(nro_tipo_servicio),
    vigente VARCHAR NOT NULL,
    PRIMARY KEY (nro_sucursal, nro_tipo_servicio)
);
-- Insert tabla tipos servicios sucursales
INSERT INTO dbo.tipos_servicios_sucursales (nro_sucursal, nro_tipo_servicio, vigente) VALUES
(1, 1, 'S'),
(1, 2, 'S'),
(2, 1, 'S'),
(3, 1, 'S'),
(4, 2, 'S');

/* -------------------------------------
   TABLA RUBRO PRODUCTOS
   ------------------------------------- */
-- Crear tabla de rubros_productos
CREATE TABLE dbo.rubros_productos (
    nro_rubro INT PRIMARY KEY,
    nom_rubro VARCHAR(100) NOT NULL,
    vigente VARCHAR NOT NULL
);
-- Insert tabla rubros productos
INSERT INTO dbo.rubros_productos (nro_rubro, nom_rubro, vigente) VALUES
(1, 'Alimentos', 'S'),
(2, 'Bebidas', 'S'),
(3, 'Limpieza', 'S'),
(4, 'Higiene Personal', 'S');

/* -------------------------------------
   TABLA CATEGORIA PRODUCTOS
   ------------------------------------- */
-- Crear tabla de categorias_productos
CREATE TABLE dbo.categorias_productos (
    nro_categoria INT PRIMARY KEY,
    nom_categoria VARCHAR(100) NOT NULL,
    nro_rubro INT FOREIGN KEY REFERENCES rubros_productos(nro_rubro),
    vigente VARCHAR NOT NULL
);
-- Insert tabla categoria productos
INSERT INTO dbo.categorias_productos (nro_categoria, nom_categoria, nro_rubro, vigente) VALUES
(1, 'Lácteos', 1, 'S'),
(2, 'Gaseosas', 2, 'S'),
(3, 'Jabones', 4, 'S'),
(4, 'Detergentes', 3, 'S'),
(5, 'Jugos', 2, 'S');

/* -------------------------------------
   TABLA TIPOS PRODUCTOS
   ------------------------------------- */
-- Crear tabla de tipos_productos
CREATE TABLE dbo.tipos_productos (
    nro_tipo_producto INT PRIMARY KEY,
    nom_tipo_producto VARCHAR(100) NOT NULL
);
-- Insert tabla de tipos productos
INSERT INTO dbo.tipos_productos (nro_tipo_producto, nom_tipo_producto) VALUES
(1, 'Leche'),
(2, 'Yogur'),
(3, 'Gaseosa'),
(4, 'Detergente Líquido'),
(5, 'Jabón de Manos'),
(6, 'Jugo en Polvo'),
(7, 'Jugo en Botella');

/* -------------------------------------
   TABLA MARCAS PRODUCTOS
   ------------------------------------- */
-- Crear tabla de marcas_productos
CREATE TABLE dbo.marcas_productos (
    nro_marca INT PRIMARY KEY,
    nom_marca VARCHAR(100) NOT NULL,
    vigente VARCHAR NOT NULL
);
-- Insert tabla marcas productos
INSERT INTO dbo.marcas_productos (nro_marca, nom_marca, vigente) VALUES
(1, 'Marca A', 'S'),
(2, 'Marca B', 'S'),
(3, 'Marca C', 'S'),
(4, 'Marca D', 'S'),
(5, 'Marca E', 'S');

/* -------------------------------------
   TABLA TIPOS PRODUCTOS MARCAS
   ------------------------------------- */
-- Crear tabla de tipos_productos_marcas
CREATE TABLE dbo.tipos_productos_marcas (
    nro_marca INT FOREIGN KEY REFERENCES marcas_productos(nro_marca),
    nro_tipo_producto INT FOREIGN KEY REFERENCES tipos_productos(nro_tipo_producto),
    vigente VARCHAR NOT NULL,
    PRIMARY KEY (nro_marca, nro_tipo_producto)
);
-- Insert tabla tipos productos marcas
INSERT INTO dbo.tipos_productos_marcas (nro_marca, nro_tipo_producto, vigente) VALUES
(1, 1, 'S'),
(1, 2, 'S'),
(2, 3, 'S'),
(3, 4, 'S'), 
(3, 5, 'S'), 
(4, 6, 'S'), 
(5, 7, 'S'), 
(2, 4, 'S'); 

/* -------------------------------------
   TABLA PRODUCTOS
   ------------------------------------- */
-- Crear tabla de productos
CREATE TABLE dbo.productos (
    cod_barra VARCHAR(50) PRIMARY KEY,
    nom_producto VARCHAR(100) NOT NULL,
    desc_producto VARCHAR(255),
    imagen VARCHAR(255),
    nro_categoria INT FOREIGN KEY REFERENCES categorias_productos(nro_categoria),
    nro_marca INT FOREIGN KEY REFERENCES marcas_productos(nro_marca),
    nro_tipo_producto INT FOREIGN KEY REFERENCES tipos_productos(nro_tipo_producto),
    vigente VARCHAR NOT NULL
);
/* -------------------------------------
   INSERTS ADICIONALES PARA LA TABLA PRODUCTOS
   ------------------------------------- */
INSERT INTO dbo.productos (cod_barra, nom_producto, desc_producto, imagen, nro_categoria, nro_marca, nro_tipo_producto, vigente) VALUES
('1234567890126', 'Detergente Líquido Marca C', 'Detergente líquido para lavar platos', 'detergente_liquido.jpg', 4, 3, 4, 'S'),
('1234567890127', 'Jabón de Manos Marca C', 'Jabón líquido de manos', 'jabon_manos.jpg', 3, 3, 5, 'S'),
('1234567890128', 'Jugo en Polvo Marca D', 'Jugo en polvo sabor naranja', 'jugo_polvo.jpg', 5, 4, 6, 'S'),
('1234567890129', 'Jugo en Botella Marca E', 'Jugo en botella sabor durazno', 'jugo_botella.jpg', 5, 5, 7, 'S'),
('1234567890130', 'Leche Descremada 1L', 'Leche descremada en caja 1L', 'leche_descremada.jpg', 1, 1, 1, 'S'),
('1234567890131', 'Detergente Líquido Marca B', 'Detergente líquido Marca B', 'detergente_b.jpg', 4, 2, 4, 'S'),
('1234567890132', 'Jabón de Manos Marca C', 'Jabón de manos aroma a lavanda', 'jabon_lavanda.jpg', 3, 3, 5, 'S'),
('1234567890133', 'Coca Cola Zero 2L', 'Gaseosa Coca Cola sin azúcar 2L', 'coca_zero.jpg', 2, 2, 3, 'S'),
('1234567890134', 'Jugo en Botella Marca E', 'Jugo en botella sabor tropical', 'jugo_tropical.jpg', 5, 5, 7, 'S'),
('1234567890135', 'Yogur Natural 1L', 'Yogur natural sin azúcar', 'yogur_natural.jpg', 1, 1, 2, 'S'),
('1234567890136', 'Gaseosa Fanta 2L', 'Gaseosa sabor naranja 2L', 'fanta.jpg', 2, 2, 3, 'S'),
('1234567890137', 'Detergente Líquido Marca C', 'Detergente líquido concentrado', 'detergente_concentrado.jpg', 4, 3, 4, 'S'),
('1234567890138', 'Leche Descremada 1L Marca B', 'Leche descremada en caja 1L Marca B', 'leche_descremada_b.jpg', 1, 2, 1, 'S'),
('1234567890139', 'Yogur Sabor Durazno 1L', 'Yogur sabor durazno', 'yogur_durazno.jpg', 1, 1, 2, 'S'),
('1234567890140', 'Jugo en Polvo Marca D', 'Jugo en polvo sabor limón', 'jugo_limon.jpg', 5, 4, 6, 'S');


-- Crear tabla de productos_sucursales
CREATE TABLE dbo.productos_sucursales (
    nro_sucursal INT FOREIGN KEY REFERENCES sucursales(nro_sucursal),
    cod_barra VARCHAR(50) FOREIGN KEY REFERENCES productos(cod_barra),
    precio DECIMAL(18, 2) NOT NULL,
    vigente VARCHAR NOT NULL,
    PRIMARY KEY (nro_sucursal, cod_barra)
);
-- Inserts tabla productos sucursales
INSERT INTO dbo.productos_sucursales (nro_sucursal, cod_barra, precio, vigente) VALUES
(1, '1234567890126', 2500.00, 'S'), -- Detergente Líquido Marca C
(1, '1234567890127', 1300.00, 'S'), -- Jabón de Manos Marca C
(1, '1234567890128', 1110.00, 'S'), -- Jugo en Polvo Marca D
(1, '1234567890129', 2300.00, 'S'), -- Jugo en Botella Marca E
(1, '1234567890130', 1350.00, 'S'), -- Leche Descremada 1L
(1, '1234567890131', 2100.00, 'S'), -- Detergente Líquido Marca B
(1, '1234567890132', 1000.00, 'S'), -- Jabón de Manos Marca C'
(1, '1234567890133', 3100.00, 'S'), -- Coca Cola Zero 2L
(1, '1234567890134', 1900.00, 'S'), -- Jugo en Botella Marca E
(1, '1234567890135', 1850.00, 'S'), -- Yogur Natural 1L
(1, '1234567890136', 2900.00, 'S'), -- Gaseosa Fanta 2L
(1, '1234567890137', 2300.00, 'S'), -- Detergente Líquido Marca C
(1, '1234567890138', 1100.00, 'S'), -- Leche Descremada 1L Marca B
(1, '1234567890139', 1300.00, 'S'), -- Yogur Sabor Durazno 1L
(1, '1234567890140', 1000.00, 'S'); -- Jugo en Polvo Marca D


-- Seleccionar todos los registros de la tabla paises
SELECT * FROM dbo.paises;

-- Seleccionar todos los registros de la tabla provincias
SELECT * FROM dbo.provincias;

-- Seleccionar todos los registros de la tabla localidades
SELECT * FROM dbo.localidades;

-- Seleccionar todos los registros de la tabla provincias_localidades
SELECT * FROM dbo.provincias_localidades;

-- Seleccionar todos los registros de la tabla empresas_externas
SELECT * FROM dbo.empresas_externas;

-- Seleccionar todos los registros de la tabla supermercado
SELECT * FROM dbo.supermercado;

-- Seleccionar todos los registros de la tabla sucursales
SELECT * FROM dbo.sucursales;

-- Seleccionar todos los registros de la tabla horarios_sucursales
SELECT * FROM dbo.horarios_sucursales;

-- Seleccionar todos los registros de la tabla tipos_servicios_supermercado
SELECT * FROM dbo.tipos_servicios_supermercado;

-- Seleccionar todos los registros de la tabla tipos_servicios_sucursales
SELECT * FROM dbo.tipos_servicios_sucursales;

-- Seleccionar todos los registros de la tabla rubros_productos
SELECT * FROM dbo.rubros_productos;

-- Seleccionar todos los registros de la tabla categorias_productos
SELECT * FROM dbo.categorias_productos;

-- Seleccionar todos los registros de la tabla tipos_productos
SELECT * FROM dbo.tipos_productos;

-- Seleccionar todos los registros de la tabla marcas_productos
SELECT * FROM dbo.marcas_productos;

-- Seleccionar todos los registros de la tabla tipos_productos_marcas
SELECT * FROM dbo.tipos_productos_marcas;

-- Seleccionar todos los registros de la tabla productos
SELECT * FROM dbo.productos;

-- Seleccionar todos los registros de la tabla productos_sucursales
SELECT * FROM dbo.productos_sucursales;


/*
SELECT s.nro_sucursal, s.calle, s.nro_calle, s.telefonos, p.nom_producto, ps.precio
FROM sucursales s
JOIN productos_sucursales ps ON s.nro_sucursal = ps.nro_sucursal
JOIN productos p ON ps.cod_barra = p.cod_barra
WHERE s.habilitada = 'S' AND s.nro_localidad = nro_localidad;*/

/* -------------------------------------
   Procedimiento: get_lista_precios
   ------------------------------------- */
CREATE OR ALTER PROCEDURE dbo.get_lista_precios
AS
BEGIN
    SELECT p.cod_barra, p.nom_producto, ps.precio
    FROM dbo.productos_sucursales ps
    JOIN dbo.productos p ON ps.cod_barra = p.cod_barra
    GROUP BY p.cod_barra, p.nom_producto, ps.precio;
END;


--EXEC dbo.get_lista_precios;



--EXEC dbo.get_info_sucursales;

CREATE OR ALTER PROCEDURE dbo.get_info_sucursales
AS
BEGIN
    SELECT 
        s.nro_sucursal,
        s.calle,
        s.nro_calle,
        s.telefonos,
        s.coord_latitud,
        s.coord_longitud,
        s.habilitada,
        l.nom_localidad,
        p.nom_provincia,
        
        -- JSON para los horarios, cada día como un registro individual
        (
            SELECT 
                h.dia_semana AS dia,
                h.hora_desde AS apertura,
                h.hora_hasta AS cierre
            FROM 
                horarios_sucursales h
            WHERE 
                h.nro_sucursal = s.nro_sucursal
            FOR JSON PATH
        ) AS horarios,
		(
            SELECT 
                ts.nom_tipo_servicio AS tipo_servicio,
                tss.vigente
            FROM 
                tipos_servicios_sucursales tss
            INNER JOIN 
                tipos_servicios_supermercado ts ON tss.nro_tipo_servicio = ts.nro_tipo_servicio
            WHERE 
                tss.nro_sucursal = s.nro_sucursal
            FOR JSON PATH
        ) AS tipos_servicios

    FROM 
        sucursales s
    INNER JOIN 
        localidades l ON s.nro_localidad = l.nro_localidad
    INNER JOIN 
        provincias_localidades pl ON l.nro_localidad = pl.nro_localidad
    INNER JOIN 
        provincias p ON pl.cod_provincia = p.cod_provincia;
END;
