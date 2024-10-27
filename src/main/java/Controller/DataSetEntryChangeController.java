package Controller;

import Entity.DataSetEntry;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

@Named
@ViewScoped
public class DataSetEntryChangeController extends BaseEntityController<DataSetEntry> {
    public DataSetEntryChangeController() {
    }
}
