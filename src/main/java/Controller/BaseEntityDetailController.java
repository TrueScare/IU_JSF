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

        return entityDAO.getClassReference().toString().toLowerCase().replace(" ", "_") + "detail";
    }

    @Override
    public T getActiveEntity() {
        return activeEntity;
    }

    @Override
    public void updateActiveEntity() {
        activeEntity = entityDAO.getById(id);
        if (activeEntity == null) {
            try {
                activeEntity = entityDAO.getClassReference().getConstructor().newInstance();
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                     NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
