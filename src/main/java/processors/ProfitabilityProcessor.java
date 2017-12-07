package processors;

import entity.ProfitabilityEntity;
import services.ProfitabilityCalculator;

public class ProfitabilityProcessor extends EntityProcessor {
    private ProfitabilityEntity entity;

    public ProfitabilityProcessor(Long appId, ProfitabilityEntity entity) {
        super(appId);
        this.entity = entity;
    }

    public void perform() {
        defineApplication();
        save();
    }

    private void save() {
        entity.setApplication(application);
        entity.setResult(new ProfitabilityCalculator(entity).calculate());

        entity.save();
    }
}
