package cl.awakelab.repaso.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "citas")
public class Cita {
    @Id
    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JoinColumn(name = "paciente_id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Paciente paciente;

    @ManyToMany
    @JoinTable(name = "cita_doc", joinColumns = @JoinColumn(name = "cita_id", nullable = false), inverseJoinColumns = @JoinColumn(name = "doctor_id", nullable = false))
    private List<Doctor> listaDoctores;

    @Column
    private LocalDate fecha;

    @JoinColumn(name = "factura_id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Factura factura;
}
