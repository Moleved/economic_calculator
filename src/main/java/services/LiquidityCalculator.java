package com.calculator.services;

public class LiquidityCalculator extends CalculatorInstance {
    private double shortLiabilities;

    public LiquidityCalculator(double shortLiabilities) {
        this.shortLiabilities = shortLiabilities;
    }

    public double getShortLiabilities() {
        return shortLiabilities;
    }
}
