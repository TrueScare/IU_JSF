package Controller.EntityController;

import Entity.DataSetEntry;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named
@RequestScoped
public class DataSetEntryChangeDetailController extends BaseEntityDetailController<DataSetEntry> {
    private Long toBeChangedId;

    public DataSetEntryChangeDetailController() {
    }

    @Override
    public void updateActiveEntity() {


        super.updateActiveEntity();
    }

    public Long getToBeChangedId() {
        return toBeChangedId;
    }

    public void setToBeChangedId(Long toBeChangedId) {
        this.toBeChangedId = toBeChangedId;
    }
}
