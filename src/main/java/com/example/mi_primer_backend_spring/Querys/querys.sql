create database db_citysecurity;
CREATE TABLE "user" (
                        id SERIAL PRIMARY KEY,
                        nombre VARCHAR(50),
                        apellido VARCHAR(50),
                        email VARCHAR(50),
                        password VARCHAR(50),
                        rol VARCHAR(50),
                        fecha_contratacion DATE
);

/** comando para ver la tabla users**/
select*from "user"

/** Insertando usuarios a la tabla**/
INSERT INTO "user" (nombre, apellido, email, password, rol, fecha_contratacion)
VALUES
    ('Juan', 'Perez', 'juanperez@gmailcom', '1234', 'admin', '2021-01-01'),
    ('Maria', 'Lopez', 'marialopez@gmail.com', 'password1', 'user', '2022-02-15'),
    ('Carlos', 'Gomez', 'carlosgomez@gmail.com', 'securepwd', 'user', '2021-03-22'),
    ('Ana', 'Martinez', 'anamartinez@gmail.com', 'mypassword', 'admin', '2023-07-30'),
    ('Luis', 'Fernandez', 'luisfernandez@gmail.com', 'pass123', 'user', '2020-11-12');


/********* COMANDOS ESPECIALES ************/
/** para correr una base de datos hay que cerrar la conexion**/
delete from db_citysecurity;
/** comando para limpiar la tabla users**/
TRUNCATE TABLE "user";
