create database db_citysecurity;

CREATE TABLE "role" (
                      id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
                      rol VARCHAR(50)
);

CREATE TABLE "user" (
                        id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
                        nombre VARCHAR(50),
                        apellido VARCHAR(50),
                        email VARCHAR(50),
                        password VARCHAR(50),
                        id_role UUID,
                        fecha_contratacion DATE,
                        FOREIGN KEY (id_rol) REFERENCES ROLE(id) on delete cascade
);

insert into role (rol)
values
    ('Visitante'),
    ('Administrador'),
    ('Residente');
select * from role


/** Insertando usuarios a la tabla**/
INSERT INTO "user" (nombre, apellido, email, password, id_role, fecha_contratacion)
VALUES
    ('Juan', 'Perez', 'juanperez@gmail.com', '1234', 'b4803a7c-3c2a-4735-9fb8-3150423814ca', '2021-01-01'),
    ('Maria', 'Lopez', 'marialopez@gmail.com', 'password1', '336b99d6-13ff-451c-b5be-e094514b7a79', '2022-02-15'),
    ('Carlos', 'Gomez', 'carlosgomez@gmail.com', 'securepwd', '336b99d6-13ff-451c-b5be-e094514b7a79', '2021-03-22'),
    ('Ana', 'Martinez', 'anamartinez@gmail.com', 'mypassword', 'b4803a7c-3c2a-4735-9fb8-3150423814ca', '2023-07-30'),
    ('Luis', 'Fernandez', 'luisfernandez@gmail.com', 'pass123', '2c28d5c4-da17-4381-acbf-ac915de16381', '2020-11-12');
    select*from "user"

/********* COMANDOS ESPECIALES ************/
/** para correr una base de datos hay que cerrar la conexion**/
delete from db_citysecurity;
/** comando para limpiar la tabla users**/
TRUNCATE TABLE "user";



