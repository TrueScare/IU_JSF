package DAO;

import Entity.DataSetEntryChange;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@Named
@ApplicationScoped
public class DataSetEntryChangeDAO extends BaseDAO<DataSetEntryChange> {
    public DataSetEntryChangeDAO() {
        super(DataSetEntryChange.class);
    }
}
