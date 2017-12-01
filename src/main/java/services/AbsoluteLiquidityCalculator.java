package com.calculator.services;

public class AbsoluteLiquidityCalculator extends LiquidityCalculator {
    private double funds;
    private double shortFinancialInvestments;

    public AbsoluteLiquidityCalculator(double shortLiabilities, double funds, double shortFinancialInvestments) {
        super(shortLiabilities);
        this.funds = funds;
        this.shortFinancialInvestments = shortFinancialInvestments;
    }

    public double calculate() {
        return super.calculateDivision(funds + shortFinancialInvestments, getShortLiabilities());
    }
}
