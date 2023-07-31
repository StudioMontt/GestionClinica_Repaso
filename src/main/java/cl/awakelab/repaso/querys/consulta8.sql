# Mostrar las especialidades médicas que tienen al menos un paciente registrado
# y ordenarlas alfabéticamente.

SELECT especialidades.Nombre AS Esp_con_Pacientes
FROM especialidades
         LEFT JOIN doctores ON especialidades.ID = doctores.Especialidad_ID
         JOIN citas ON doctores.ID = citas.Doctor_ID
GROUP BY especialidades.Nombre
ORDER BY especialidades.Nombre;