package DAO;

import Entity.DataSet;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@Named
@ApplicationScoped
public class DataSetDAO extends BaseDAO<DataSet> {
    public DataSetDAO() {
        super(DataSet.class);
    }
}
