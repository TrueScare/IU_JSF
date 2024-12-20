package Controller.EntityController;

import java.util.Collection;

public interface EntityListingControllerInterface<T> extends EntityControllerInterface<T> {
    Collection<T> getListing();
}
