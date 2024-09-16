package com.solvd.laba.travelagency.model.booking;

import com.solvd.laba.travelagency.model.finance.Currency;
import com.solvd.laba.travelagency.model.finance.Payable;

import java.util.Map;

public class PaymentDetails implements Payable {
    private Map<CostOption, Double> costDetails;
    private boolean isPaid;
    private Currency currency;

    public PaymentDetails(Map<CostOption, Double> costDetails, Currency currency) {
        this.costDetails = costDetails;
        this.currency = currency;
    }

    @Override
    public boolean isPaid() {
        return this.isPaid;
    }

    @Override
    public void setPaid(boolean paid) {
        this.isPaid = paid;
    }

    @Override
    public double getPrice() {
        return this.calculateTotalCost(costDetails);
    }

    @Override
    public Currency getCurrency() {
        return this.currency;
    }

    private double calculateTotalCost(Map<CostOption, Double> costDetails) {
        return costDetails.values()
                .stream()
                .reduce(0.0, Double::sum);
    }
}
