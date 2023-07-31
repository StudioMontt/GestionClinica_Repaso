package cl.awakelab.repaso.repository;

import cl.awakelab.repaso.entity.Especialidad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEspecialidadRepository extends JpaRepository<Especialidad, Integer> {
}
