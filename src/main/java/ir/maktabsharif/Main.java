package ir.maktabsharif;

import ir.maktabsharif.model.Book;
import ir.maktabsharif.model.Genre;
import ir.maktabsharif.model.Librarian;
import ir.maktabsharif.model.LibraryMember;
import ir.maktabsharif.model.enums.Category;
import ir.maktabsharif.model.enums.Gender;
import ir.maktabsharif.repository.BookRepository;
import ir.maktabsharif.repository.LibrarianRepository;
import ir.maktabsharif.repository.LibraryMemberRepository;
import ir.maktabsharif.repository.impls.BookRepositoryImpl;
import ir.maktabsharif.repository.impls.LibrarianRepositoryImpl;
import ir.maktabsharif.repository.impls.LibraryMemberRepositoryImpl;
import ir.maktabsharif.ui.Menu;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        BookRepository bookRepository = new BookRepositoryImpl();
        LibrarianRepository librarianRepository = new LibrarianRepositoryImpl();
        LibraryMemberRepository libraryMemberRepository = new LibraryMemberRepositoryImpl();

//        Librarian librarian = new Librarian();
//        librarian.setFirstName("John");
//        librarian.setLastName("Doe");
//        librarian.setGender(Gender.MALE);
//        librarian.setDob(new Date(1997 - 1900, 2 - 1, 6));
//        librarian.setNationalCode("111");
//        librarianRepository.add(librarian);

//        LibraryMember libraryMember = new LibraryMember();
//        libraryMember.setFirstName("John");
//        libraryMember.setLastName("Smith");
//        libraryMember.setGender(Gender.MALE);
//        libraryMember.setDob(new Date(1999 - 1900, 6 - 1, 10));
//        libraryMember.setNationalCode("222");
//        libraryMemberRepository.add(libraryMember);

//        Genre genre = Genre.builder()
//                .id(3L)
//                .name("Cooking")
//                .category(Category.NONFICTION).build();
//        Book book = Book.builder()
//                .title("Persian food")
//                .isbn("111")
//                .author("ali ahmadi")
//                .numberOfPages(150)
//                .publishedDate(new Date(2010 - 1900, 6 - 1, 10))
//                .genre(genre).build();
//        bookRepository.add(book);

        Menu.runProgram();
    }
}
