package cl.awakelab.repaso.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

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

    @JsonIgnore
    @JoinColumn(name = "especialidad_id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
//    @ToString.Exclude
    private Especialidad especialidad;

    @Column
    private int experiencia;

    //    @JsonIgnore
    @OneToMany(mappedBy = "doctor")
//    @ToString.Exclude
    private List<Cita> listaCitas;

    //    @JsonIgnore
    @OneToMany(mappedBy = "doctor")
//    @ToString.Exclude
    private List<HistoriaClinica> listaHistClinicas;
}
