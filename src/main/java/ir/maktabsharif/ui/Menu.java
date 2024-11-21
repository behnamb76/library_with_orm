package ir.maktabsharif.ui;

import ir.maktabsharif.model.Genre;
import ir.maktabsharif.model.enums.Category;
import ir.maktabsharif.util.ApplicationContext;
import ir.maktabsharif.util.InputUtility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Menu {
    private static final List<String> MAIN_MENU_ITEMS = new ArrayList<>(Arrays.asList("Add Genre", "Delete Genre", "Edit Genre", "Show All Genres", "Show All Genres with Books", "Exit"));

    public static void runProgram() {
        boolean exit = false;
        while (!exit) {
            exit = mainMenu();
        }
    }

    private static boolean mainMenu() {
        while (true) {
            System.out.println("=====================================================");
            printMenu(MAIN_MENU_ITEMS, "Menu");
            int input = InputUtility.getIntInput("\nChoice: ");
            switch (input) {
                case 1:
                    addGenre();
                    break;
                case 2:
                    deleteGenre();
                    break;
                case 3:
                    editGenre();
                    break;
                case 4:
                    showAllGenres();
                    break;
                case 5:
                    showAllGenresWithBooks();
                    break;
                case 6:
                    return false;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    private static void addGenre() {
        int choice = InputUtility.getIntInput("Choice Category (1. Nonfiction 2. Fiction): ");
        String name = InputUtility.getStringInput("Enter Genre Name: ");
        if (choice == 1) {
            Genre genre = Genre.builder()
                    .name(name)
                    .category(Category.NONFICTION).build();
            ApplicationContext.getGenreService().addGenre(genre);
        } else if (choice == 2) {
            Genre genre = Genre.builder()
                    .name(name)
                    .category(Category.FICTION).build();
            ApplicationContext.getGenreService().addGenre(genre);
        } else {
            System.out.println("Invalid choice!");
        }
    }

    private static void deleteGenre() {
        Long id = InputUtility.getLongInput("Enter id of Genre you want to delete: ");
        ApplicationContext.getGenreService().deleteGenre(id);
    }

    private static void editGenre() {
        Long id = InputUtility.getLongInput("Enter id of Genre you want to edit: ");
        int choice = InputUtility.getIntInput("Choice new Category (1. Nonfiction 2. Fiction): ");
        String name = InputUtility.getStringInput("Enter new Genre Name: ");
        if (choice == 1) {
            Genre genre = Genre.builder()
                    .id(id)
                    .name(name)
                    .category(Category.NONFICTION).build();
            ApplicationContext.getGenreService().updateGenre(genre);
        } else if (choice == 2) {
            Genre genre = Genre.builder()
                    .name(name)
                    .category(Category.FICTION).build();
            ApplicationContext.getGenreService().updateGenre(genre);
        } else {
            System.out.println("Invalid choice!");
        }
    }

    private static void showAllGenres() {
        ApplicationContext.getGenreService().getAllGenres().forEach(System.out::println);
    }

    private static void showAllGenresWithBooks() {
        ApplicationContext.getGenreService().getAllGenresHaveBook().forEach(System.out::println);
    }

    private static void printMenu(List<String> menuItems, String title) {
        System.out.println(title);
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.printf("    %d. %s%n", i + 1, menuItems.get(i));
        }
    }
}
