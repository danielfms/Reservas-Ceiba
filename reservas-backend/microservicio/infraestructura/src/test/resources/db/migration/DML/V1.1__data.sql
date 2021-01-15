insert into avion(id, matricula, pasajeros) values (1,'AV3',9);
insert into destino(id, ciudad_origen, ciudad_destino, valor_base) values (1,'pereira','medellin',150000);
insert into vuelo(id, id_destino, id_avion, fecha, duracion) values (1,1, 1, '2020-12-01 14:00:00', 45);
insert into reserva(id, id_vuelo, tipo_identificacion, numero_identificacion, pasajeros, valor_total, activa, token) values (1, 1,'CC', '12378444554', 1, 150000, TRUE, 'TOKEN');
