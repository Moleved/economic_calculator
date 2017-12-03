package processors;

import entity.AbsoluteLiquidityEntity;
import services.AbsoluteLiquidityCalculator;

public class AbsoluteLiquidityProcessor extends LiquidityProcessor {
    private final String TYPE = "absolute";
    private AbsoluteLiquidityEntity entity;

    public AbsoluteLiquidityProcessor(int appId, AbsoluteLiquidityEntity entity) {
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
        liquidity.setResult(new AbsoluteLiquidityCalculator(entity).calculate());
        super.defineLiquidity();
    }
}
