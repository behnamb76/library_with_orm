package ir.maktabsharif.service;

import ir.maktabsharif.model.Genre;

import java.util.List;

public interface GenreService {
    void addGenre(Genre genre);
    void deleteGenre(Long id);
    void updateGenre(Genre genre);
    List<Genre> getAllGenres();
    List<Genre> getAllGenresHaveBook();

}
