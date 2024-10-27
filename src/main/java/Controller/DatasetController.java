package Controller;

import Entity.DataSet;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;


@Named
@ViewScoped
public class DatasetController extends BaseEntityController<DataSet> {

    public DatasetController() {
    }
}
