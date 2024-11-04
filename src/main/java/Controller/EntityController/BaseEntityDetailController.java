package Controller.EntityController;

import java.lang.reflect.InvocationTargetException;

public abstract class BaseEntityDetailController<T> extends BaseEntityController<T> implements EntityDetailControllerInterface<T> {

    protected Long entityID;

    protected T activeEntity;

    @Override
    public void loadPage() {
        updateActiveEntity();
    }

    @Override
    public String getPagePath() {
        return "/" + getEntityClass().toLowerCase().replace(" ", "_") + "/detail";
    }

    @Override
    public String getPagePath(Long id) {
        return "/" + getEntityClass().toLowerCase().replace(" ", "_") + "/detail?entityID=" + id;
    }

    @Override
    public T getActiveEntity() {
        return activeEntity;
    }

    public void setActiveEntity(T activeEntity) {
        this.activeEntity = activeEntity;
    }

    @Override
    public void updateActiveEntity() {
        if (entityID == null && activeEntity == null) {
            try {
                activeEntity = entityDAO.getClassReference().getConstructor().newInstance();
                return;
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                     NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        }
        activeEntity = entityDAO.getById(entityID);
    }

    public void setEntityID(Long entityID) {
        this.entityID = entityID;
    }

    public Long getEntityID() {
        return entityID;
    }
}
