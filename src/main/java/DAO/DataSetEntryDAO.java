package DAO;

import Entity.DataSetEntry;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@Named
@ApplicationScoped
public class DataSetEntryDAO extends BaseDAO<DataSetEntry> {
    public DataSetEntryDAO() {
        super(DataSetEntry.class);
    }
}
