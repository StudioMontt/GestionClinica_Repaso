package cl.awakelab.repaso.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

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

    @JsonIgnore
    @JoinColumn(name = "paciente_id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
//    @ToString.Exclude
    private Paciente paciente;

    @JsonIgnore
    @JoinColumn(name = "doctor_id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
//    @ToString.Exclude
    private Doctor doctor;

    @Column
    private LocalDate fecha;

    @JsonIgnore
    @JoinColumn(name = "factura_id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
//    @ToString.Exclude
    private Factura factura;
}
