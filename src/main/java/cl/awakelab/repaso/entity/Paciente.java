package cl.awakelab.repaso.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "pacientes")
public class Paciente {
    @Id
    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 100)
    private String nombre;

    @Column
    private LocalDate fechaNacimiento;

    //    @JsonIgnore
    @OneToMany(mappedBy = "paciente")
//    @ToString.Exclude
    private List<Cita> listaCitas;

    //    @JsonIgnore
    @OneToMany(mappedBy = "paciente")
//    @ToString.Exclude
    private List<HistoriaClinica> listaHistClinicas;
}
