package com.solvd.laba.travelagency.service;

import com.solvd.laba.travelagency.exception.InitializationException;
import com.solvd.laba.travelagency.exception.NegativeAmountException;
import com.solvd.laba.travelagency.model.finance.Currency;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CurrencyConverter {
    private final Currency input;
    private final Currency output;

    private CurrencyConverter(Currency input, Currency output) {
        this.input = input;
        this.output = output;
    }

    public double convert(double amount) {
        if(amount <= 0) {
            throw new NegativeAmountException(amount);
        }
        if(input.equals(Currency.USD)) {
            return convertFromUSD(output, amount);
        }
        if(output.equals(Currency.USD)) {
            return convertToUSD(input, amount);
        }
        double amountUSD = convertToUSD(input, amount);
        return convertFromUSD(output, amountUSD);
    }

    private double convertToUSD(Currency currency, double amount) {
        return BigDecimal.valueOf(amount)
                .multiply(BigDecimal.valueOf(currency.getDollarConversionFactor()))
                .setScale(2, RoundingMode.HALF_DOWN)
                .doubleValue();
    }

    private double convertFromUSD(Currency currency, double amount) {
        return BigDecimal.valueOf(amount)
                .divide(BigDecimal.valueOf(currency.getDollarConversionFactor()), RoundingMode.HALF_DOWN)
                .setScale(2, RoundingMode.HALF_DOWN)
                .doubleValue();
    }

    public static CurrencyConverter create(Currency input, Currency output) {
        if(input.equals(output)) {
            throw new InitializationException("Cannot create converter for same currencies");
        }
        return new CurrencyConverter(input, output);
    }
}
