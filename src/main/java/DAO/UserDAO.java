package DAO;

import Entity.User;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;

@Named
@ApplicationScoped
public class UserDAO extends BaseDAO<User> {
    public UserDAO() {
        super(User.class);
    }

    public User getUserUsername(String username) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);
        Root<User> root = cq.from(User.class);
        cq.select(root);
        cq.where(cb.equal(root.get("username"), username));
        List<User> results = findByCriteria(cq);
        return results.getFirst();
    }
}
