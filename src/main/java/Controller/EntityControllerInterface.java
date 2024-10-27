package Controller;

public interface EntityControllerInterface<T> {
    String loadPage();

    void saveEntity(T entity);

    void updateEntity(T entity);

    void deleteEntity(T entity);
}
