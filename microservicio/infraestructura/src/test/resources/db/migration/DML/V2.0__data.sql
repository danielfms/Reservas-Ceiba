insert into usuario(nombre,clave,fecha_creacion) values('test','1234',now());
insert into avion(matricula, pasajeros) values ('AV1',9);
insert into destino(ciudad_origen, ciudad_destino, valor_base) values ('pereira','medellin',150000);
insert into vuelo(id_destino, id_avion, fecha, duracion) values (1, 1, '2020-12-01 14:00:00', 45);
insert into reserva(id_vuelo, tipo_identificacion, numero_identificacion, pasajeros, valor_total, activa, token) values (1,'CC', '12378444554', 1, 150000, TRUE, 'TOKEN');
