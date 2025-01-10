package mx.edu.utez.rismotorolos.item.model;

public class Item {
    private Long id;
    private String medicine_name;
    private String description;
    private Double price;

    public Item() {
    }

    public Item(Long id, String medicine_name, String description, Double price) {
        this.id = id;
        this.medicine_name = medicine_name;
        this.description = description;
        this.price = price;
    }

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
