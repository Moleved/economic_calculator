package processors;

import entity.CurrentLiquidityEntity;
import services.CurrentLiquidityCalculator;

public class CurrentLiquidityProcessor extends LiquidityProcessor {
    private final String TYPE = "current";
    private CurrentLiquidityEntity entity;

    public CurrentLiquidityProcessor(int appId, CurrentLiquidityEntity entity) {
        super(appId);
        this.entity = entity;
    }

    public void perform() {
        super.perform();
    }

    protected void save() {
        entity.setApplication(application);
        entity.setLiquidity(liquidity);

        entity.save();
    }

    protected void defineLiquidity() {
        liquidity.setType(TYPE);
        liquidity.setResult(new CurrentLiquidityCalculator(entity).calculate());
        super.defineLiquidity();
    }
}
