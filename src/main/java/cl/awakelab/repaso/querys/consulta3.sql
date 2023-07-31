# Se solicita una lista con el monto que factura cada doctor, ordenados alfabéticamente de forma descendente,
# agrupados por el nombre del Doctor.

SELECT doctores.Nombre, SUM(facturas.Monto) AS TtalFacturado
FROM facturas
         JOIN Citas ON Citas.Factura_ID = Facturas.ID
         JOIN doctores ON Citas.Doctor_ID = doctores.ID
GROUP BY doctores.Nombre
ORDER BY doctores.Nombre DESC;
