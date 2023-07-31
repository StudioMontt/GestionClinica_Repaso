package cl.awakelab.repaso.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "histClinicas")
public class HistoriaClinica {
    @Id
    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JoinColumn(name = "paciente_id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Paciente paciente;

    @ManyToMany
    @JoinTable(name = "histClin_doc", joinColumns = @JoinColumn(name = "histClin_id", nullable = false), inverseJoinColumns = @JoinColumn(name = "doctor_id", nullable = false))
    private List<Doctor> listaDoctores;

    @Column(name = "fecha_cita")
    private LocalDate fechaCita;

    @Column
    private String sintomas;
    @Column
    private String diagnostico;
    @Column
    private String tratamiento;

}
