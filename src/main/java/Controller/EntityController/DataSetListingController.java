package Controller.EntityController;

import Entity.DataSet;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named
@RequestScoped
public class DataSetListingController extends BaseEntityListingController<DataSet> {
    public DataSetListingController() {
    }
}
