package org.example.ta;

public enum Currency {
    USD("USD"), EUR("EUR");

    private String currencyDescription;

    Currency(String currencyDescription) {
        this.currencyDescription = currencyDescription;
    }

    public String getCurrencyDescription() {
        return this.currencyDescription;
    }
}
