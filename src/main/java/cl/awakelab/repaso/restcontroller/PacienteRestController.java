package cl.awakelab.repaso.restcontroller;

import cl.awakelab.repaso.entity.Paciente;
import cl.awakelab.repaso.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/paciente", headers = "Accept=Application/json")
public class PacienteRestController {
    @Autowired
    IPacienteService pacienteService;

    //(METODO GET PARA LISTAR)
    @GetMapping
    public List<Paciente> listarPacientes() {
        return pacienteService.listarPacientes();
    }

    //(METODO POST PARA CREAR)
    @PostMapping("/crearPaciente")
    public Paciente crearPaciente(@RequestBody Paciente paciente) {
        Paciente pacienteNuevo = new Paciente();
        pacienteNuevo.setId(paciente.getId());
        pacienteNuevo.setNombre(paciente.getNombre());
        pacienteNuevo.setFechaNacimiento(paciente.getFechaNacimiento());
        return pacienteService.crearPaciente(pacienteNuevo);
    }

    //(METODO GET PARA BUSCAR POR ID)
    @GetMapping("/{id}")
    public Paciente buscarPacientePorId(@PathVariable int id) {
        return pacienteService.buscarPacientePorId(id);
    }

    //(METODO PUT PARA ACTUALIZAR)
    @PutMapping("/{id}")
    public Paciente actualizarPaciente(@RequestBody Paciente pacienteActualizar, @PathVariable int id) {
        Paciente paciente = pacienteService.buscarPacientePorId(id);
        paciente.setId(pacienteActualizar.getId());
        paciente.setNombre(pacienteActualizar.getNombre());
        paciente.setFechaNacimiento(pacienteActualizar.getFechaNacimiento());
        return pacienteService.actualizarPaciente(id, paciente);
    }

    //(METODO DELETE PARA ELIMINAR)
    @DeleteMapping("/{id}")
    public void eliminarPaciente(@PathVariable int id) {
        pacienteService.eliminarPaciente(id);
    }
}

