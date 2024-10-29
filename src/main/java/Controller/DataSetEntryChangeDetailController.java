package Controller;

import Entity.DataSetEntry;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named
@RequestScoped
public class DataSetEntryChangeDetailController extends BaseEntityDetailController<DataSetEntry> {
    public DataSetEntryChangeDetailController() {
    }
}
