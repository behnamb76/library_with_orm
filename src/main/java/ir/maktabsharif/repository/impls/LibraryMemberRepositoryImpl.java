package ir.maktabsharif.repository.impls;

import ir.maktabsharif.exceptions.NotFoundException;
import ir.maktabsharif.model.LibraryMember;
import ir.maktabsharif.repository.LibraryMemberRepository;
import ir.maktabsharif.util.EntityManagerProvider;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class LibraryMemberRepositoryImpl implements LibraryMemberRepository {
    private final EntityManager em;

    public LibraryMemberRepositoryImpl() {
        this.em = EntityManagerProvider.getEntityManager();
    }

    @Override
    public List<LibraryMember> findAll() {
        TypedQuery<LibraryMember> typedQuery = em.createQuery("from LibraryMember", LibraryMember.class);
        return typedQuery.getResultList();
    }

    @Override
    public void add(LibraryMember libraryMember) {
        try {
            em.getTransaction().begin();
            em.persist(libraryMember);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    @Override
    public void update(LibraryMember libraryMember) throws NotFoundException {
        try {
            Optional<LibraryMember> libraryMemberOptional = findById(libraryMember.getId());
            if (libraryMemberOptional.isPresent()) {
                LibraryMember foundLibraryMember = libraryMemberOptional.get();
                em.getTransaction().begin();
                foundLibraryMember.setFirstName(libraryMember.getFirstName());
                foundLibraryMember.setLastName(libraryMember.getLastName());
                foundLibraryMember.setDob(libraryMember.getDob());
                foundLibraryMember.setGender(libraryMember.getGender());
                foundLibraryMember.setNationalCode(libraryMember.getNationalCode());
                em.getTransaction().commit();
            } else {
                throw new NotFoundException("Library Member with id of ".concat(String.valueOf(libraryMember.getId())).concat(" not found!"));
            }
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    @Override
    public void delete(Long id) throws NotFoundException {
        Optional<LibraryMember> libraryMemberOptional = findById(id);
        if (libraryMemberOptional.isPresent()) {
            em.getTransaction().begin();
            em.remove(libraryMemberOptional.get());
            em.getTransaction().commit();
        } else {
            throw new NotFoundException("Library Member with id of ".concat(String.valueOf(id)).concat(" not found!"));
        }
    }

    @Override
    public Optional<LibraryMember> findById(Long id) {
        LibraryMember libraryMemberOptional = em.find(LibraryMember.class, id);
        return Optional.ofNullable(libraryMemberOptional);
    }
}
