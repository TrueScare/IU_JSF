package Controller;

import java.util.Collection;

public abstract class BaseEntityListingController<T> extends BaseEntityController<T> implements EntityListingControllerInterface<T> {
    Collection<T> entityList;

    @Override
    public Collection<T> getListing() {
        return entityList = entityDAO.findAll();
    }

    @Override
    public String getPagePath() {
        return "/" + getEntityClass().toLowerCase().replace(" ", "_") + "/listing";
    }

    @Override
    public void deleteEntity(T entity) {
        entityList.remove(entity); // update realtime listing
        super.deleteEntity(entity); // then delete in background
    }

    @Override
    public void loadPage() {

    }
}
