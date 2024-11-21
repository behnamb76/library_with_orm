package ir.maktabsharif.repository.impls;

import ir.maktabsharif.exceptions.NotFoundException;
import ir.maktabsharif.model.Librarian;
import ir.maktabsharif.repository.LibrarianRepository;
import ir.maktabsharif.util.EntityManagerProvider;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class LibrarianRepositoryImpl implements LibrarianRepository {
    private final EntityManager em;

    public LibrarianRepositoryImpl() {
        this.em = EntityManagerProvider.getEntityManager();
    }

    @Override
    public List<Librarian> findAll() {
        TypedQuery<Librarian> typedQuery = em.createQuery("from Librarian", Librarian.class);
        return typedQuery.getResultList();
    }

    @Override
    public void add(Librarian librarian) {
        try {
            em.getTransaction().begin();
            em.persist(librarian);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    @Override
    public void update(Librarian librarian) {
        try {
            Optional<Librarian> librarianOptional = findById(librarian.getId());
            if (librarianOptional.isPresent()) {
                Librarian foundLibrarian = librarianOptional.get();
                em.getTransaction().begin();
                foundLibrarian.setFirstName(librarian.getFirstName());
                foundLibrarian.setLastName(librarian.getLastName());
                foundLibrarian.setDob(librarian.getDob());
                foundLibrarian.setGender(librarian.getGender());
                foundLibrarian.setNationalCode(librarian.getNationalCode());
                em.getTransaction().commit();
            } else {
                throw new NotFoundException("Librarian with id of ".concat(String.valueOf(librarian.getId())).concat(" not found!"));
            }
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    @Override
    public void delete(Long id) {
        Optional<Librarian> librarianOptional = findById(id);
        if (librarianOptional.isPresent()) {
            em.getTransaction().begin();
            em.remove(librarianOptional.get());
            em.getTransaction().commit();
        } else {
            throw new NotFoundException("Librarian with id of ".concat(String.valueOf(id)).concat(" not found!"));
        }
    }

    @Override
    public Optional<Librarian> findById(Long id) {
        Librarian librarianOptional = em.find(Librarian.class, id);
        return Optional.ofNullable(librarianOptional);
    }
}
