package Controller.EntityController;

import DAO.DataSetEntryChangeDAO;
import Entity.DataSetEntry;
import Entity.DataSetEntryChange;
import Structs.AppContext;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.util.Collection;

@Named
@RequestScoped
public class DataSetEntryChangeListingController extends BaseEntityListingController<DataSetEntryChange> {
    @Inject
    DataSetEntryChangeDAO entityDAO;
    @Named
    @Inject
    private AppContext appContext;

    public DataSetEntryChangeListingController() {
    }

    @Override
    public Collection<DataSetEntryChange> getListing() {
        return entityList = entityDAO.getChangesToBeApproved(appContext.getActiveUser().getId());
    }
}
