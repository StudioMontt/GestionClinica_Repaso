package cl.awakelab.repaso.service
        ;

import cl.awakelab.repaso.entity.Factura;

import java.util.List;

public interface IFacturaService {

    Factura crearFactura(Factura factura);

    List<Factura> listarFacturas();

    Factura buscarFacturaPorId(int id);

    Factura actualizarFactura(int id, Factura facturaActualizar);

    void eliminarFactura(int id);
}

