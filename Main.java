import java.util.ArrayList;
import java.util.Scanner;

class Book {
    private int bookId;
    private String title;
    private boolean issued;

    Book(int bookId, String title) {
        this.bookId = bookId;
        this.title = title;
        this.issued = false;
    }

    public int getBookId() {
        return bookId;
    }

    public boolean isIssued() {
        return issued;
    }

    public void issueBook() {
        issued = true;
    }

    public void returnBook() {
        issued = false;
    }

    public void display() {
        System.out.println("Book ID: " + bookId);
        System.out.println("Title: " + title);
        System.out.println("Status: " + (issued ? "Issued" : "Available"));
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Book> books = new ArrayList<>();

        while (true) {

            System.out.println("\n===== Library Management System =====");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Search Book");
            System.out.println("4. Issue Book");
            System.out.println("5. Return Book");
            System.out.println("6. Delete Book");
            System.out.println("7. Exit");

            System.out.print("Enter Choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Book ID: ");
                    int id = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Enter Book Title: ");
                    String title = sc.nextLine();

                    books.add(new Book(id, title));

                    System.out.println("Book Added Successfully!");
                    break;

                case 2:
                    if (books.isEmpty()) {
                        System.out.println("No Books Available.");
                    } else {
                        for (Book b : books) {
                            b.display();
                            System.out.println("----------------");
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter Book ID: ");
                    int searchId = sc.nextInt();

                    boolean found = false;

                    for (Book b : books) {
                        if (b.getBookId() == searchId) {
                            b.display();
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Book Not Found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter Book ID: ");
                    int issueId = sc.nextInt();

                    boolean issued = false;

                    for (Book b : books) {
                        if (b.getBookId() == issueId) {

                            if (!b.isIssued()) {
                                b.issueBook();
                                System.out.println("Book Issued Successfully!");
                            } else {
                                System.out.println("Book Already Issued.");
                            }

                            issued = true;
                            break;
                        }
                    }

                    if (!issued) {
                        System.out.println("Book Not Found.");
                    }
                    break;

                case 5:
                    System.out.print("Enter Book ID: ");
                    int returnId = sc.nextInt();

                    boolean returned = false;

                    for (Book b : books) {
                        if (b.getBookId() == returnId) {

                            if (b.isIssued()) {
                                b.returnBook();
                                System.out.println("Book Returned Successfully!");
                            } else {
                                System.out.println("Book is Already Available.");
                            }

                            returned = true;
                            break;
                        }
                    }

                    if (!returned) {
                        System.out.println("Book Not Found.");
                    }
                    break;

                case 6:
                    System.out.print("Enter Book ID: ");
                    int deleteId = sc.nextInt();

                    boolean deleted = false;

                    for (int i = 0; i < books.size(); i++) {
                        if (books.get(i).getBookId() == deleteId) {
                            books.remove(i);
                            deleted = true;
                            System.out.println("Book Deleted Successfully!");
                            break;
                        }
                    }

                    if (!deleted) {
                        System.out.println("Book Not Found.");
                    }
                    break;

                case 7:
                    System.out.println("Thank You!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}