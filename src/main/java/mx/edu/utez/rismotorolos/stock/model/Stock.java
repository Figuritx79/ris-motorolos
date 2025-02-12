package mx.edu.utez.rismotorolos.stock.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import mx.edu.utez.rismotorolos.facture.model.Facture;
import mx.edu.utez.rismotorolos.item.model.Item;

@Entity
@Table(name = "stocks")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private int amount;

    @ManyToOne
    @JoinColumn(name = "facture_id", nullable = false)
    private Facture facture;

    @ManyToOne
    @JoinColumn(name = "item_id", nullable = false)
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
