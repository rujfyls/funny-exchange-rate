package ru.feduncov.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Rate {

    @JsonProperty("RUB")
    private double currency;

    public double getCurrency() {
        return currency;
    }

    public void setCurrency(double currency) {
        this.currency = currency;
    }
}
