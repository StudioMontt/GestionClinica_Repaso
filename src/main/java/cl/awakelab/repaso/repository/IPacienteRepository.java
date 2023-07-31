package cl.awakelab.repaso.repository;

import cl.awakelab.repaso.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPacienteRepository extends JpaRepository<Paciente, Integer> {
}
