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
        Album albumOne = new Album("good quality", "World images", 200);
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
                System.out.println("Library aplication.\n Manual: \n Keyboard 1: List books \n Keyboard 2: Add book\n Keyboard 3: Remove book\n Keyboard 4: Exit");
                option = scanner.nextInt();
            }

            switch (option) {
                case 1:
                    int counter = 1;
                    for (Book book : bookList) {

                        if (book instanceof Novel) {
                            Novel novelBook = (Novel) book;

                            System.out.println("Book number " + counter);
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
                    break;
                case 2:
                    System.out.println("2");
                    break;
                case 3:
                    System.out.println("3");
                    break;

                case 4:
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
}
