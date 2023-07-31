# Obtener la cantidad promedio de años de experiencia de los doctores en cada especialidad.

SELECT ROUND(AVG(doctores.Experiencia), 1) AS Prom_Años_Exp, especialidades.Nombre AS Especialidad
FROM doctores
         JOIN especialidades ON doctores.Especialidad_ID = especialidades.ID
GROUP BY especialidades.Nombre;
