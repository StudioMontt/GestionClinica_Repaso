package cl.awakelab.repaso.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "doctores")
public class Doctor {
    @Id
    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 100)
    private String nombre;

    @JoinColumn(name = "especialidad_id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Especialidad especialidad;

    @Column
    private int experiencia;

    @ManyToMany(mappedBy = "listaDoctores")
    private List<Cita> listaCitas;

    @ManyToMany(mappedBy = "listaDoctores")
    private List<HistoriaClinica> listaHistClinicas;
}
