package mx.edu.utez.rismotorolos.doctor.model;

import jakarta.validation.constraints.NotNull;
import mx.edu.utez.rismotorolos.nurse.model.Nurse;
import mx.edu.utez.rismotorolos.stock.model.Stock;

public class DoctorDto {

    private Long id;

    @NotNull(message = "El nombre del doctor es obligatorio")
    private String name;

    @NotNull(message = "El apellido del doctor es obligatorio")
    private String last_name;

    @NotNull(message = "La cédula profesional del doctor es obligatoria")
    private String professional_id;

    @NotNull(message = "El número de teléfono del doctor es obligatorio")
    private String phone_number;

    @NotNull(message = "La enfermera asociada es obligatoria")
    private Nurse nurse;

    @NotNull(message = "El stock asociado es obligatorio")
    private Stock stock;

    public DoctorDto() {
    }

    public DoctorDto(Long id, String name, String last_name, String professional_id, String phone_number, Nurse nurse,
            Stock stock) {
        this.id = id;
        this.name = name;
        this.last_name = last_name;
        this.professional_id = professional_id;
        this.phone_number = phone_number;
        this.nurse = nurse;
        this.stock = stock;
    }

    public static DoctorDto fromEntity(Doctor doctor) {
        return new DoctorDto(
                doctor.getId(),
                doctor.getName(),
                doctor.getLast_name(),
                doctor.getProfessional_id(),
                doctor.getPhone_number(),
                doctor.getNurse(),
                doctor.getStock());
    }

    public Doctor toEntity() {
        return new Doctor(
                this.id,
                this.name,
                this.last_name,
                this.professional_id,
                this.phone_number,
                this.nurse,
                this.stock);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotNull(message = "El nombre del doctor es obligatorio") String getName() {
        return name;
    }

    public void setName(@NotNull(message = "El nombre del doctor es obligatorio") String name) {
        this.name = name;
    }

    public @NotNull(message = "El apellido del doctor es obligatorio") String getLast_name() {
        return last_name;
    }

    public void setLast_name(@NotNull(message = "El apellido del doctor es obligatorio") String last_name) {
        this.last_name = last_name;
    }

    public @NotNull(message = "La cédula profesional del doctor es obligatoria") String getProfessional_id() {
        return professional_id;
    }

    public void setProfessional_id(
            @NotNull(message = "La cédula profesional del doctor es obligatoria") String professional_id) {
        this.professional_id = professional_id;
    }

    public @NotNull(message = "El número de teléfono del doctor es obligatorio") String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(
            @NotNull(message = "El número de teléfono del doctor es obligatorio") String phone_number) {
        this.phone_number = phone_number;
    }

    public @NotNull(message = "La enfermera asociada es obligatoria") Nurse getNurse() {
        return nurse;
    }

    public void setNurse(@NotNull(message = "La enfermera asociada es obligatoria") Nurse nurse) {
        this.nurse = nurse;
    }

    public @NotNull(message = "El stock asociado es obligatorio") Stock getStock() {
        return stock;
    }

    public void setStock(@NotNull(message = "El stock asociado es obligatorio") Stock stock) {
        this.stock = stock;
    }
}
