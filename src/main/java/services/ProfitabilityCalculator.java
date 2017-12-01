package services;

public class ProfitabilityCalculator {
    private double profitFromAllActivities;
    private double totalProductSalesCosts;

    public ProfitabilityCalculator(double profitFromAllActivities, double totalProductSalesCosts) {
        this.profitFromAllActivities = profitFromAllActivities;
        this.totalProductSalesCosts = totalProductSalesCosts;
    }

    public double calculate() {
        return profitFromAllActivities / totalProductSalesCosts;
    }
}
