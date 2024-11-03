package Controller;

public interface EntityControllerInterface<T> {
    String getEntityClass();

    void loadPage();

    String getPagePath();

    void saveEntity(T entity);

    void updateEntity(T entity);

    void deleteEntity(T entity);
}
