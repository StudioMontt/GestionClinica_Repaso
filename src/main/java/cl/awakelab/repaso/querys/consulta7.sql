# Mostrar la cantidad total de facturas emitidas y el monto total facturado
# hasta la fecha actual.

SELECT COUNT(*) AS Facturas_Emitidas, SUM(Monto) AS Monto_Facturado
FROM facturas;