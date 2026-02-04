package org.stylizedsubstance.mybank.dto;

import jakarta.validation.constraints.*;

public class TransactionDto {
    @NotNull
    @Min(0)
    @Max(1000000)
    private Integer amount;

    @NotBlank
    private String reference;

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }
}
