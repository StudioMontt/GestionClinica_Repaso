package cl.awakelab.repaso.controller;

import cl.awakelab.repaso.entity.HistoriaClinica;
import cl.awakelab.repaso.service.IDoctorService;
import cl.awakelab.repaso.service.IHistoriaClinicaService;
import cl.awakelab.repaso.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/historiaclinica")
public class HistoriaClinicaController {

    @Autowired
    IHistoriaClinicaService historiaClinicaService;
    @Autowired
    IPacienteService pacienteService;
    @Autowired
    IDoctorService doctorService;

    // MUESTRA EL LISTADO
    @GetMapping
    public String listarHistoriasClinicas(Model model) {
        List<HistoriaClinica> listaHistoriasClinicas = historiaClinicaService.listarHistoriasClinicas();
        model.addAttribute("historiaclinica", listaHistoriasClinicas);
        return "HistoriasClinicas/listHistoriasClinicas"; // Cambiar la vista que corresponda para mostrar el listado de historias clínicas
    }

    // MUESTRA FORMULARIO DE GUARDAR
    @GetMapping("/creacion")
    public String mostrarFormularioCrearHistoriaClinica(Model model) {
        HistoriaClinica historiaClinica = new HistoriaClinica();
        model.addAttribute("historiaclinica", historiaClinica);
        return "HistoriasClinicas/createHistoriaClinica"; // Cambiar la vista que corresponda para mostrar el formulario de crear historia clínica
    }

    // GUARDA Y REDIRIGE AL LISTADO
    @PostMapping("/crearHistoriaClinica")
    public String crearHistoriaClinica(@ModelAttribute HistoriaClinica historiaClinicaCrear) {
        historiaClinicaCrear.setFechaCita(LocalDate.now());
        historiaClinicaService.crearHistoriaClinica(historiaClinicaCrear);
        return "redirect:/historiaclinica"; // Cambiar la URL que corresponda para redirigir al listado de historias clínicas
    }

    // MUESTRA FORMULARIO DE EDITAR
    @GetMapping("/editar/{idHistoriaClinica}")
    public String mostrarFormularioEditarHistoriaClinica(@PathVariable int idHistoriaClinica, Model model) {
        HistoriaClinica historiaClinicaParaEditar = historiaClinicaService.buscarHistoriaClinicaPorId(idHistoriaClinica);
        model.addAttribute("historiaclinica", historiaClinicaParaEditar);
        return "HistoriasClinicas/editHistoriaClinica"; // Cambiar la vista que corresponda para mostrar el formulario de editar historia clínica
    }

    // ACTUALIZAR Y REDIRIGE A LISTADO
    @PostMapping("/actualizar/{idHistoriaClinica}")
    public String actualizarHistoriaClinica(@ModelAttribute HistoriaClinica historiaClinicaActualizar, @PathVariable int idHistoriaClinica) {
        historiaClinicaService.actualizarHistoriaClinica(idHistoriaClinica, historiaClinicaActualizar);
        return "redirect:/historiaclinica"; // Cambiar la URL que corresponda para redirigir al listado de historias clínicas
    }

    // ELIMINAR Y REDIRIGIR A LISTADO
    @PostMapping("/eliminar/{idHistoriaClinica}")
    public String eliminarHistoriaClinica(@PathVariable int idHistoriaClinica, RedirectAttributes redirectAttributes) {
        historiaClinicaService.eliminarHistoriaClinica(idHistoriaClinica);
        return "redirect:/historiaclinica"; // Cambiar la URL que corresponda para redirigir al listado de historias clínicas
    }
}

