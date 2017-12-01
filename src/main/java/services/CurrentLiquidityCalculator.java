package services;

import entity.CurrentLiquidityEntity;

public class CurrentLiquidityCalculator {
    private double revolvingAssets;
    private double shortLiabilities;

    public CurrentLiquidityCalculator(CurrentLiquidityEntity entity) {
        this.shortLiabilities = entity.getShortLiabilities();
        this.revolvingAssets = entity.getRevolvingAssets();
    }

    public double calculate() {
        return revolvingAssets / shortLiabilities;
    }
}
