# Mostrar la fecha de nacimiento y el nombre de los pacientes que no tienen
# ninguna factura asociada.

SELECT Fecha_Nacimiento, Nombre
FROM pacientes
         JOIN citas ON pacientes.ID = citas.Paciente_ID
         LEFT JOIN facturas ON citas.Factura_ID = facturas.ID
WHERE Monto IS NULL;