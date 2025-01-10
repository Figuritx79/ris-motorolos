package mx.edu.utez.rismotorolos.item.model;

import jakarta.validation.constraints.NotNull;

public class ItemDto {

    @NotNull(message = "El item debe de contar con un id")
    private Long id;

    @NotNull(message = "La medicina debe de contar con un nombre")
    private String medicine_name;

    @NotNull(message = "El item debe de contar con una descripcion")
    private String description;

    @NotNull(message = "El item debe de contar con un precio")
    private Double price;

    public ItemDto() {
    }

    public ItemDto(Long id, String medicine_name, String description, Double price) {
        this.id = id;
        this.medicine_name = medicine_name;
        this.description = description;
        this.price = price;
    }

    public static ItemDto fromEntity(Item item) {
        return new ItemDto(
                item.getId(),
                item.getMedicine_name(),
                item.getDescription(),
                item.getPrice());
    }

    public Item toEntity() {
        return new Item(
                this.id,
                this.medicine_name,
                this.description,
                this.price);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getmedicine_name() {
        return medicine_name;
    }

    public void setmedicine_name(String medicine_name) {
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
