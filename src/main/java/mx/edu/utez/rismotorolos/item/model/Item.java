package mx.edu.utez.rismotorolos.item.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "La medicina debe de contar con un nombre")
    private String medicine_name;

    @NotNull(message = "El item debe de contar con una descripcion")
    private String description;

    @NotNull(message = "El item debe de contar con un precio")
    private Double price;

    public Item() {
    }

    public Item(Long id, String medicine_name, String description, Double price) {
        this.id = id;
        this.medicine_name = medicine_name;
        this.description = description;
        this.price = price;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMedicine_name() {
        return medicine_name;
    }

    public void setMedicine_name(String medicine_name) {
        this.medicine_name = medicine_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
