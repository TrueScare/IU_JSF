package Controller.EntityController;

import DAO.DataSetEntryChangeDAO;
import Entity.DataSetEntry;
import Entity.DataSetEntryChange;
import Structs.AppContext;
import jakarta.el.MethodExpression;
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

    public void acceptRequest(DataSetEntryChange change) {
        // set flag
        change.setApproved(true);

        // update DataSetEntry values and persist
        DataSetEntry toBeChanged = change.getDatasetEntry();
        toBeChanged.setCountry(change.getCountry());
        toBeChanged.setEmissions(change.getEmissions());
        toBeChanged.setYear(change.getYear());

        entityDAO.update(change);
    }

    public void denyRequest(DataSetEntryChange change) {
        // set flag and update, no further actions needed
        change.setApproved(false);
        entityDAO.update(change);
    }
}
