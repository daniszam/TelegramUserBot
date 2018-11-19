package repository;

import java.util.List;

public interface CrudRepository<T> {
    void add(T model);
    T getOneById(Long id);
    List<T> getAll();
    void delete(Long id);
}
