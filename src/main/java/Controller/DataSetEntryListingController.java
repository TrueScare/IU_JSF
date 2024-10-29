package Controller;

import Entity.DataSetEntry;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named
@RequestScoped
public class DataSetEntryListingController extends BaseEntityListingController<DataSetEntry> {
    public DataSetEntryListingController() {
    }
}
