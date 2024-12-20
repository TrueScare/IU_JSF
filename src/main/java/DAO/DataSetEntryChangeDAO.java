package DAO;

import Entity.DataSetEntry;
import Entity.DataSetEntryChange;
import Entity.User;
import Structs.AppContext;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.persistence.criteria.*;

import java.util.List;

@Named
@ApplicationScoped
public class DataSetEntryChangeDAO extends BaseDAO<DataSetEntryChange> {

    public DataSetEntryChangeDAO() {
        super(DataSetEntryChange.class);
    }

    public List<DataSetEntryChange> getChangesToBeApproved(String username) {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<DataSetEntryChange> cq = cb.createQuery(DataSetEntryChange.class);
        Root<DataSetEntryChange> root = cq.from(DataSetEntryChange.class);
        cq.select(root);
        Join<DataSetEntryChange, DataSetEntry> entry = root.join("datasetEntry", JoinType.INNER);
        Join<DataSetEntry, User> user = entry.join("owner", JoinType.INNER);
        cq.where(cb.and(
                        cb.isNull(root.get("approved")),
                        cb.equal(user.get("username"), username)
                )
        );
        cq.orderBy(cb.asc(root.get("createdAt")));
        return findByCriteria(cq);
    }
}
