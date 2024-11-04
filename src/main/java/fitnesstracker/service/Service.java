package fitnesstracker.service;

import java.util.List;

public interface Service<T, ID> {
    void create(T entity);
    T findById(ID id);
    List<T> getAll();
    void update(T entity);
    void delete(ID id);
    void deleteAll();
}