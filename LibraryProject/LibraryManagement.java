import java.util.*;

class Book {
    int id;
    String title;
    String author;

    Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    void display() {
        System.out.println("ID: " + id + ", Title: " + title + ", Author: " + author);
    }
}

public class LibraryManagement {
    static ArrayList<Book> books = new ArrayList<>();

    static void addBook(int id, String title, String author) {
        books.add(new Book(id, title, author));
        System.out.println("Book Added!");
    }

    static void removeBook(int id) {
        books.removeIf(b -> b.id == id);
        System.out.println("Book Removed (if existed).");
    }

    static void searchBook(String title) {
        for (Book b : books) {
            if (b.title.equalsIgnoreCase(title)) {
                System.out.println("Found:");
                b.display();
                return;
            }
        }
        System.out.println("Not Found!");
    }

    static void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No Books!");
            return;
        }
        for (Book b : books) {
            b.display();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1.Add  2.Remove  3.Search  4.Display  5.Exit");
            System.out.print("Choice: ");
            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1:
                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Title: ");
                    String t = sc.nextLine();
                    System.out.print("Author: ");
                    String a = sc.nextLine();
                    addBook(id, t, a);
                    break;

                case 2:
                    System.out.print("Enter ID: ");
                    removeBook(sc.nextInt());
                    break;

                case 3:
                    sc.nextLine();
                    System.out.print("Enter Title: ");
                    searchBook(sc.nextLine());
                    break;

                case 4:
                    displayBooks();
                    break;

                case 5:
                    return;

                default:
                    System.out.println("Wrong Choice!");
            }
        }
    }
}