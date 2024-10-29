package Controller;

import Entity.DataSet;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;


@Named
@RequestScoped
public class DataSetDetailController extends BaseEntityDetailController<DataSet> {

    public DataSetDetailController() {
    }
}
