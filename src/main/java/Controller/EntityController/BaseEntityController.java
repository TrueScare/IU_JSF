package Controller.EntityController;

import DAO.DAOInterface;
import Structs.AppContext;
import Structs.Messages;
import jakarta.inject.Inject;

import java.io.Serializable;

public abstract class BaseEntityController<T> implements Serializable, EntityControllerInterface<T> {
    @Inject
    protected DAOInterface<T> entityDAO;
    @Inject
    AppContext context;
    @Inject
    Messages messages;

    @Override
    public String getEntityClass() {
        return entityDAO.getClassReference().getSimpleName();
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
