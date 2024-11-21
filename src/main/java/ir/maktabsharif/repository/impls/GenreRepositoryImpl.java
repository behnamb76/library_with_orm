package ir.maktabsharif.repository.impls;

import ir.maktabsharif.exceptions.NotFoundException;
import ir.maktabsharif.model.Book;
import ir.maktabsharif.model.Genre;
import ir.maktabsharif.repository.GenreRepository;
import ir.maktabsharif.util.EntityManagerProvider;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.List;
import java.util.Optional;

public class GenreRepositoryImpl implements GenreRepository {
    private final EntityManager em;

    public GenreRepositoryImpl() {
        this.em = EntityManagerProvider.getEntityManager();
    }

    @Override
    public List<Genre> findAll() {
        TypedQuery<Genre> typedQuery = em.createQuery("from Genre", Genre.class);
        return typedQuery.getResultList();
    }

    @Override
    public void add(Genre genre) {
        try {
            em.getTransaction().begin();
            em.persist(genre);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    @Override
    public void update(Genre genre) {
        try {
            Optional<Genre> genreOptional = findById(genre.getId());
            if (genreOptional.isPresent()) {
                Genre foundGenre = genreOptional.get();
                em.getTransaction().begin();
                foundGenre.setName(genre.getName());
                foundGenre.setCategory(genre.getCategory());
                em.getTransaction().commit();
            } else {
                throw new NotFoundException("Genre with id of ".concat(String.valueOf(genre.getId())).concat(" not found!"));
            }
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    @Override
    public void delete(Long id) {
        Optional<Genre> GenreOptional = findById(id);
        if (GenreOptional.isPresent()) {
            em.getTransaction().begin();
            em.remove(GenreOptional.get());
            em.getTransaction().commit();
        } else {
            throw new NotFoundException("Genre with id of ".concat(String.valueOf(id)).concat(" not found!"));
        }
    }

    @Override
    public Optional<Genre> findById(Long id) {
        Genre genreOptional = em.find(Genre.class, id);
        return Optional.ofNullable(genreOptional);
    }

    @Override
    public List<Genre> findAllGenresHaveBook() {
        TypedQuery<Genre> query = em.createQuery("SELECT g FROM Genre g WHERE SIZE(g.books) > 0", Genre.class);
        return query.getResultList();
    }
}
