# Obtener el nombre y la especialidad de los doctores que no tienen ninguna cita registrada.

SELECT doctores.Nombre AS Nombre_Doctor, especialidades.Nombre AS Especialidad
FROM doctores
         LEFT JOIN citas ON doctores.ID = citas.Doctor_ID
         JOIN especialidades ON doctores.Especialidad_ID = especialidades.ID
WHERE citas.Doctor_ID IS NULL;