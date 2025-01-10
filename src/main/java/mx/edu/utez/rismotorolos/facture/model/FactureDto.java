package mx.edu.utez.rismotorolos.facture.model;

import jakarta.validation.constraints.NotNull;

import java.util.Date;

public class FactureDto {

    private Long id;

    @NotNull(message = "El monto de la factura es obligatorio")
    private double amount;

    @NotNull(message = "El RFC de la factura es obligatorio")
    private String rfc;

    @NotNull(message = "El régimen fiscal de la factura es obligatorio")
    private String taxRegime;

    @NotNull(message = "La fecha de la factura es obligatoria")
    private Date factureDate;

    public FactureDto() {
    }

    public FactureDto(Long id, double amount, String rfc, String taxRegime, Date factureDate) {
        this.id = id;
        this.amount = amount;
        this.rfc = rfc;
        this.taxRegime = taxRegime;
        this.factureDate = factureDate;
    }

    public static FactureDto fromEntity(Facture facture) {
        return new FactureDto(
                facture.getId(),
                facture.getAmount(),
                facture.getRfc(),
                facture.getTaxRegime(),
                facture.getFactureDate()
        );
    }

    public Facture toEntity() {
        return new Facture(
                this.id,
                this.amount,
                this.rfc,
                this.taxRegime,
                this.factureDate
        );
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
