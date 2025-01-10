package mx.edu.utez.rismotorolos.doctor.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import mx.edu.utez.rismotorolos.date.model.Date;
import mx.edu.utez.rismotorolos.nurse.model.Nurse;
import mx.edu.utez.rismotorolos.stock.model.Stock;

@Entity
@Table(name = "doctors")
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

    @ManyToOne
    @JoinColumn(name = "nurse_id", nullable = false, columnDefinition = "TINYINT")
    private Nurse nurse;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stock_id", nullable = false)
    private Stock stock;

    @ManyToOne
    @JsonIgnore
    private List<Date> dates;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotNull String getName() {
        return name;
    }

    public void setName(@NotNull String name) {
        this.name = name;
    }

    public @NotNull String getLast_name() {
        return last_name;
    }

    public void setLast_name(@NotNull String last_name) {
        this.last_name = last_name;
    }

    public @NotNull String getProfessional_id() {
        return professional_id;
    }

    public void setProfessional_id(@NotNull String professional_id) {
        this.professional_id = professional_id;
    }

    public @NotNull String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(@NotNull String phone_number) {
        this.phone_number = phone_number;
    }

    public Nurse getNurse() {
        return nurse;
    }

    public void setNurse(Nurse nurse) {
        this.nurse = nurse;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }
}
