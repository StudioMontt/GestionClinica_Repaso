# Mostrar el nombre del doctor, la especialidad y la cantidad total de pacientes atendidos
# por cada uno, ordenados de mayor a menor cantidad de pacientes.

SELECT doctores.Nombre          AS Doctor,
       especialidades.Nombre    AS Especialidad,
       count(citas.Paciente_ID) AS Citas_por_Pacientes
FROM doctores
         JOIN citas on doctores.ID = citas.Doctor_ID
         JOIN especialidades ON doctores.Especialidad_ID = especialidades.ID
GROUP BY doctores.Nombre, especialidades.Nombre
ORDER BY count(citas.Paciente_ID) DESC;
