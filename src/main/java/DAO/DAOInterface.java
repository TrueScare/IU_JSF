package DAO;

import jakarta.persistence.criteria.CriteriaQuery;

import java.util.Collection;

public interface DAOInterface<T> {
    Class<T> getClassReference();

    //region manipulation
    void save(T t);

    void update(T t);

    void delete(T t);

    //endregion
    //region searching
    T getById(Long id);

    Collection<T> findAll();

    Collection<T> findByCriteria(CriteriaQuery<T> criteria);
    //endregion
}
