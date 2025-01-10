package mx.edu.utez.rismotorolos.stock.model;

import jakarta.validation.constraints.NotNull;
import mx.edu.utez.rismotorolos.facture.model.Facture;
import mx.edu.utez.rismotorolos.item.model.Item;

import java.lang.annotation.Native;

public class Stock {

    @NotNull
    private Long id;

    @NotNull
    private int amount;

    @NotNull
    private Facture facture;

    @NotNull
    private Item item;

    public Stock() {
    }

    public Stock(Long id, int amount, Facture facture, Item item) {
        this.id = id;
        this.amount = amount;
        this.facture = facture;
        this.item = item;
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
