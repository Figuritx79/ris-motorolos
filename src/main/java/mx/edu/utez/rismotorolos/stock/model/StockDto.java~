package mx.edu.utez.rismotorolos.stock.model;

import mx.edu.utez.rismotorolos.facture.model.Facture;
import mx.edu.utez.rismotorolos.item.model.Item;

public class StockDto {
    private Long id;
    private int amount;
    private Facture facture;
    private Item item;

    public StockDto() {
    }

    public StockDto(Long id, int amount, Facture facture, Item item) {
        this.id = id;
        this.amount = amount;
        this.facture = facture;
        this.item = item;
    }

    public static StockDto fromEntity(Stock stock) {
        return new StockDto(
                stock.getId(),
                stock.getAmount(),
                stock.getFacture(),
                stock.getItem()
        );
    }

    public Stock toEntity() {
        return new Stock(
                this.id,
                this.amount,
                this.facture,
                this.item
        );
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Facture getFacture() {
        return facture;
    }

    public void setFacture(Facture facture) {
        this.facture = facture;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
