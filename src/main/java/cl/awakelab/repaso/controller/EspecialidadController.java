package cl.awakelab.repaso.controller;

import cl.awakelab.repaso.entity.Especialidad;
import cl.awakelab.repaso.service.IEspecialidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/especialidad")
public class EspecialidadController {

    @Autowired
    IEspecialidadService especialidadService;

    // MUESTRA EL LISTADO
    @GetMapping
    public String listarEspecialidades(Model model) {
        List<Especialidad> listaEspecialidades = especialidadService.listarEspecialidades();
        model.addAttribute("especialidad", listaEspecialidades);
        return "Especialidades/listEspecialidades"; // Cambiar la vista que corresponda para mostrar el listado de especialidades
    }

    // MUESTRA FORMULARIO DE GUARDAR
    @GetMapping("/creacion")
    public String mostrarFormularioCrearEspecialidad(Model model) {
        Especialidad especialidad = new Especialidad();
        model.addAttribute("especialidad", especialidad);
        return "Especialidades/createEspecialidad"; // Cambiar la vista que corresponda para mostrar el formulario de crear especialidad
    }

    // GUARDA Y REDIRIGE AL LISTADO
    @PostMapping("/crearEspecialidad")
    public String crearEspecialidad(@ModelAttribute Especialidad especialidadCrear) {
        especialidadService.crearEspecialidad(especialidadCrear);
        return "redirect:/especialidad"; // Cambiar la URL que corresponda para redirigir al listado de especialidades
    }

    // MUESTRA FORMULARIO DE EDITAR
    @GetMapping("/editar/{idEspecialidad}")
    public String mostrarFormularioEditarEspecialidad(@PathVariable int idEspecialidad, Model model) {
        Especialidad especialidadParaEditar = especialidadService.buscarEspecialidadPorId(idEspecialidad);
        model.addAttribute("especialidad", especialidadParaEditar);
        return "Especialidades/editEspecialidad"; // Cambiar la vista que corresponda para mostrar el formulario de editar especialidad
    }

    // ACTUALIZAR Y REDIRIGE A LISTADO
    @PostMapping("/actualizar/{idEspecialidad}")
    public String actualizarEspecialidad(@ModelAttribute Especialidad especialidadActualizar, @PathVariable int idEspecialidad) {
        especialidadService.actualizarEspecialidad(idEspecialidad, especialidadActualizar);
        return "redirect:/especialidad"; // Cambiar la URL que corresponda para redirigir al listado de especialidades
    }

    // ELIMINAR Y REDIRIGIR A LISTADO
    @PostMapping("/eliminar/{idEspecialidad}")
    public String eliminarEspecialidad(@PathVariable int idEspecialidad, RedirectAttributes redirectAttributes) {
        especialidadService.eliminarEspecialidad(idEspecialidad);
        return "redirect:/especialidad"; // Cambiar la URL que corresponda para redirigir al listado de especialidades
    }
}
