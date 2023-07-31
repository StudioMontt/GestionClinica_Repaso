package cl.awakelab.repaso.controller;

import cl.awakelab.repaso.entity.Paciente;
import cl.awakelab.repaso.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    IPacienteService pacienteService;

    // MUESTRA EL LISTADO
    @GetMapping
    public String listarPacientes(Model model) {
        List<Paciente> listaPacientes = pacienteService.listarPacientes();
        model.addAttribute("paciente", listaPacientes);
        return "Pacientes/listPacientes"; // Cambiar la vista que corresponda para mostrar el listado de pacientes
    }

    // MUESTRA FORMULARIO DE GUARDAR
    @GetMapping("/creacion")
    public String mostrarFormularioCrearPaciente(Model model) {
        Paciente paciente = new Paciente();
        model.addAttribute("paciente", paciente);
        return "Pacientes/createPaciente"; // Cambiar la vista que corresponda para mostrar el formulario de crear paciente
    }

    // GUARDA Y REDIRIGE AL LISTADO
    @PostMapping("/crearPaciente")
    public String crearPaciente(@ModelAttribute Paciente pacienteCrear) {
        pacienteService.crearPaciente(pacienteCrear);
        return "redirect:/paciente"; // Cambiar la URL que corresponda para redirigir al listado de pacientes
    }

    // MUESTRA FORMULARIO DE EDITAR
    @GetMapping("/editar/{idPaciente}")
    public String mostrarFormularioEditarPaciente(@PathVariable int idPaciente, Model model) {
        Paciente pacienteParaEditar = pacienteService.buscarPacientePorId(idPaciente);
        model.addAttribute("paciente", pacienteParaEditar);
        return "Pacientes/editPaciente"; // Cambiar la vista que corresponda para mostrar el formulario de editar paciente
    }

    // ACTUALIZAR Y REDIRIGE A LISTADO
    @PostMapping("/actualizar/{idPaciente}")
    public String actualizarPaciente(@ModelAttribute Paciente pacienteActualizar, @PathVariable int idPaciente) {
        pacienteService.actualizarPaciente(idPaciente, pacienteActualizar);
        return "redirect:/paciente"; // Cambiar la URL que corresponda para redirigir al listado de pacientes
    }

    // ELIMINAR Y REDIRIGIR A LISTADO
    @PostMapping("/eliminar/{idPaciente}")
    public String eliminarPaciente(@PathVariable int idPaciente, RedirectAttributes redirectAttributes) {
        pacienteService.eliminarPaciente(idPaciente);
        return "redirect:/paciente"; // Cambiar la URL que corresponda para redirigir al listado de pacientes
    }
}
