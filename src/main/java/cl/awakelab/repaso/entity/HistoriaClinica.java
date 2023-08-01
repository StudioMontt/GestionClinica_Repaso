package cl.awakelab.repaso.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "historia_clinica")
public class HistoriaClinica {
    @Id
    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JsonIgnore
    @JoinColumn(name = "paciente_id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
//    @ToString.Exclude
    private Paciente paciente;

    @JsonIgnore
    @JoinColumn(name = "doctor_id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Doctor doctor;

    @Column(name = "fecha_cita")
    private LocalDate fechaCita;
    @Column
    private String sintomas;
    @Column
    private String diagnostico;
    @Column
    private String tratamiento;

}
