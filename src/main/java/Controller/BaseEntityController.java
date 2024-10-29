package Controller;

import DAO.DAOInterface;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Model;
import jakarta.inject.Inject;

import java.io.Serializable;

public abstract class BaseEntityController<T> implements Serializable, EntityControllerInterface<T> {
    @Inject
    protected DAOInterface<T> entityDAO;

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
