package cl.awakelab.repaso.service.serviceImpl;

import cl.awakelab.repaso.entity.Cita;
import cl.awakelab.repaso.repository.ICitaRepository;
import cl.awakelab.repaso.service.ICitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CitaImpl implements ICitaService {
    @Autowired
    ICitaRepository citaRepo;

    @Override
    public Cita crearCita(Cita cita) {
        return citaRepo.save(cita);
    }

    @Override
    public List<Cita> listarCitas() {
        return citaRepo.findAll();
    }

    @Override
    public Cita buscarCitaPorId(int id) {
        return citaRepo.findById(id).orElseThrow(() -> new NoSuchElementException("La Cita no fue encontrada"));
    }

    @Override
    public Cita actualizarCita(int id, Cita citaActualizar) {
        Cita cita = citaRepo.findById(id).orElseThrow(() -> new NoSuchElementException("La Cita no fue encontrada"));
        cita.setId(citaActualizar.getId());
        cita.setFactura(citaActualizar.getFactura());
        cita.setFecha(citaActualizar.getFecha());
        cita.setPaciente(citaActualizar.getPaciente());
        cita.setDoctor(citaActualizar.getDoctor());
        return citaRepo.save(cita);
    }

    @Override
    public void eliminarCita(int id) {
        citaRepo.deleteById(id);
    }
}
