package services;

import entity.ProfitabilityEntity;

public class ProfitabilityCalculator {
    private double profitFromAllActivities;
    private double totalProductSalesCosts;

    public ProfitabilityCalculator(ProfitabilityEntity entity) {
        this.profitFromAllActivities = entity.getProfitFromAllActivities();
        this.totalProductSalesCosts = entity.getTotalProductSalesCosts();
    }

    public double calculate() {
        return profitFromAllActivities / totalProductSalesCosts;
    }
}
