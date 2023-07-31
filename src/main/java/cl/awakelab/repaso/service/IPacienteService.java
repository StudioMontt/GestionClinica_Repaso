package cl.awakelab.repaso.service
        ;

import cl.awakelab.repaso.entity.Paciente;

import java.util.List;

public interface IPacienteService {

    Paciente crearPaciente(Paciente paciente);

    List<Paciente> listarPacientes();

    Paciente buscarPacientePorId(int id);

    Paciente actualizarPaciente(int id, Paciente pacienteActualizar);

    void eliminarPaciente(int id);
}

