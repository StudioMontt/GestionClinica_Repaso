package cl.awakelab.repaso.controller;


import cl.awakelab.repaso.entity.Doctor;
import cl.awakelab.repaso.service.IDoctorService;
import cl.awakelab.repaso.service.IEspecialidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    IDoctorService doctorService;
    @Autowired
    IEspecialidadService especialidadService;

    // MUESTRA EL LISTADO
    @GetMapping
    public String listarDoctores(Model model) {
        List<Doctor> listaDoctores = doctorService.listarDoctores();
        model.addAttribute("doctor", listaDoctores);
        return "Doctors/listDoctors"; // Cambiar la vista que corresponda para mostrar el listado de doctores
    }

    // MUESTRA FORMULARIO DE GUARDAR
    @GetMapping("/creacion")
    public String mostrarFormularioCrearDoctor(Model model) {
        Doctor doctor = new Doctor();
        model.addAttribute("doctor", doctor);
        return "Doctors/createDoctor"; // Cambiar la vista que corresponda para mostrar el formulario de crear doctor
    }

    // GUARDA Y REDIRIGE AL LISTADO
    @PostMapping("/crearDoctor")
    public String crearDoctor(@ModelAttribute Doctor doctorCrear) {
        doctorService.crearDoctor(doctorCrear);
        return "redirect:/doctor"; // Cambiar la URL que corresponda para redirigir al listado de doctores
    }

    // MUESTRA FORMULARIO DE EDITAR
    @GetMapping("/editar/{idDoctor}")
    public String mostrarFormularioEditarDoctor(@PathVariable int idDoctor, Model model) {
        Doctor doctorParaEditar = doctorService.buscarDoctorPorId(idDoctor);
        model.addAttribute("doctor", doctorParaEditar);
        return "Doctors/editDoctor"; // Cambiar la vista que corresponda para mostrar el formulario de editar doctor
    }

    // ACTUALIZAR Y REDIRIGE A LISTADO
    @PostMapping("/actualizar/{idDoctor}")
    public String actualizarDoctor(@ModelAttribute Doctor doctorActualizar, @PathVariable int idDoctor) {
        doctorService.actualizarDoctor(idDoctor, doctorActualizar);
        return "redirect:/doctor"; // Cambiar la URL que corresponda para redirigir al listado de doctores
    }

    // ELIMINAR Y REDIRIGIR A LISTADO
    @PostMapping("/eliminar/{idDoctor}")
    public String eliminarDoctor(@PathVariable int idDoctor, RedirectAttributes redirectAttributes) {
        doctorService.eliminarDoctor(idDoctor);
        return "redirect:/doctor"; // Cambiar la URL que corresponda para redirigir al listado de doctores
    }
}

