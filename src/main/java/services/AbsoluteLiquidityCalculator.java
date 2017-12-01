package services;

import entity.AbsoluteLiquidityEntity;

public class AbsoluteLiquidityCalculator {
    private double shortLiabilities;
    private double funds;
    private double shortFinancialInvestments;

    public AbsoluteLiquidityCalculator(AbsoluteLiquidityEntity entity) {
        this.shortLiabilities = entity.getShortLiabilities();
        this.funds = entity.getFunds();
        this.shortFinancialInvestments = entity.getShortFinancialInvestments();
    }

    public double calculate() {
        return (funds + shortFinancialInvestments) / shortLiabilities;
    }
}
