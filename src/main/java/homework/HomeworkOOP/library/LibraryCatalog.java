package homework.HomeworkOOP.library;

import homework.HomeworkOOP.library.entity.Album;
import homework.HomeworkOOP.library.entity.Book;
import homework.HomeworkOOP.library.entity.Novel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibraryCatalog {
    public static void main(String[] args) throws Exception {

        List<Book> bookList = new ArrayList<Book>();

        //CRUD
        Novel novelOne = new Novel("novels", "Back in future", 200);
        bookList.add(novelOne);
        Album albumOne = new Album(1000, "World images", 200);
        bookList.add(albumOne);

        System.out.println("Library aplication.\n Manual: \n Keyboard 1: List books \n Keyboard 2: Add book\n Keyboard 3: Remove book\n Keyboard 4: Exit");
        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();

        if (option < 1 || option > 4) {
            throw new Exception("Bad option selected!");
        }

        boolean begin = true;
        while (option >= 0 && option < 5) {

            if (begin == false) {
                System.out.println("Library aplication.\n Manual: \n Keyboard 1: List books \n Keyboard 2: Add book\n Keyboard 3: Edit book\n Keyboard 4: Remove book\n Keyboard 5: Exit");
                option = scanner.nextInt();
            }

            switch (option) {
                case 1:
                    listBooks(bookList);
                    break;
                case 2:
                    addBook(scanner, 2, bookList);
                    break;
                case 3:

                    editBook(scanner, bookList);
                    break;
                case 4:
                    removeBook(scanner, bookList);
                    option = 0;
                    break;

                case 5:
                    option = 5;
                    System.out.println("Exit");
                    break;

                default:
                    option = 0;
                    System.out.println("Bad selection!");
            }
            begin = false;
        }
    }

    public static void removeBook(Scanner scanner, List<Book> bookList) {
        System.out.println("Select book index that you want to remove :");
        int bookRemoveIndex = scanner.nextInt();



        Book bookToRemove = bookList.get(bookRemoveIndex);

        boolean containsBook = bookList.contains(bookToRemove);
        if (containsBook) {
            bookList.remove(bookToRemove);
            System.out.println("Book removed successfully");
        } else {
            System.out.println("Book index not found!");
        }
    }

    public static void editBook(Scanner scanner, List<Book> bookList) {
        System.out.println("Select book index that you want to edit or -2 to exit add book section :");
        int bookEditIndex = scanner.nextInt();

        boolean beginEdit = true;
        while (bookEditIndex > -2) {

            if (beginEdit == false || bookEditIndex == -1) {
                System.out.println("Select book index that you want to edit or type :");
                bookEditIndex = scanner.nextInt();
            }

            Book editBook = bookList.get(bookEditIndex);

            if (editBook instanceof Album) {
                Album editAlbum = (Album) editBook;

                System.out.println("Old pixel quality value is " + editAlbum.getPaperQuality() + ", type new value: ");
                int albumQuality = scanner.nextInt();

                System.out.println("Old album name value is " + editAlbum.getName() + ", type new value: ");
                String albumName = scanner.next();

                System.out.println("Old album number of pages value is " + editAlbum.getNumberOfPages() + ", type new value: ");
                int albumPages = scanner.nextInt();

                Album editAlbumNew = new Album(albumQuality, albumName, albumPages);
                bookList.set(bookEditIndex, editAlbumNew);

                System.out.println("Book was edited with succes!");
                System.out.println("If you want to go back to the main menu type -2 or -1 to edit another book! ");
                bookEditIndex = scanner.nextInt();

            } else if (editBook instanceof Novel) {
                Novel editNovel = (Novel) editBook;

                System.out.println("Old novel type value is " + editNovel.getType() + ", type new value: ");
                String novelType = scanner.next();

                System.out.println("Old novel name value is " + editNovel.getName() + ", type new value: ");
                String novelName = scanner.next();

                System.out.println("Old novel number of pages value is " + editNovel.getNumberOfPages() + ", type new value: ");
                int novelPages = scanner.nextInt();

                Novel editNovelNew = new Novel(novelType, novelName, novelPages);
                bookList.set(bookEditIndex, editNovelNew);

                System.out.println("Book was edited with succes!");
                System.out.println("If you want to go back to the main menu type -2 or -1 to edit another book! ");
                bookEditIndex = scanner.nextInt();
            } else {
                System.out.println("Book not found! Try again!");
            }
            beginEdit = false;
        }
    }

    public static void listBooks(List<Book> bookList) {
        int counter = 0;
        for (Book book : bookList) {

            System.out.println("Book index is " + counter);
            if (book instanceof Novel) {
                Novel novelBook = (Novel) book;

                System.out.println("Book type is Novel");
                System.out.println("Novel type is " + novelBook.getType());
            }

            if (book instanceof Album) {
                Album albumBook = (Album) book;

                System.out.println("Book type is Album");
                System.out.println("Album paper quality is " + albumBook.getPaperQuality());
            }

            System.out.println("Book name is " + book.getName());
            System.out.println("Book number of pages is " + book.getNumberOfPages());
            System.out.println("=================================");
            counter++;
        }
    }

    public static void addBook(Scanner scanner, int option, List<Book> bookList) {
        System.out.println("Select book type that you want to add :\n Keyboard 1: Album \n Keyboard 2: Novel \n Keyboard 3: Exit from add section ");
        int optionAdd = scanner.nextInt();

        boolean beginAdd = true;
        while (optionAdd > 0 && option < 3) {

            if (beginAdd == false) {
                System.out.println("Select book type that you want to add :\n Keyboard 1: Album \n Keyboard 2: Novel \n Keyboard 3: Exit from add section ");
                optionAdd = scanner.nextInt();
            }

            if (optionAdd == 1) {

                try {
                    System.out.println("Type quality in pixels : ");
                    int albumQuality = scanner.nextInt();

                    System.out.println("Type album name : ");
                    String albumName = scanner.next();

                    System.out.println("Type album number of pages : ");
                    int albumPages = scanner.nextInt();

                    Album album = new Album(albumQuality, albumName, albumPages);
                    bookList.add(album);
                } catch (NumberFormatException ex) {
                    System.out.println(ex.getMessage());
                    System.out.println("Try again!");
                    optionAdd = 0;
                    continue;
                }

            } else if (optionAdd == 2) {

                try {
                    System.out.println("Type novel type : ");
                    String novelType = scanner.next();

                    System.out.println("Type novel name : ");
                    String novelName = scanner.next();

                    System.out.println("Type nuvel number of pages : ");
                    int novelPages = scanner.nextInt();

                    Novel novel = new Novel(novelType, novelName, novelPages);
                    bookList.add(novel);
                } catch (NumberFormatException ex) {
                    System.out.println(ex.getMessage());
                    System.out.println("Try again!");
                    optionAdd = 0;
                    continue;
                }
            } else if (optionAdd == 3) {
                break;
            } else {
                System.out.println("Option for book add should be 1 or 2!");
                optionAdd = 0;
            }

            beginAdd = false;
        }
    }
}
