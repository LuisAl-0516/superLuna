CREATE DATABASE abarrotesLuna;
USE abarrotesLuna;

-- Tabla de Tipos de Usuario
CREATE TABLE tipoUsuarios (
    idTipoUsuario INT AUTO_INCREMENT PRIMARY KEY,
    descripcion VARCHAR(20)
);

-- Tabla de Usuarios
CREATE TABLE usuarios (
    idUsuario INT AUTO_INCREMENT PRIMARY KEY,
    nombreUsuario VARCHAR(10),
    pass VARCHAR(60), -- Longitud para contraseñas con hash
    idTipoUsuario INT,
    FOREIGN KEY (idTipoUsuario) REFERENCES tipoUsuarios(idTipoUsuario)
);

-- Tabla de Productos
CREATE TABLE productos (
    idProducto varchar(30) PRIMARY KEY,
    idTipo INT,
    nombreProducto VARCHAR(40),
    pzCaja INT,
    existencias INT,
    precioUnitario DECIMAL(8,2),
    precioMayoreo DECIMAL(8,2)
);

-- Tabla de Ventas
CREATE TABLE totalVentas (
    idVenta INT AUTO_INCREMENT PRIMARY KEY,
    total DECIMAL(10,2),
    efectivo DECIMAL(10,2),
    cambio DECIMAL(5,2),
    idUsuario INT,
    fecha DATETIME,
    FOREIGN KEY (idUsuario) REFERENCES usuarios(idUsuario)
);

-- Detalle de Venta
CREATE TABLE detalleVenta (
    idVenta INT,
    idVentaDetalle INT AUTO_INCREMENT PRIMARY KEY,
    idProducto varchar(30),
    subtotal DECIMAL(8,2),
    FOREIGN KEY (idVenta) REFERENCES totalVentas(idVenta),
    FOREIGN KEY (idProducto) REFERENCES productos(idProducto)
);

-- Tabla de Compras
CREATE TABLE compras (
    idCompra INT AUTO_INCREMENT PRIMARY KEY,
    totalCompra DECIMAL(10,2),
    efectivo DECIMAL(10,2),
    cambio DECIMAL(5,2),
    fechaCompra DATETIME
);

-- Detalle de Compra
CREATE TABLE detalleCompra (
    idCompra INT,
    idCompraDetalle INT AUTO_INCREMENT PRIMARY KEY,
    idProducto varchar(30),
    subtotalCompra DECIMAL(10,2),
    precioUni DECIMAL(6,2),
    cantidad INT,
    FOREIGN KEY (idCompra) REFERENCES compras(idCompra),
    FOREIGN KEY (idProducto) REFERENCES productos(idProducto)
);

CREATE TABLE precioActualizado (
    idActualizacion INT AUTO_INCREMENT PRIMARY KEY,
    idProducto varchar(30),
    precioAnterior DECIMAL(6,2),
    precioCompra DECIMAL(6,2),
    nuevoPrecio DECIMAL(6,2),
    idCompra int,
    idDetalleCompra int,
    fechaActualizacion DATETIME,
    FOREIGN KEY (idProducto) REFERENCES productos(idProducto)
);

create table tipoProducto (idTipo INT PRIMARY KEY,
						   tipoProd varchar(20));
ALTER TABLE productos ADD FOREIGN KEY (idTipo) REFERENCES tipoProducto(idTipo);
ALTER TABLE productos ADD idPresentacion INT;
CREATE TABLE presentacionProducto (idPresentacion INT AUTO_INCREMENT PRIMARY KEY,
								   presentacion VARCHAR(10),
                                   descripcion VARCHAR(30));
ALTER TABLE productos ADD FOREIGN KEY (idPresentacion) REFERENCES presentacionProducto(idPresentacion);
ALTER TABLE productos ADD contenedor INT;
ALTER TABLE presentacionProducto MODIFY presentacion VARCHAR(20);
ALTER TABLE productos MODIFY existencias DECIMAL(8,2);
ALTER TABLE productos MODIFY contenedor VARCHAR(30);
ALTER TABLE productos ADD cantidadMayoreo DECIMAL(3,2);
INSERT INTO tipoProducto (idTipo, tipoProd) VALUES (1, "ABARROTES");
INSERT INTO tipoProducto (idTipo, tipoProd) VALUES (2, "PANADERIA");
INSERT INTO tipoProducto (idTipo, tipoProd) VALUES (3, "VERDURAS");
INSERT INTO tipoProducto (idTipo, tipoProd) VALUES (4, "CREMERIA");
INSERT INTO tipoProducto (idTipo, tipoProd) VALUES (5, "BULTOS");
INSERT INTO presentacionProducto (presentacion, descripcion) VALUES ("INDIVIDUAL","INDIVIDUAL");
INSERT INTO presentacionProducto (presentacion, descripcion) VALUES ("PAQUETE CHICO","INDIVIDUAL");
INSERT INTO presentacionProducto (presentacion, descripcion) VALUES ("PAQUETE MEDIANO","CONTIENE PIEZAS INDIVIDUALES");
INSERT INTO presentacionProducto (presentacion, descripcion) VALUES ("PAQUETE GRANDE","CONTIENE PAUQUETES MEDIANOS");
INSERT INTO presentacionProducto (presentacion, descripcion) VALUES ("GRANEL","SE VENDE POR KILO");	
ALTER TABLE productos ADD cantidadMayoreo DECIMAL(6,2);

INSERT INTO tipoUsuarios (idTipoUsuario, descripcion) VALUES 
(1, 'ADMINISTRADOR'),
(2, 'GERENTE'),
(3, 'VENDEDOR');
INSERT INTO usuarios (nombreUsuario,pass,idTipoUsuario) VALUES ("LINO","ADMIN",1);

DROP TABLE detalleVenta;
DROP TABLE productos;

select * from precioActualizado;
describe productos;

SELECT dc.*
FROM detalleCompra dc
LEFT JOIN precioActualizado pa
  ON pa.idCompra = dc.idCompra
 AND pa.idDetalleCompra = dc.idCompraDetalle
WHERE pa.idDetalleCompra IS NULL;


