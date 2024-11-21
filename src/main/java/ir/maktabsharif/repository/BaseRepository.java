package ir.maktabsharif.repository;

import java.util.List;
import java.util.Optional;

public interface BaseRepository<T> {
    List<T> findAll();

    void add(T entity);

    void update(T entity);

    void delete(Long id);

    Optional<T> findById(Long id);
}
