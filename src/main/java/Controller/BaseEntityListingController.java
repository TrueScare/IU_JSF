package Controller;

import java.util.Collection;

public abstract class BaseEntityListingController<T> extends BaseEntityController<T> implements EntityListingControllerInterface<T> {
    @Override
    public Collection<T> getListing() {
        return entityDAO.findAll();
    }

    @Override
    public String loadPage() {
        return "/" + getEntityClass().toLowerCase().replace(" ", "_") + "/listing";
    }
}
