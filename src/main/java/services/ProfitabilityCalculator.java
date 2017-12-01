package services;

import entity.ProfitabilityEntity;

public class ProfitabilityCalculator {
    private ProfitabilityEntity entity;
    private double profitFromAllActivities;
    private double totalProductSalesCosts;

    public ProfitabilityCalculator(ProfitabilityEntity entity) {
        this.entity = entity;
        this.profitFromAllActivities = entity.getProfitFromAllActivities();
        this.totalProductSalesCosts = entity.getTotalProductSalesCosts();
    }

    public void perform() {
        double result = calculate();

        entity.setResult(result);

        entity.save();
    }

    private double calculate() {
        return profitFromAllActivities / totalProductSalesCosts;
    }
}
