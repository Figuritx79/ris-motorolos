package mx.edu.utez.rismotorolos.facture.model;

import jakarta.validation.constraints.NotNull;

import java.util.Date;

public class Facture {
    @NotNull
    private Long id;

    @NotNull
    private double amount;

    @NotNull
    private String rfc;

    @NotNull
    private String tax_regime;

    @NotNull
    private Date facture_date;

    public Facture() {
    }

    public Facture(Long id, double amount, String rfc, String tax_regime, Date facture_date) {
        this.id = id;
        this.amount = amount;
        this.rfc = rfc;
        this.tax_regime = tax_regime;
        this.facture_date = facture_date;
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

    public String getTax_regime() {
        return tax_regime;
    }

    public void setTax_regime(String tax_regime) {
        this.tax_regime = tax_regime;
    }

    public Date getFacture_date() {
        return facture_date;
    }

    public void setFacture_date(Date facture_date) {
        this.facture_date = facture_date;
    }
}
