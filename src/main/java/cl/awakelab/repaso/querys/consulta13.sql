# Obtener la lista de citas programadas para los próximos 7 días a partir de la fecha
# actual. La consulta debe mostrar el nombre del paciente, el nombre del doctor y la
# fecha de la cita.

SELECT pacientes.Nombre AS Nombre_Paciente, doctores.Nombre AS Nombre_Doctor, citas.Fecha AS Fecha_Cita
FROM citas
         JOIN pacientes ON citas.Paciente_ID = pacientes.ID
         JOIN doctores ON citas.Doctor_ID = doctores.ID
WHERE citas.Fecha BETWEEN CURDATE() AND DATE_ADD(CURDATE(), INTERVAL 7 DAY)
ORDER BY citas.Fecha;

