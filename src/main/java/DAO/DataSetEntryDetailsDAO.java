package DAO;

import Entity.DataSetEntryDetails;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@Named
@ApplicationScoped
public class DataSetEntryDetailsDAO extends BaseDAO<DataSetEntryDetails> {
    public DataSetEntryDetailsDAO() {
        super(DataSetEntryDetails.class);
    }
}
