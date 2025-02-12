package mx.edu.utez.rismotorolos.facture.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

@Entity
@Table(name = "factures")
public class Facture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable = false)
    private double amount;

    @NotNull
    @Column(nullable = false, length = 13)
    private String rfc;

    @NotNull
    @Column(nullable = false, length = 50)
    private String taxRegime;

    @NotNull
    @Column(name = "facture_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date factureDate;

    public Facture() {
    }

    public Facture(Long id, double amount, String rfc, String taxRegime, Date factureDate) {
        this.id = id;
        this.amount = amount;
        this.rfc = rfc;
        this.taxRegime = taxRegime;
        this.factureDate = factureDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getTaxRegime() {
        return taxRegime;
    }

    public void setTaxRegime(String taxRegime) {
        this.taxRegime = taxRegime;
    }

    public Date getFactureDate() {
        return factureDate;
    }

    public void setFactureDate(Date factureDate) {
        this.factureDate = factureDate;
    }
}
