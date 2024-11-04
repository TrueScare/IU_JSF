package Controller.EntityController;

public interface EntityDetailControllerInterface<T> extends EntityControllerInterface<T> {
    T getActiveEntity();

    void updateActiveEntity();

    String getPagePath(Long id);
}
