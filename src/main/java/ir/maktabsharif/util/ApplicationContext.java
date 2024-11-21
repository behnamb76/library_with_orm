package ir.maktabsharif.util;


import ir.maktabsharif.repository.BookRepository;
import ir.maktabsharif.repository.GenreRepository;
import ir.maktabsharif.repository.LibrarianRepository;
import ir.maktabsharif.repository.LibraryMemberRepository;
import ir.maktabsharif.repository.impls.BookRepositoryImpl;
import ir.maktabsharif.repository.impls.GenreRepositoryImpl;
import ir.maktabsharif.repository.impls.LibrarianRepositoryImpl;
import ir.maktabsharif.repository.impls.LibraryMemberRepositoryImpl;
import ir.maktabsharif.service.BookService;
import ir.maktabsharif.service.GenreService;
import ir.maktabsharif.service.LibrarianService;
import ir.maktabsharif.service.LibraryMemberService;
import ir.maktabsharif.service.impls.BookServiceImpl;
import ir.maktabsharif.service.impls.GenreServiceImpl;
import ir.maktabsharif.service.impls.LibrarianServiceImpl;
import ir.maktabsharif.service.impls.LibraryMemberServiceImpl;

public class ApplicationContext {
    private static BookRepository bookRepository;
    private static GenreRepository genreRepository;
    private static LibrarianRepository librarianRepository;
    private static LibraryMemberRepository libraryMemberRepository;
    private static BookService bookService;
    private static GenreService genreService;
    private static LibrarianService librarianService;
    private static LibraryMemberService libraryMemberService;

    static {
        bookRepository = new BookRepositoryImpl();
        genreRepository = new GenreRepositoryImpl();
        librarianRepository = new LibrarianRepositoryImpl();
        libraryMemberRepository = new LibraryMemberRepositoryImpl();
//        bookService = new BookServiceImpl(bookRepository);
        genreService = new GenreServiceImpl(genreRepository);
//        librarianService = new LibrarianServiceImpl(librarianRepository);
//        libraryMemberService = new LibraryMemberServiceImpl(libraryMemberRepository);
    }

    public static BookService getBookService() {
        return bookService;
    }

    public static GenreService getGenreService() {
        return genreService;
    }

    public static LibrarianService getLibrarianService() {
        return librarianService;
    }

    public static LibraryMemberService getLibraryMemberService() {
        return libraryMemberService;
    }


}
