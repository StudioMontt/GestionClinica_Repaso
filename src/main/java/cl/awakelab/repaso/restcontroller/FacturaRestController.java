package cl.awakelab.repaso.restcontroller;

import cl.awakelab.repaso.entity.Factura;
import cl.awakelab.repaso.service.IFacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/factura", headers = "Accept=Application/json")
public class FacturaRestController {
    @Autowired
    IFacturaService facturaService;

    //(METODO GET PARA LISTAR)
    @GetMapping
    public List<Factura> listarFacturas() {
        return facturaService.listarFacturas();
    }

    //(METODO POST PARA CREAR)
    @PostMapping("/crearFactura")
    public Factura crearFactura(@RequestBody Factura factura) {
        Factura facturaNueva = new Factura();
        facturaNueva.setId(factura.getId());
        facturaNueva.setFechaPago(factura.getFechaPago());
        facturaNueva.setMonto(factura.getMonto());
        return facturaService.crearFactura(facturaNueva);
    }

    //(METODO GET PARA BUSCAR POR ID)
    @GetMapping("/{id}")
    public Factura buscarFacturaPorId(@PathVariable int id) {
        return facturaService.buscarFacturaPorId(id);
    }

    //(METODO PUT PARA ACTUALIZAR)
    @PutMapping("/{id}")
    public Factura actualizarFactura(@RequestBody Factura facturaActualizar, @PathVariable int id) {
        Factura factura = facturaService.buscarFacturaPorId(id);
        factura.setId(facturaActualizar.getId());
        factura.setFechaPago(facturaActualizar.getFechaPago());
        factura.setMonto(facturaActualizar.getMonto());
        return facturaService.actualizarFactura(id, factura);
    }

    //(METODO DELETE PARA ELIMINAR)
    @DeleteMapping("/{id}")
    public void eliminarFactura(@PathVariable int id) {
        facturaService.eliminarFactura(id);
    }
}

