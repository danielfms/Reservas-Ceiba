select v.id, v.id_avion, v.id_destino,v.fecha, v.duracion, d.ciudad_origen, d.ciudad_destino, a.matricula, d.valor_base
from vuelo v
inner join destino d on v.id_destino=d.id
inner join avion a on v.id_avion=a.id
where v.id=:id