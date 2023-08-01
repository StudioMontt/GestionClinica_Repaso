package cl.awakelab.repaso.controller;

import cl.awakelab.repaso.entity.Cita;
import cl.awakelab.repaso.service.ICitaService;
import cl.awakelab.repaso.service.IDoctorService;
import cl.awakelab.repaso.service.IFacturaService;
import cl.awakelab.repaso.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/cita")
public class CitaController {

    @Autowired
    ICitaService citaService;
    @Autowired
    IPacienteService pacienteService;
    @Autowired
    IDoctorService doctorService;
    @Autowired
    IFacturaService facturaService;

    // MUESTRA EL LISTADO
    @GetMapping
    public String listarCitas(Model model) {
        List<Cita> listaCitas = citaService.listarCitas();
        model.addAttribute("cita", listaCitas);
        return "XXXX"; // Cambiar la vista que corresponda para mostrar el listado de citas
    }

    // MUESTRA FORMULARIO DE GUARDAR
    @GetMapping("/creacion")
    public String mostrarFormularioCrearCita(Model model) {
        Cita cita = new Cita();
        model.addAttribute("cita", cita);
        return "XXXX"; // Cambiar la vista que corresponda para mostrar el formulario de crear cita
    }

    // GUARDA Y REDIRIGE AL LISTADO
    @PostMapping("/crearCita")
    public String crearCita(@ModelAttribute Cita citaCrear) {
        citaService.crearCita(citaCrear);
        return "redirect:XXXX"; // Cambiar la URL que corresponda para redirigir al listado de citas
    }

    // MUESTRA FORMULARIO DE EDITAR
    @GetMapping("/editar/{idCita}")
    public String mostrarFormularioEditarCita(@PathVariable int idCita, Model model) {
        Cita citaParaEditar = citaService.buscarCitaPorId(idCita);
        model.addAttribute("cita", citaParaEditar);
        return "XXXX"; // Cambiar la vista que corresponda para mostrar el formulario de editar cita
    }

    // ACTUALIZAR Y REDIRIGE A LISTADO
    @PostMapping("/actualizar/{idCita}")
    public String actualizarCita(@ModelAttribute Cita citaActualizar, @PathVariable int idCita) {
        citaService.actualizarCita(idCita, citaActualizar);
        return "redirect:XXXX"; // Cambiar la URL que corresponda para redirigir al listado de citas
    }

    // ELIMINAR Y REDIRIGIR A LISTADO
    @PostMapping("/eliminar/{idCita}")
    public String eliminarCita(@PathVariable int idCita, RedirectAttributes redirectAttributes) {
        citaService.eliminarCita(idCita);
        return "redirect:"; // Cambiar la URL que corresponda para redirigir al listado de citas
    }
}
