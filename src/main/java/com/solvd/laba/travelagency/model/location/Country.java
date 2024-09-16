package com.solvd.laba.travelagency.model.location;

import com.solvd.laba.travelagency.model.finance.Currency;

public enum Country {
    FRANCE("France", "FR", Currency.EUR),
    ITALY("Italy", "IT", Currency.EUR),
    USA("USA", "US", Currency.USD),
    SPAIN("Spain", "ES", Currency.EUR),
    GREAT_BRITAIN("Great Britain", "GB", Currency.GBP);

    private final String name;
    private final String countryCode;
    private final Currency currency;

    Country(String name, String countryCode, Currency currency) {
        this.name = name;
        this.countryCode = countryCode;
        this.currency = currency;
    }

    public String getName() {
        return name;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public Currency getCurrency() {
        return currency;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Country{");
        sb.append("name='").append(name).append('\'');
        sb.append(", countryCode='").append(countryCode).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
