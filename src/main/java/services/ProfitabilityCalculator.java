package com.calculator.services;

public class ProfitabilityCalculator extends CalculatorInstance {
    private double profitFromAllActivities;
    private double totalProductSalesCosts;

    public ProfitabilityCalculator(double profitFromAllActivities, double totalProductSalesCosts) {
        this.profitFromAllActivities = profitFromAllActivities;
        this.totalProductSalesCosts = totalProductSalesCosts;
    }

    public double calculate() {
        return super.calculateDivision(profitFromAllActivities, totalProductSalesCosts);
    }
}
