package mx.edu.utez.rismotorolos.facture.model;

import jakarta.validation.constraints.NotNull;

import java.util.Date;

public class FactureDto {

    @NotNull(message = "El ID de la factura es obligatorio")
    private Long id;

    @NotNull(message = "El monto de la factura es obligatorio")
    private double amount;

    @NotNull(message = "El RFC de la factura es obligatorio")
    private String rfc;

    @NotNull(message = "El régimen fiscal de la factura es obligatorio")
    private String tax_regime;

    @NotNull(message = "La fecha de la factura es obligatoria")
    private Date facture_date;

    public FactureDto() {
    }

    public FactureDto(Long id, double amount, String rfc, String tax_regime, Date facture_date) {
        this.id = id;
        this.amount = amount;
        this.rfc = rfc;
        this.tax_regime = tax_regime;
        this.facture_date = facture_date;
    }

    public static FactureDto fromEntity(Facture facture) {
        return new FactureDto(
                facture.getId(),
                facture.getAmount(),
                facture.getRfc(),
                facture.getTax_regime(),
                facture.getFacture_date()
        );
    }

    public Facture toEntity() {
        return new Facture(
                this.id,
                this.amount,
                this.rfc,
                this.tax_regime,
                this.facture_date
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
