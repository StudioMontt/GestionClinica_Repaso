package cl.awakelab.repaso.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "facturas")
public class Factura {
    @Id
    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private float monto;

    @Column(name = "Fecha_Pago")
    private LocalDate fechaPago;

    @OneToMany(mappedBy = "factura")
    private List<Cita> listaCitas;
}
