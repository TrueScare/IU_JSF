package Controller;

import DAO.DataSetDAO;
import Entity.DataSet;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;

@Named
@ViewScoped
public class DatasetController implements Serializable {

    @Inject
    DataSetDAO dataSetDAO;

    public DatasetController() {
    }

    public void saveDataSet() {
        DataSet ds = new DataSet();
        ds.setLocale("de");
        ds.setDescription("Was ein hübsches Datenset!");

        dataSetDAO.save(ds);
    }
}
