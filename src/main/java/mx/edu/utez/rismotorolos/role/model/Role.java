package mx.edu.utez.rismotorolos.role.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import mx.edu.utez.rismotorolos.doctor.model.Doctor;

import java.util.List;

@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", columnDefinition = "VARCHAR(40)")
    private String name;

    @OneToMany(mappedBy = "role" )
    @JsonIgnore
    private List<Doctor> doctors;

    public Role(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Role(String name) {
        this.name = name;
    }

    public Role() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }
}
