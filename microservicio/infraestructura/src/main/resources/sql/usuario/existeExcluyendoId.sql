select count(1)
from usuario
where id <> :id
  and nombre_usuario = :nombre