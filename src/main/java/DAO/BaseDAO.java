package DAO;

import jakarta.annotation.ManagedBean;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import java.util.Collection;

public abstract class BaseDAO<T> implements DAOInterface<T> {
    EntityManager entityManager;

    final Class<T> classReference;

    public BaseDAO(Class<T> classReference) {
        this.classReference = classReference;
        //injections won't work so we have to do it the old way :)
        this.entityManager = Persistence.createEntityManagerFactory("like_zero_to_hero").createEntityManager();
    }

    @Override
    public Class<T> getClassReference() {
        return classReference;
    }

    @Override
    public void save(T t) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(t);
        entityManager.flush();
        transaction.commit();
    }

    @Override
    public void update(T t) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(t);
        entityManager.flush();
        transaction.commit();
    }

    @Override
    public void delete(T t) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(t);
        entityManager.flush();
        transaction.commit();
    }

    @Override
    public T getById(Long id) {
        return entityManager.find(this.classReference, id);
    }

    @Override
    public Collection<T> findAll() {
        CriteriaQuery<T> criteriaQuery = entityManager.getCriteriaBuilder().createQuery(classReference);
        Root<T> root = criteriaQuery.from(classReference);
        criteriaQuery.select(root);
        TypedQuery<T> typedQuery = entityManager.createQuery(criteriaQuery);
        return typedQuery.getResultList();
    }

    @Override
    public Collection<T> findByCriteria(CriteriaQuery<T> criteria) {
        return entityManager.createQuery(criteria).getResultList();
    }
}
