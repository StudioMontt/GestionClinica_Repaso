package cl.awakelab.repaso.entity;

import jakarta.persistence.*;
import lombok.Data;

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

    @OneToMany(mappedBy = "paciente")
    private List<Cita> listaCitas;

    @OneToMany(mappedBy = "paciente")
    private List<HistoriaClinica> listaHistClinicas;
}
