# Obtener el nombre de los pacientes que tienen citas programadas con un doctor cuya experiencia sea superior a 10 años.

SELECT pacientes.Nombre AS Paciente, doctores.Nombre AS Doctor, doctores.Experiencia AS AñosExperiencia
FROM pacientes
         LEFT JOIN citas ON pacientes.ID = citas.Paciente_ID
         LEFT JOIN doctores ON citas.Doctor_ID = doctores.ID
WHERE doctores.Experiencia < 10;