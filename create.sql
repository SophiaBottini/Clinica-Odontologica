DROP TABLE if EXISTS domicilios;
CREATE TABLE domicilios(ID iNT AUTO_INCREMENT PRIMARY KEY,
CALLE varchar(200) NOT NULL,
NUMERO INT NOT NULL,
LOCALIDAD varchar(100)NOT NULL,
PROVINCIA varchar(100) NOT NULL);

 DROP TABLE IF EXISTS odontologos;
 CREATE TABLE odontologos (
 ID INT AUTO_INCREMENT PRIMARY KEY,
 APELLIDO VARCHAR(100),
 NOMBRE VARCHAR(100),
 MATRICULA VARCHAR(100));



DROP TABLE if EXISTS pacientes;
CREATE TABLE pacientes(ID iNT AUTO_INCREMENT PRIMARY KEY,
APELLIDO varchar(100) NOT NULL,
NOMBRE varchar(100) NOT NULL,
DNI INT NOT NULL,
EMAIL varchar(100) NOT NULL,
FECHA_INGRESO DATE NOT NULL,
DOMICILIO_ID INT NOT NULL,
ODONTOLOGO_ID varchar(100) NOT NULL);


INSERT INTO ODONTOLOGOS (APELLIDO, NOMBRE, MATRICULA) VALUES ('Bottini','Brian','AA001');
INSERT INTO ODONTOLOGOS (APELLIDO, NOMBRE, MATRICULA) VALUES ('Skeppstedt','Marcelo','BB002');


INSERT INTO domicilios(calle,numero,localidad,provincia) VALUES('Calle A',474,'Cafayate','Salta');
INSERT INTO domicilios(calle,numero,localidad,provincia) VALUES('Calle B',808,'Oran','Salta');

INSERT INTO pacientes(apellido,nombre,dni,email,fecha_ingreso,domicilio_id,odontologo_id) VALUES('Bottini','Sophia',43030964,'sophiabg386@gmail.com','2022-03-01',1,1);
INSERT INTO pacientes(apellido,nombre,dni,email,fecha_ingreso,domicilio_id,odontologo_id) VALUES('Garay','Martina',45071650,'martina@gmail.com','2022-02-13',2,2);

