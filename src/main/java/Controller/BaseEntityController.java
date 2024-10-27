package Controller;

import DAO.DAOInterface;
import jakarta.inject.Inject;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

public abstract class BaseEntityController<T> implements Serializable, EntityControllerInterface<T> {
    @Inject
    private DAOInterface<T> entityDAO;

    private T activeEntity = null;

    public void setActiveEntity(Long id) {
        activeEntity = entityDAO.getById(id);
    }

    public T getActiveEntity() {
        /* if there is no active entity, make one */
        if (activeEntity == null) {
            try {
                activeEntity = entityDAO.getClassReference().getConstructor().newInstance();
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                     NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        }

        return activeEntity;
    }

    public Collection<T> getListing() {
        return entityDAO.findAll();
    }

    @Override
    public void saveEntity(T entity) {
        entityDAO.save(entity);
    }

    @Override
    public void updateEntity(T entity) {
        entityDAO.update(entity);
    }

    @Override
    public void deleteEntity(T entity) {
        entityDAO.delete(entity);
    }
}
