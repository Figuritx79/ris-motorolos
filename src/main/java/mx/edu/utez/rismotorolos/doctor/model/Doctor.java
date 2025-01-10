package mx.edu.utez.rismotorolos.doctor.model;

import jakarta.validation.constraints.NotNull;
import mx.edu.utez.rismotorolos.nurse.model.Nurse;
import mx.edu.utez.rismotorolos.stock.model.Stock;

public class Doctor {
    @NotNull
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String last_name;

    @NotNull
    private String professional_id;

    @NotNull
    private String phone_number;

    @NotNull
    private Nurse nurse;

    @NotNull
    private Stock stock;

    public Doctor() {
    }

    public Doctor(Long id, String name, String last_name, String professional_id, String phone_number, Nurse nurse, Stock stock) {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getProfessional_id() {
        return professional_id;
    }

    public void setProfessional_id(String professional_id) {
        this.professional_id = professional_id;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
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
