




insert into profesores(nombre,apellido,edad) values ('Luis Marco','Calderon Gutierres',40);

--insert into bibliotecas(titulo,autor,fecha_salida,fecha_entrada,estudiante_id) values ('La Casa Alemana','Annette Hess','2019-10-09','2019-10-09',1);
--insert into bibliotecas(titulo,autor,fecha_salida,fecha_entrada,estudiante_id) values ('La Sospecha De Sofia','Paloma Sanchez Garnica','2019-09-09','2019-10-09',1);

--insert into bibliotecas(titulo,autor,estudiante_id) values ('Si yo fuera un leon','Isabel Pin',null);
--insert into bibliotecas(titulo,autor,estudiante_id) values ('Cocodrilo','Antonio R. y Oscar V.',null);
--insert into bibliotecas(titulo,autor,estudiante_id) values ('Los instrumentos','Timunmas',null);

/*Usuarios y Roles*/
insert into usuarios(username, password, enabled, nombre, apellido, email) values('admin', '$2a$10$3jT4pD233nWtacp5a8TS/u6JYqbX.z6CiPlv0q7IjyN8t.YAEVXyK', 1, 'javier', 'camacho', 'javier@hotmail.com');
insert into usuarios(username, password, enabled, nombre, apellido, email) values('user', '$2a$10$gIpZlr4DRztHHD0lCktCf.HSogOC0h8/Qu7i0PBcWvxtokxO/hSqC', 1, 'marcelo', 'perez', 'marcelo@hotmail.com');

insert into roles(nombre) values('ROLE_ADMIN');
insert into roles(nombre) values('ROLE_TECNO');

insert into usuarios_roles(usuario_id, role_id) values(1,1);
insert into usuarios_roles(usuario_id, role_id) values(1,2);
insert into usuarios_roles(usuario_id, role_id) values(2,2);

/*Titulares*/
insert into conyugues(primernombre,segundoNombre,apellidopaterno,apellidomaterno,apellidocasada,ci,profesion,lugartrabajo,telefonotrabajo,celular,correo,sexo,lugarnacimiento) values ('Marta','Maria','Orellana','Oretga','Veizaga',280036,'profesora','colegio adela',429211,70390617,'marcelao@hotmail.com','femenino','xxxxxxx');
insert into titulares(codigotitular,primernombre,segundonombre,apellidopaterno,apellidomaterno,ci,profesion,lugartrabajo,telefonotrabajo,celular,correo,sexo,activo,observado,inscribir,fecha_ingreso,fecha_baja,fecha_nacimiento,lugarnacimiento,estadocivil,direccion,conyugue_id) values (1234,'Marco','Marcelo','Veizaga','Iliarte',280036,'Ing. civil','gobierno de cochabamba',429211,70390617,'perdro@hotmail.com','masculino',1,0,1,'2019-10-09',null,'2019-10-09','cochabamba','casado','xxxxxxxxx',1);

/*Estudiantes*/
insert into estudiantes(codigotitular,codigo_alumno,nombre_completo,apellido_completo,fecha_nacimiento,ci,sexo,direccion,telefono,fecha_ingreso,inscribir,promovido,baja,curso_retiro,banda,observado,texto_observado,profesor_id,titular_id) values (1234,12341,'Edson Percy','Lopez Cortez','2019-10-09',123,'masculino','xxxxx',123456,'2019-10-09',1,0,0,0,1,0,'',null,1);
insert into estudiantes(codigotitular,codigo_alumno,nombre_completo,apellido_completo,fecha_nacimiento,ci,sexo,direccion,telefono,fecha_ingreso,inscribir,promovido,baja,curso_retiro,banda,observado,texto_observado,profesor_id,titular_id) values (1234,12342,'Roberto Mauricio','Cacer Pericon','2019-10-09',1234,'masculino','xxxxx',123456,'2019-10-09',1,0,0,0,1,0,'',null,1);
insert into estudiantes(codigotitular,codigo_alumno,nombre_completo,apellido_completo,fecha_nacimiento,ci,sexo,direccion,telefono,fecha_ingreso,inscribir,promovido,baja,curso_retiro,banda,observado,texto_observado,profesor_id,titular_id) values (1234,12343,'Carla Maria','Rivera Ortuño','2019-10-09',12345,'femenino','xxxxx',123456,'2019-10-09',1,0,0,0,0,0,'',null,1);
--insert into estudiantes(codigotitular,codigo_alumno,nombre_completo,apellido_completo,fecha_nacimiento,ci,sexo,direccion,telefono,fecha_ingreso,inscribir,promovido,baja,curso_retiro,banda,observado,texto_observado,profesor_id,titular_id) values (1234,12344,'Jorge Manuel','Sespedes Alcorser','2019-10-09',123456,'masculino','xxxxx',123456,'2019-10-09',0,0,0,0,1,0,'',null,1);
--insert into estudiantes(nombre,apellido,ci,profesor_id) values ('Mauricio','Lopez Contreras',4444444,1);
--insert into estudiantes(codigotitular,nombre,apellido,ci) values ('Rafael','Rorrico Quinteros',5555555);

/*Cursos*/
insert into cursos(codigo_curso,curso,id_curso,nivel,paralelo) values(101,'PRE-KINDER NUBE','AA','INICIAL','I1A');
insert into cursos(codigo_curso,curso,id_curso,nivel,paralelo) values(102,'PRE-KINDER ESTRELLA','AB','INICIAL','I1B');
insert into cursos(codigo_curso,curso,id_curso,nivel,paralelo) values(103,'KINDER LUNA','AC','INICIAL','I2B');
insert into cursos(codigo_curso,curso,id_curso,nivel,paralelo) values(104,'KINDER SOL','AD','INICIAL','I2A');
insert into cursos(codigo_curso,curso,id_curso,nivel,paralelo) values(105,'PRE-KINDER','AE','INICIAL','I1C');
insert into cursos(codigo_curso,curso,id_curso,nivel,paralelo) values(106,'KINDER','AF','INICIAL','I2C');
insert into cursos(codigo_curso,curso,id_curso,nivel,paralelo) values(201,'1º "A" PRIMARIA','BA','PRIMARIA','P1A');
insert into cursos(codigo_curso,curso,id_curso,nivel,paralelo) values(202,'1º "B" PRIMARIA','BB','PRIMARIA','P1B');
insert into cursos(codigo_curso,curso,id_curso,nivel,paralelo) values(203,'1º "C" PRIMARIA','BC','PRIMARIA','P1C');
insert into cursos(codigo_curso,curso,id_curso,nivel,paralelo) values(204,'1º PRIMARIA','BD','PRIMARIA','P1E');
insert into cursos(codigo_curso,curso,id_curso,nivel,paralelo) values(205,'2º "A" PRIMARIA','CA','PRIMARIA','P2A');
insert into cursos(codigo_curso,curso,id_curso,nivel,paralelo) values(206,'2º "B" PRIMARIA','CB','PRIMARIA','P2B');
insert into cursos(codigo_curso,curso,id_curso,nivel,paralelo) values(207,'2º "C" PRIMARIA','CC','PRIMARIA','P2C');
insert into cursos(codigo_curso,curso,id_curso,nivel,paralelo) values(208,'2º PRIMARIA','DD','PRIMARIA','P2E');
insert into cursos(codigo_curso,curso,id_curso,nivel,paralelo) values(209,'2º "3º "A" PRIMARIA','DA','PRIMARIA','P3A');
insert into cursos(codigo_curso,curso,id_curso,nivel,paralelo) values(210,'3º "B" PRIMARIA','DB','PRIMARIA','P3B');
insert into cursos(codigo_curso,curso,id_curso,nivel,paralelo) values(211,'3º "C" PRIMARIA','DC','PRIMARIA','P3C');
insert into cursos(codigo_curso,curso,id_curso,nivel,paralelo) values(212,'2º "3º PRIMARIA','DD','PRIMARIA','P3E');
insert into cursos(codigo_curso,curso,id_curso,nivel,paralelo) values(213,'2º "4º "A" PRIMARIA','EA','PRIMARIA','P4A');
insert into cursos(codigo_curso,curso,id_curso,nivel,paralelo) values(214,'2º "4º "B" PRIMARIA','EB','PRIMARIA','P4B');
insert into cursos(codigo_curso,curso,id_curso,nivel,paralelo) values(215,'2º "4º "C" PRIMARIA','EC','PRIMARIA','P4C');
insert into cursos(codigo_curso,curso,id_curso,nivel,paralelo) values(216,'4º PRIMARIA','ED','PRIMARIA','P4E');
insert into cursos(codigo_curso,curso,id_curso,nivel,paralelo) values(217,'5º "A" PRIMARIA','FA','PRIMARIA','P5A');
insert into cursos(codigo_curso,curso,id_curso,nivel,paralelo) values(218,'5º "B" PRIMARIA','FB','PRIMARIA','P5B');
insert into cursos(codigo_curso,curso,id_curso,nivel,paralelo) values(219,'5º "C" PRIMARIA','FC','PRIMARIA','P5C');
insert into cursos(codigo_curso,curso,id_curso,nivel,paralelo) values(220,'5º PRIMARIA','FD','PRIMARIA','P5E');
insert into cursos(codigo_curso,curso,id_curso,nivel,paralelo) values(221,'6º "A" PRIMARIA','GA','PRIMARIA','P6A');
insert into cursos(codigo_curso,curso,id_curso,nivel,paralelo) values(222,'6º "B" PRIMARIA','GB','PRIMARIA','P6B');
insert into cursos(codigo_curso,curso,id_curso,nivel,paralelo) values(223,'6º "C" PRIMARIA','GC','PRIMARIA','P6C');
insert into cursos(codigo_curso,curso,id_curso,nivel,paralelo) values(224,'6º PRIMARIA','GD','PRIMARIA','P6E');
insert into cursos(codigo_curso,curso,id_curso,nivel,paralelo) values(301,'1º "A" SECUNDARIA','HA','SECUNDARIA','S1A');
insert into cursos(codigo_curso,curso,id_curso,nivel,paralelo) values(302,'1º "B" SECUNDARIA','HB','SECUNDARIA','S1B');
insert into cursos(codigo_curso,curso,id_curso,nivel,paralelo) values(303,'1º "C" SECUNDARIA','HC','SECUNDARIA','S1C');
insert into cursos(codigo_curso,curso,id_curso,nivel,paralelo) values(304,'61º SECUNDARIA','HD','SECUNDARIA','S1E');
insert into cursos(codigo_curso,curso,id_curso,nivel,paralelo) values(305,'2º "A" SECUNDARIA','IA','SECUNDARIA','S2A');
insert into cursos(codigo_curso,curso,id_curso,nivel,paralelo) values(306,'2º "B" SECUNDARIA','IB','SECUNDARIA','S2B');
insert into cursos(codigo_curso,curso,id_curso,nivel,paralelo) values(307,'2º "C" SECUNDARIA','IC','SECUNDARIA','S2C');
insert into cursos(codigo_curso,curso,id_curso,nivel,paralelo) values(308,'2º SECUNDARIA','ID','SECUNDARIA','S2E');
insert into cursos(codigo_curso,curso,id_curso,nivel,paralelo) values(309,'3º "A" SECUNDARIA','JA','SECUNDARIA','S3A');
insert into cursos(codigo_curso,curso,id_curso,nivel,paralelo) values(310,'3º "B" SECUNDARIA','JB','SECUNDARIA','S3B');
insert into cursos(codigo_curso,curso,id_curso,nivel,paralelo) values(311,'3º "C" SECUNDARIA','JC','SECUNDARIA','S3C');
insert into cursos(codigo_curso,curso,id_curso,nivel,paralelo) values(312,'3º SECUNDARIA','JD','SECUNDARIA','S3D');
insert into cursos(codigo_curso,curso,id_curso,nivel,paralelo) values(313,'4º "A" SECUNDARIA','KA','SECUNDARIA','S4A');
insert into cursos(codigo_curso,curso,id_curso,nivel,paralelo) values(314,'4º "B" SECUNDARIA','KB','SECUNDARIA','S4B');
insert into cursos(codigo_curso,curso,id_curso,nivel,paralelo) values(315,'4º "C" SECUNDARIA','KC','SECUNDARIA','S4C');
insert into cursos(codigo_curso,curso,id_curso,nivel,paralelo) values(316,'4º SECUNDARIA','KD','SECUNDARIA','S4D');
insert into cursos(codigo_curso,curso,id_curso,nivel,paralelo) values(317,'5º "A" SECUNDARIA','LA','SECUNDARIA','S5A');
insert into cursos(codigo_curso,curso,id_curso,nivel,paralelo) values(318,'5º "B" SECUNDARIA','LB','SECUNDARIA','S5B');
insert into cursos(codigo_curso,curso,id_curso,nivel,paralelo) values(319,'5º "C" SECUNDARIA','LC','SECUNDARIA','S5E');
insert into cursos(codigo_curso,curso,id_curso,nivel,paralelo) values(320,'45º SECUNDARIA','LD','SECUNDARIA','S5D');
insert into cursos(codigo_curso,curso,id_curso,nivel,paralelo) values(321,'6º "A" SECUNDARIA','MA','SECUNDARIA','S6A');
insert into cursos(codigo_curso,curso,id_curso,nivel,paralelo) values(322,'6º "B" SECUNDARIA','MB','SECUNDARIA','S6B');
insert into cursos(codigo_curso,curso,id_curso,nivel,paralelo) values(323,'6º "C" SECUNDARIA','MC','SECUNDARIA','S6E');






























