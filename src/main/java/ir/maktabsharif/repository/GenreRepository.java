package ir.maktabsharif.repository;

import ir.maktabsharif.model.Genre;

import java.util.List;

public interface GenreRepository extends BaseRepository<Genre> {
    List<Genre> findAllGenresHaveBook();
}
