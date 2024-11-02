package Controller;

import Entity.DataSet;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;


@Named
@RequestScoped
public class DataSetDetailController extends BaseEntityDetailController<DataSet> {

    public DataSetDetailController() {
    }
}
