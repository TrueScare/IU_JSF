package Controller;

public interface EntityDetailControllerInterface<T> extends EntityControllerInterface<T> {
    T getActiveEntity();

    void updateActiveEntity();
}
