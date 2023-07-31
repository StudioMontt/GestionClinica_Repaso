# Mostrar las facturas que tienen un monto superior a la media de los montos de todas
# las facturas registradas.

SELECT facturas.Monto AS Fact_sobre_la_media
FROM facturas
WHERE facturas.Monto BETWEEN (SELECT AVG(Monto) FROM facturas) AND (SELECT MAX(Monto) FROM facturas)
ORDER BY Monto DESC;
