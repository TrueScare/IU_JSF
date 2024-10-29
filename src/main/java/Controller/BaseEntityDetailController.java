package Controller;

import jakarta.faces.annotation.ManagedProperty;

import java.lang.reflect.InvocationTargetException;

public abstract class BaseEntityDetailController<T> extends BaseEntityController<T> implements EntityDetailControllerInterface<T> {

    @ManagedProperty(value = "#{param.id}")
    protected Long id;

    protected T activeEntity;

    @Override
    public String loadPage() {
        updateActiveEntity();
        return "/" + getEntityClass().toLowerCase().replace(" ", "_") + "/detail";
    }

    @Override
    public T getActiveEntity() {
        return activeEntity;
    }

    @Override
    public void updateActiveEntity() {
        if (id == null && activeEntity == null) {
            try {
                activeEntity = entityDAO.getClassReference().getConstructor().newInstance();
                return;
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                     NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        }
        activeEntity = entityDAO.getById(id);
    }
}
