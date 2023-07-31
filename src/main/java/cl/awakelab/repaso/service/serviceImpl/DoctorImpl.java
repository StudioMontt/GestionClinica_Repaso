package cl.awakelab.repaso.service.serviceImpl;

import cl.awakelab.repaso.entity.Doctor;
import cl.awakelab.repaso.repository.IDoctorRepository;
import cl.awakelab.repaso.service.IDoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class DoctorImpl implements IDoctorService {
    @Autowired
    IDoctorRepository doctorRepo;

    @Override
    public Doctor crearDoctor(Doctor doctor) {
        return doctorRepo.save(doctor);
    }

    @Override
    public List<Doctor> listarDoctores() {
        return doctorRepo.findAll();
    }

    @Override
    public Doctor buscarDoctorPorId(int id) {
        return doctorRepo.findById(id).orElseThrow(() -> new NoSuchElementException("El Doctor no fue encontrado"));
    }

    @Override
    public Doctor actualizarDoctor(int id, Doctor doctorActualizar) {
        Doctor doctor = doctorRepo.findById(id).orElseThrow(() -> new NoSuchElementException("El Doctor no fue encontrado"));
        doctor.setId(doctorActualizar.getId());
        doctor.setNombre(doctorActualizar.getNombre());
        doctor.setEspecialidad(doctorActualizar.getEspecialidad());
        doctor.setExperiencia(doctorActualizar.getExperiencia());
        return doctorRepo.save(doctor);
    }

    @Override
    public void eliminarDoctor(int id) {
        doctorRepo.deleteById(id);
    }
}
