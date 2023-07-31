package cl.awakelab.repaso.restcontroller;

import cl.awakelab.repaso.entity.Doctor;
import cl.awakelab.repaso.service.IDoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/doctor", headers = "Accept=Application/json")
public class DoctorRestController {
    @Autowired
    IDoctorService doctorService;

    //(METODO GET PARA LISTAR)
    @GetMapping
    public List<Doctor> listarDoctores() {
        return doctorService.listarDoctores();
    }

    //(METODO POST PARA CREAR)
    @PostMapping("/crearDoctor")
    public Doctor crearDoctor(@RequestBody Doctor doctor) {
        Doctor doctorNuevo = new Doctor();
        doctorNuevo.setId(doctor.getId());
        doctorNuevo.setNombre(doctor.getNombre());
        doctorNuevo.setEspecialidad(doctor.getEspecialidad());
        doctorNuevo.setExperiencia(doctor.getExperiencia());
        return doctorService.crearDoctor(doctorNuevo);
    }

    //(METODO GET PARA BUSCAR POR ID)
    @GetMapping("/{id}")
    public Doctor buscarDoctorPorId(@PathVariable int id) {
        return doctorService.buscarDoctorPorId(id);
    }

    //(METODO PUT PARA ACTUALIZAR)
    @PutMapping("/{id}")
    public Doctor actualizarDoctor(@RequestBody Doctor doctorActualizar, @PathVariable int id) {
        Doctor doctor = doctorService.buscarDoctorPorId(id);
        doctor.setId(doctorActualizar.getId());
        doctor.setNombre(doctorActualizar.getNombre());
        doctor.setEspecialidad(doctorActualizar.getEspecialidad());
        doctor.setExperiencia(doctorActualizar.getExperiencia());
        return doctorService.actualizarDoctor(id, doctor);
    }

    //(METODO DELETE PARA ELIMINAR)
    @DeleteMapping("/{id}")
    public void eliminarDoctor(@PathVariable int id) {
        doctorService.eliminarDoctor(id);
    }
}
