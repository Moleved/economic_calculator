package services;

import entity.CurrentLiquidityEntity;
import entity.LiquidityEntity;

public class CurrentLiquidityCalculator {
    private double revolvingAssets;
    private double shortLiabilities;

    public CurrentLiquidityCalculator(CurrentLiquidityEntity entity) {
        this.shortLiabilities = entity.getShortLiabilities();
        this.revolvingAssets = entity.getRevolvingAssets();
    }

    public void perform() {
        double result = calculate();

        LiquidityEntity entity = new LiquidityEntity();

        entity.setType("current");
        entity.setResult(result);

        entity.save();
    }

    private double calculate() {
        return revolvingAssets / shortLiabilities;
    }
}
