package ir.maktabsharif.repository.impls;

import ir.maktabsharif.exceptions.NotFoundException;
import ir.maktabsharif.model.Book;
import ir.maktabsharif.repository.BookRepository;
import ir.maktabsharif.util.EntityManagerProvider;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class BookRepositoryImpl implements BookRepository {
    private final EntityManager em;

    public BookRepositoryImpl() {
        this.em = EntityManagerProvider.getEntityManager();
    }

    @Override
    public List<Book> findAll() {
        TypedQuery<Book> typedQuery = em.createQuery("from Book", Book.class);
        return typedQuery.getResultList();
    }

    @Override
    public void add(Book book) {
        try {
            em.getTransaction().begin();
            em.persist(book);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    @Override
    public void update(Book book) {
        try {
            Optional<Book> bookOptional = findById(book.getId());
            if (bookOptional.isPresent()) {
                Book foundBook = bookOptional.get();
                em.getTransaction().begin();

                em.getTransaction().commit();
            } else {
                throw new NotFoundException("Book with id of ".concat(String.valueOf(book.getId())).concat(" not found!"));
            }
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    @Override
    public void delete(Long id) {
        Optional<Book> BookOptional = findById(id);
        if (BookOptional.isPresent()) {
            em.getTransaction().begin();
            em.remove(BookOptional.get());
            em.getTransaction().commit();
        } else {
            throw new NotFoundException("Book with id of ".concat(String.valueOf(id)).concat(" not found!"));
        }
    }

    @Override
    public Optional<Book> findById(Long id) {
        Book bookOptional = em.find(Book.class, id);
        return Optional.ofNullable(bookOptional);
    }
}
