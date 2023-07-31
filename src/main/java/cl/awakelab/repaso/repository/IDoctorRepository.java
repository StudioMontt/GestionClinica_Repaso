package cl.awakelab.repaso.repository;

import cl.awakelab.repaso.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDoctorRepository extends JpaRepository<Doctor, Integer> {
}
