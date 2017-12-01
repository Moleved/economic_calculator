package com.calculator.services;

public class CurrentLiquidityCalculator extends LiquidityCalculator {
    private double revolvingAssets;

    public CurrentLiquidityCalculator(double shortLiabilities, double revolvingAssets) {
        super(shortLiabilities);
        this.revolvingAssets = revolvingAssets;
    }

    public double calculate() {
        return super.calculateDivision(revolvingAssets, getShortLiabilities());
    }
}
