select id,nombre,codigo,direccion,telefono
from tiquete

select alquiler.id,alquiler.fecha_alquiler,alquiler.fecha_entrega,alquiler.valor_pago,
       cliente.id as id_cliente, cliente.nombre, cliente.direccion, cliente.telefono, cliente.cedula, cliente.correo,
       moto.id as id_moto, moto.matricula, moto.marca, moto.modelo, moto.tipo_moto, moto.kilometros_recorridos, moto.precio_alquiler
from alquiler
         inner join cliente on alquiler.cliente_id = cliente.id
         inner join moto on alquiler.moto_id = moto.id