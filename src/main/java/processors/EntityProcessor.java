package processors;

import entity.ApplicationEntity;

public class EntityProcessor {
    private int appId;
    protected ApplicationEntity application;

    public EntityProcessor(int appId) {
        this.appId = appId;
    }

    protected void defineApplication() {
        application = ApplicationEntity.getById(appId);

        if (application == null) {
            application = new ApplicationEntity();
            application.setId(appId);
            application.save();
        }
    }
}
