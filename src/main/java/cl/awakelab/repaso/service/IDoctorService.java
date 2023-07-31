package cl.awakelab.repaso.service;

import cl.awakelab.repaso.entity.Doctor;

import java.util.List;

public interface IDoctorService {
    Doctor crearDoctor(Doctor doctor);

    List<Doctor> listarDoctores();

    Doctor buscarDoctorPorId(int id);

    Doctor actualizarDoctor(int id, Doctor doctorActualizar);

    void eliminarDoctor(int id);
}
