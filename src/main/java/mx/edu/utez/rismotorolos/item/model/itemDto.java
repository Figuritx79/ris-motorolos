package mx.edu.utez.rismotorolos.item.model;

public class itemDto {
    private Long id;
    private String medicine_name;
    private String description;
    private Double price;

    public itemDto() {
    }

    public itemDto(Long id, String medicine_name, String description, Double price) {
        this.id = id;
        this.medicine_name = medicine_name;
        this.description = description;
        this.price = price;
    }

    public static itemDto fromEntity(Item item) {
        return new itemDto(
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
