select count(1)
from parque
where id <> :id
  and nombre_parque = :nombre