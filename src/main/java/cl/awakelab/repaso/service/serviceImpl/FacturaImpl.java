package cl.awakelab.repaso.service.serviceImpl;

import cl.awakelab.repaso.entity.Factura;
import cl.awakelab.repaso.repository.IFacturaRepository;
import cl.awakelab.repaso.service.IFacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class FacturaImpl implements IFacturaService {
    @Autowired
    IFacturaRepository facturaRepo;

    @Override
    public Factura crearFactura(Factura factura) {
        return facturaRepo.save(factura);
    }

    @Override
    public List<Factura> listarFacturas() {
        return facturaRepo.findAll();
    }

    @Override
    public Factura buscarFacturaPorId(int id) {
        return facturaRepo.findById(id).orElseThrow(() -> new NoSuchElementException("La Factura no fue encontrada"));
    }

    @Override
    public Factura actualizarFactura(int id, Factura facturaActualizar) {
        Factura factura = facturaRepo.findById(id).orElseThrow(() -> new NoSuchElementException("La Factura no fue encontrada"));
        factura.setId(facturaActualizar.getId());
        factura.setFechaPago(facturaActualizar.getFechaPago());
        factura.setMonto(facturaActualizar.getMonto());
        return facturaRepo.save(factura);
    }

    @Override
    public void eliminarFactura(int id) {
        facturaRepo.deleteById(id);
    }
}
