# Mostrar el nombre de cada paciente y su fecha de nacimiento junto con el nombre del doctor que los atendió en
# su última cita, ordenado por nombre de paciente de forma ascendente.

SELECT pacientes.Nombre,
       pacientes.Fecha_Nacimiento       AS F_Nac,
       doctores.Nombre,
       MAX(historia_clinica.Fecha_Cita) AS Última_Cita
FROM pacientes
         JOIN historia_clinica ON pacientes.ID = historia_clinica.Paciente_ID
         JOIN doctores ON historia_clinica.Doctor_ID = doctores.ID
WHERE historia_clinica.Fecha_Cita = (SELECT MAX(Fecha_Cita)
                                     FROM historia_clinica
                                     WHERE Paciente_ID = pacientes.ID)
GROUP BY pacientes.Nombre, pacientes.Fecha_Nacimiento, doctores.Nombre
ORDER BY pacientes.Nombre;
