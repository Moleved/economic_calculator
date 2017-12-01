package services;

import entity.AbsoluteLiquidityEntity;
import entity.LiquidityEntity;

public class AbsoluteLiquidityCalculator {
    private double shortLiabilities;
    private double funds;
    private double shortFinancialInvestments;

    public AbsoluteLiquidityCalculator(AbsoluteLiquidityEntity entity) {
        this.shortLiabilities = entity.getShortLiabilities();
        this.funds = entity.getFunds();
        this.shortFinancialInvestments = entity.getShortFinancialInvestments();
    }

    public void perform() {
        double result = calculate();

        LiquidityEntity entity = new LiquidityEntity();

        entity.setType("absolute");
        entity.setResult(result);

        entity.save();
    }

    private double calculate() {
        return (funds + shortFinancialInvestments) / shortLiabilities;
    }
}
