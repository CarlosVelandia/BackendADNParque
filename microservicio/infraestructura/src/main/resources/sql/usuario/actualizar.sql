update usuario
set nombre_usuario = :nombre,
	clave = :clave,
	fecha_creacion = :fechaCreacion
where id = :id