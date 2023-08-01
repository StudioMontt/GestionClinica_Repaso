package cl.awakelab.repaso.restcontroller;

import cl.awakelab.repaso.entity.Cita;
import cl.awakelab.repaso.service.ICitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/cita")
public class CitaRestController {
    @Autowired
    ICitaService citaService;

    //(METODO GET PARA LISTAR)
    @GetMapping
    public List<Cita> listarCitas() {
        return citaService.listarCitas();
    }

    //(METODO POST PARA CREAR)
    @PostMapping("/crearCita")
    public Cita crearCita(@RequestBody Cita cita) {
        Cita citaNuevo = new Cita();
        citaNuevo.setId(cita.getId());
        citaNuevo.setFactura(cita.getFactura());
        citaNuevo.setFecha(cita.getFecha());
        citaNuevo.setPaciente(cita.getPaciente());
        citaNuevo.setDoctor(cita.getDoctor());
        return citaService.crearCita(citaNuevo);
    }

    //(METODO GET PARA BUSCAR POR ID)
    @GetMapping("/{id}")
    public Cita buscarCitaPorId(@PathVariable int id) {
        return citaService.buscarCitaPorId(id);
    }

    //(METODO PUT PARA ACTUALIZAR)
    @PutMapping("/{id}")
    public Cita actualizarCita(@RequestBody Cita citaActualizar, @PathVariable int id) {
        Cita cita = citaService.buscarCitaPorId(id);
        cita.setId(citaActualizar.getId());
        cita.setFactura(citaActualizar.getFactura());
        cita.setFecha(citaActualizar.getFecha());
        cita.setPaciente(citaActualizar.getPaciente());
        cita.setDoctor(citaActualizar.getDoctor());
        return citaService.actualizarCita(citaActualizar.getId(), cita);
    }

    //(METODO DELETE PARA ELIMINAR)
    @DeleteMapping("/{id}")
    public void eliminarCita(@PathVariable int id) {
        citaService.eliminarCita(id);

    }
}