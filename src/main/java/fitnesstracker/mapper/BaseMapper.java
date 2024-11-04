package fitnesstracker.mapper;

import java.util.List;

public interface BaseMapper<T, ID> {

    T findById(ID id);

    List<T> getAll();

    void create(T entity);

    void update(T entity);

    void delete(ID id);

    void deleteAll();
}
