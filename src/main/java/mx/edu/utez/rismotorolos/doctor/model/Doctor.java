package mx.edu.utez.rismotorolos.doctor.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import mx.edu.utez.rismotorolos.date.model.Date;
import mx.edu.utez.rismotorolos.nurse.model.Nurse;
import mx.edu.utez.rismotorolos.role.model.Role;
import mx.edu.utez.rismotorolos.stock.model.Stock;

@Entity
@Table(name = "doctors")
@Getter
@Setter
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String last_name;

    @NotNull
    private String professional_id;

    @NotNull
    private String phone_number;

    @Column(name = "email", columnDefinition = "VARCHAR(50)")
    private String email;

    @Column(name = "password", columnDefinition = "VARCHAR(100)")
    private String password;

    @ManyToOne
    @JoinColumn(name = "nurse_id", nullable = false, columnDefinition = "TINYINT")
    private Nurse nurse;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stock_id", nullable = false)
    private Stock stock;

    @OneToMany(mappedBy = "doctor")
    @JsonIgnore
    private List<Date> dates;

    @ManyToOne
    @JoinColumn(name = "id_role", columnDefinition = "TINYINT")
    private Role role;

    public Doctor() {
    }

    public Doctor(Long id, String name, String last_name, String professional_id, String phone_number, Nurse nurse,
                  Stock stock) {
        this.id = id;
        this.name = name;
        this.last_name = last_name;
        this.professional_id = professional_id;
        this.phone_number = phone_number;
        this.nurse = nurse;
        this.stock = stock;
    }

}


