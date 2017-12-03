package processors;

import entity.LiquidityEntity;

public abstract class LiquidityProcessor extends EntityProcessor {
    protected LiquidityEntity liquidity = new LiquidityEntity();

    public LiquidityProcessor(int appId) {
        super(appId);
    }

    public void perform() {
        defineApplication();
        defineLiquidity();

        save();
    }

    protected void defineLiquidity() {
        liquidity.setApplication(application);
        liquidity.save();
    }

    protected abstract void save();
}
