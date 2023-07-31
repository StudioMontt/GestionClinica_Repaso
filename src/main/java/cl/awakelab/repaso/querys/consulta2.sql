# Se solicita mostrar el nombre de cada paciente y el nombre del doctor con el que tienen una cita asignada.

SELECT pacientes.Nombre AS Paciente, doctores.Nombre AS Doctor, Fecha
FROM citas
         JOIN pacientes ON citas.Paciente_ID = pacientes.id
         JOIN doctores ON citas.Doctor_ID = doctores.id;