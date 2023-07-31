package cl.awakelab.repaso.controller;

import cl.awakelab.repaso.entity.Factura;
import cl.awakelab.repaso.service.IFacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/factura")
public class FacturaController {

    @Autowired
    IFacturaService facturaService;

    // MUESTRA EL LISTADO
    @GetMapping
    public String listarFacturas(Model model) {
        List<Factura> listaFacturas = facturaService.listarFacturas();
        model.addAttribute("factura", listaFacturas);
        return "Facturas/listFacturas"; // Cambiar la vista que corresponda para mostrar el listado de facturas
    }

    // MUESTRA FORMULARIO DE GUARDAR
    @GetMapping("/creacion")
    public String mostrarFormularioCrearFactura(Model model) {
        Factura factura = new Factura();
        model.addAttribute("factura", factura);
        return "Facturas/createFactura"; // Cambiar la vista que corresponda para mostrar el formulario de crear factura
    }

    // GUARDA Y REDIRIGE AL LISTADO
    @PostMapping("/crearFactura")
    public String crearFactura(@ModelAttribute Factura facturaCrear) {
        facturaService.crearFactura(facturaCrear);
        return "redirect:/factura"; // Cambiar la URL que corresponda para redirigir al listado de facturas
    }

    // MUESTRA FORMULARIO DE EDITAR
    @GetMapping("/editar/{idFactura}")
    public String mostrarFormularioEditarFactura(@PathVariable int idFactura, Model model) {
        Factura facturaParaEditar = facturaService.buscarFacturaPorId(idFactura);
        model.addAttribute("factura", facturaParaEditar);
        return "Facturas/editFactura"; // Cambiar la vista que corresponda para mostrar el formulario de editar factura
    }

    // ACTUALIZAR Y REDIRIGE A LISTADO
    @PostMapping("/actualizar/{idFactura}")
    public String actualizarFactura(@ModelAttribute Factura facturaActualizar, @PathVariable int idFactura) {
        facturaService.actualizarFactura(idFactura, facturaActualizar);
        return "redirect:/factura"; // Cambiar la URL que corresponda para redirigir al listado de facturas
    }

    // ELIMINAR Y REDIRIGIR A LISTADO
    @PostMapping("/eliminar/{idFactura}")
    public String eliminarFactura(@PathVariable int idFactura, RedirectAttributes redirectAttributes) {
        facturaService.eliminarFactura(idFactura);
        return "redirect:/factura"; // Cambiar la URL que corresponda para redirigir al listado de facturas
    }
}

