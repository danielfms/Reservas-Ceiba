update reserva
set id_vuelo = :id_vuelo,
	tipo_identificacion = :tipo_identificacion,
	numero_identificacion = :numero_identificacion,
	pasajeros = :pasajeros,
	valor_total = :valor_total,
	activa = :activa,
	token = :token,
	fecha_creacion = :fecha_creacion
where id = :id