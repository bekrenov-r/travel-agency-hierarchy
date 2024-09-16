package com.solvd.laba.travelagency.model.finance;

public enum Currency {
    USD("United States Dollar", "$", 1.0, "$%.2f"),
    EUR("Euro", "€", 1.11, "€%.2f"),
    PLN("Polish Zloty", "zł", 0.26, "%.2f zł"),
    CZK("Czech koruna", "Kč", 0.044, "%.2f Kč"),
    GBP("Pound Sterling", "£", 1.31, "£%.2f");

    private final String fullName;
    private final String sign;
    private final double dollarConversionFactor;
    private final String amountWithSignTemplate;

    Currency(String fullName, String sign, double dollarConversionFactor, String amountWithSignTemplate) {
        this.fullName = fullName;
        this.sign = sign;
        this.dollarConversionFactor = dollarConversionFactor;
        this.amountWithSignTemplate = amountWithSignTemplate;
    }

    public String getFullName() {
        return fullName;
    }

    public String getSign() {
        return sign;
    }

    public double getDollarConversionFactor() {
        return dollarConversionFactor;
    }

    public String format(double amount) {
        return amountWithSignTemplate.formatted(amount);
    }
}
