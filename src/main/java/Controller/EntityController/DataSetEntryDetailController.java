package Controller.EntityController;

import Entity.DataSetEntry;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

@Named
@ViewScoped
public class DataSetEntryDetailController extends BaseEntityDetailController<DataSetEntry> {
    public DataSetEntryDetailController() {
    }
}
