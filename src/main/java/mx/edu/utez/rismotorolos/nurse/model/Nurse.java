package mx.edu.utez.rismotorolos.nurse.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.rismotorolos.doctor.model.Doctor;

@Entity
@Table(name = "nurse", indexes = {
        @Index(name = "nurse_name", columnList = "name"),
        @Index(name = "nurse_professional_id_nurse", columnList = "professional_id_nurse")
})
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Nurse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", columnDefinition = "VARCHAR(50)", nullable = false)
    private String name;

    @Column(name = "last_name", columnDefinition = "VARCHAR(50)", nullable = true)
    private String lastName;

    @Column(name = "professional_id_nurse", columnDefinition = "VARCHAR(18)", nullable = false, unique = true)
    private String professionalId;

    @Column(name = "phone_number", columnDefinition = "VARCHAR(10)", nullable = false)
    private String phone;

    @OneToMany(mappedBy = "nurse")
    @JsonIgnore
    List<Doctor> doctors;
}
