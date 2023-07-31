package cl.awakelab.repaso.restcontroller;

import cl.awakelab.repaso.entity.Especialidad;
import cl.awakelab.repaso.service.IEspecialidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/especialidad", headers = "Accept=Application/json")
public class EspecialidadRestController {
    @Autowired
    IEspecialidadService especialidadService;

    //(METODO GET PARA LISTAR)
    @GetMapping
    public List<Especialidad> listarEspecialidades() {
        return especialidadService.listarEspecialidades();
    }

    //(METODO POST PARA CREAR)
    @PostMapping("/crearEspecialidad")
    public Especialidad crearEspecialidad(@RequestBody Especialidad especialidad) {
        Especialidad especialidadNueva = new Especialidad();
        especialidadNueva.setId(especialidad.getId());
        especialidadNueva.setNombre(especialidad.getNombre());
        return especialidadService.crearEspecialidad(especialidadNueva);
    }

    //(METODO GET PARA BUSCAR POR ID)
    @GetMapping("/{id}")
    public Especialidad buscarEspecialidadPorId(@PathVariable int id) {
        return especialidadService.buscarEspecialidadPorId(id);
    }

    //(METODO PUT PARA ACTUALIZAR)
    @PutMapping("/{id}")
    public Especialidad actualizarEspecialidad(@RequestBody Especialidad especialidadActualizar, @PathVariable int id) {
        Especialidad especialidad = especialidadService.buscarEspecialidadPorId(id);
        especialidad.setId(especialidadActualizar.getId());
        especialidad.setNombre(especialidadActualizar.getNombre());
        return especialidadService.actualizarEspecialidad(id, especialidad);
    }

    //(METODO DELETE PARA ELIMINAR)
    @DeleteMapping("/{id}")
    public void eliminarEspecialidad(@PathVariable int id) {
        especialidadService.eliminarEspecialidad(id);
    }
}
