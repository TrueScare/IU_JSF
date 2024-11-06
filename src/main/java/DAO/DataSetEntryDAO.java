package DAO;

import Entity.DataSetEntry;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;
import java.util.Locale;

@Named
@ApplicationScoped
public class DataSetEntryDAO extends BaseDAO<DataSetEntry> {
    public DataSetEntryDAO() {
        super(DataSetEntry.class);
    }

    @Override
    public List<DataSetEntry> findAll() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<DataSetEntry> cq = cb.createQuery(DataSetEntry.class);
        Root<DataSetEntry> root = cq.from(DataSetEntry.class);
        cq.select(root);
        cq.orderBy(cb.desc(root.get("year")), cb.desc(root.get("updatedLast")));
        return findByCriteria(cq);
    }

    public List<DataSetEntry> getListingByLocale(Locale locale) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<DataSetEntry> cq = cb.createQuery(DataSetEntry.class);
        Root<DataSetEntry> root = cq.from(DataSetEntry.class);
        cq.select(root);
        cq.where(cb.equal(root.get("country"), locale.getDisplayCountry()));
        cq.orderBy(cb.desc(root.get("year")), cb.desc(root.get("updatedLast")));
        return findByCriteria(cq);
    }
}
