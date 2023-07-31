package cl.awakelab.repaso.repository;

import cl.awakelab.repaso.entity.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFacturaRepository extends JpaRepository<Factura, Integer> {
}
