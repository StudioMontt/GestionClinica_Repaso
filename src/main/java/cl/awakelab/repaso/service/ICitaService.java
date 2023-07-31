package cl.awakelab.repaso.service;

import cl.awakelab.repaso.entity.Cita;

import java.util.List;

public interface ICitaService {
    Cita crearCita(Cita cita);

    List<Cita> listarCitas();

    Cita buscarCitaPorId(int id);

    Cita actualizarCita(int id, Cita citaActualizar);

    public void eliminarCita(int id);
}
