package cl.awakelab.repaso.service.serviceImpl;

import cl.awakelab.repaso.entity.Paciente;
import cl.awakelab.repaso.repository.IPacienteRepository;
import cl.awakelab.repaso.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PacienteImpl implements IPacienteService {
    @Autowired
    IPacienteRepository pacienteRepo;

    @Override
    public Paciente crearPaciente(Paciente paciente) {
        return pacienteRepo.save(paciente);
    }

    @Override
    public List<Paciente> listarPacientes() {
        return pacienteRepo.findAll();
    }

    @Override
    public Paciente buscarPacientePorId(int id) {
        return pacienteRepo.findById(id).orElseThrow(() -> new NoSuchElementException("El Paciente no fue encontrado"));
    }

    @Override
    public Paciente actualizarPaciente(int id, Paciente pacienteActualizar) {
        Paciente paciente = pacienteRepo.findById(id).orElseThrow(() -> new NoSuchElementException("El Paciente no fue encontrado"));
        paciente.setId(pacienteActualizar.getId());
        paciente.setNombre(pacienteActualizar.getNombre());
        paciente.setFechaNacimiento(pacienteActualizar.getFechaNacimiento());
        return pacienteRepo.save(paciente);
    }

    @Override
    public void eliminarPaciente(int id) {
        pacienteRepo.deleteById(id);
    }
}
