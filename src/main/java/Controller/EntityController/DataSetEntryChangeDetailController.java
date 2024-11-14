package Controller.EntityController;

import DAO.DataSetEntryDAO;
import Entity.DataSetEntry;
import Entity.DataSetEntryChange;
import Structs.AppContext;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@ViewScoped
public class DataSetEntryChangeDetailController extends BaseEntityDetailController<DataSetEntryChange> {
    private Long toBeChangedID;
    @Inject
    DataSetEntryDAO dataSetEntryDAO;
    @Inject
    private AppContext appContext;

    public DataSetEntryChangeDetailController() {
    }

    @Override
    public void updateActiveEntity() {
        super.updateActiveEntity();
        DataSetEntry toBeChanged = dataSetEntryDAO.getById(toBeChangedID);
        if (activeEntity.getDatasetEntry() == null && toBeChanged != null) {
            activeEntity.setDatasetEntry(toBeChanged);
            activeEntity.setCountry(toBeChanged.getCountry());
            activeEntity.setEmissions(toBeChanged.getEmissions());
            activeEntity.setYear(toBeChanged.getYear());
            activeEntity.setAuthor(appContext.getActiveUser());
        }
    }

    public Long getToBeChangedID() {
        return toBeChangedID;
    }

    public void setToBeChangedID(Long toBeChangedID) {
        this.toBeChangedID = toBeChangedID;
    }
}
