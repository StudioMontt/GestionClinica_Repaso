package cl.awakelab.repaso.repository;

import cl.awakelab.repaso.entity.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICitaRepository extends JpaRepository<Cita, Integer> {
}
