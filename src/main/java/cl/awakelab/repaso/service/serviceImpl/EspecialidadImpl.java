package cl.awakelab.repaso.service.serviceImpl;

import cl.awakelab.repaso.entity.Especialidad;
import cl.awakelab.repaso.repository.IEspecialidadRepository;
import cl.awakelab.repaso.service.IEspecialidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class EspecialidadImpl implements IEspecialidadService {
    @Autowired
    IEspecialidadRepository especialidadRepo;

    @Override
    public Especialidad crearEspecialidad(Especialidad especialidad) {
        return especialidadRepo.save(especialidad);
    }

    @Override
    public List<Especialidad> listarEspecialidades() {
        return especialidadRepo.findAll();
    }

    @Override
    public Especialidad buscarEspecialidadPorId(int id) {
        return especialidadRepo.findById(id).orElseThrow(() -> new NoSuchElementException("La Especialidad no fue encontrada"));
    }

    @Override
    public Especialidad actualizarEspecialidad(int id, Especialidad especialidadActualizar) {
        Especialidad especialidad = especialidadRepo.findById(id).orElseThrow(() -> new NoSuchElementException("La Especialidad no fue encontrada"));
        especialidad.setId(especialidadActualizar.getId());
        especialidad.setNombre(especialidadActualizar.getNombre());
        return especialidadRepo.save(especialidad);
    }

    @Override
    public void eliminarEspecialidad(int id) {
        especialidadRepo.deleteById(id);
    }
}
