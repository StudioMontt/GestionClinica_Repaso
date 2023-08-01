package cl.awakelab.repaso.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@Entity
@Table(name = "especialidades")
public class Especialidad {
    @Id
    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 100)
    private String nombre;

    //    @JsonIgnore
    @OneToMany(mappedBy = "especialidad")
//    @ToString.Exclude
    private List<Doctor> listaDoctores;
}
