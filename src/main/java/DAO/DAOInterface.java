package DAO;

import jakarta.persistence.criteria.CriteriaQuery;

import java.util.Collection;
import java.util.Optional;

public interface DAOInterface<T> {
    //region manipulation
    void save(T t);

    void update(T t);

    void delete(T t);

    //endregion
    //region searching
    Optional<T> getById(Long id);

    Collection<T> findAll();

    Collection<T> findByCriteria(CriteriaQuery<T> criteria);
    //endregion
}
