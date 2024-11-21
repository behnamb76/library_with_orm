package ir.maktabsharif.service.impls;

import ir.maktabsharif.exceptions.NotFoundException;
import ir.maktabsharif.model.Genre;
import ir.maktabsharif.repository.GenreRepository;
import ir.maktabsharif.service.GenreService;

import java.util.List;

public class GenreServiceImpl implements GenreService {
    GenreRepository genreRepository;

    public GenreServiceImpl(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Override
    public void addGenre(Genre genre) {
        genreRepository.add(genre);
    }

    @Override
    public void deleteGenre(Long id) {
        try {
            genreRepository.delete(id);
        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void updateGenre(Genre genre) {
        try {
            genreRepository.update(genre);
        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }

    @Override
    public List<Genre> getAllGenresHaveBook() {
        return genreRepository.findAllGenresHaveBook();
    }
}
