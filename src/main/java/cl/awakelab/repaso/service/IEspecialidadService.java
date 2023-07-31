package cl.awakelab.repaso.service
        ;

import cl.awakelab.repaso.entity.Especialidad;

import java.util.List;

public interface IEspecialidadService {

    Especialidad crearEspecialidad(Especialidad especialidad);

    List<Especialidad> listarEspecialidades();

    Especialidad buscarEspecialidadPorId(int id);

    Especialidad actualizarEspecialidad(int id, Especialidad especialidadActualizar);

    void eliminarEspecialidad(int id);
}
