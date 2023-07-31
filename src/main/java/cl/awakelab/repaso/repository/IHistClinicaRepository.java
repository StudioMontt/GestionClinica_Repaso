package cl.awakelab.repaso.repository;

import cl.awakelab.repaso.entity.HistoriaClinica;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IHistClinicaRepository extends JpaRepository<HistoriaClinica, Integer> {
}
