import java.util.Scanner;

public class LibraryManagementSystem {
    public static void main(String[] args){
        String[] Books = new String[100];
        boolean[] borrowed = new boolean[100];
        int count = 0;
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        String book;
        boolean found;

        System.out.println("Welcome to Library management system!!");

        do{
            found = false;

            System.out.println("1. Add Book");
            System.out.println("2. View all books");
            System.out.println("3. Borrow book");
            System.out.println("4. Return book");
            System.out.println("5. Search book");
            System.out.println("6. Delete book");
            System.out.println("7. Exit");

            choice = sc.nextInt();
            sc.nextLine();



            switch(choice){
                case 1:
                    if(count == Books.length){
                        System.out.println("Maximum book limit (100) reached.");
                    } else {
                        System.out.println("Name the book that you want to add: ");
                        book = sc.nextLine();
                        for (int i = 0; i < count; i++) {
                            if (book.equalsIgnoreCase(Books[i])) {
                                found = true;
                                System.out.println("The book already exists!");
                                break;
                            }
                        }
                        if (found == false) {
                            Books[count] = book;
                            borrowed[count] = false;
                            System.out.println("Thank you for adding the book " + Books[count]);
                            count++;
                        }
                    }

                    break;
                case 2:

                    int borrow = 0;

                    if(count == 0){
                        System.out.println("There are no books available currently.");
                    } else {
                        System.out.println("Library has the following books at the moment: ");

                        for (int i = 0; i < count; i++) {
                            System.out.print(i+1 + ". " + Books[i]);
                            if(borrowed[i]==true){
                                borrow++;
                                System.out.print("  [Borrowed]\n");
                            } else{
                                System.out.print("  [Available]\n");
                            }
                        }

                        System.out.println("Borrowed books: " + borrow);
                        System.out.println("Available books: " + (count-borrow));
                    }
                    break;
                case 3:
                    System.out.println("Enter the desired book to be borrowed: ");
                    book = sc.nextLine();

                    for(int i=0;i<count; i++) {
                        if (book.equalsIgnoreCase(Books[i])) {
                            found = true;

                            if(borrowed[i] == true){
                                System.out.println("Already borrowed.");
                            } else {
                                borrowed[i] = true;
                                System.out.println("You have borrowed the book " + Books[i] + " successfully");
                            }
                            break;
                        } else {
                            continue;
                        }
                    }

                    if(found==false){
                        System.out.println("This book is not in the library. Please check the available books and try again:");
                    }

                    break;
                case 4:
                    System.out.println("Enter the name of the book that you want to return.");
                    book = sc.nextLine();

                    for(int i=0;i<count; i++) {
                        if (book.equalsIgnoreCase(Books[i])) {
                            found = true;
                            if (borrowed[i] == true) {
                                System.out.println("You have returned the book " + Books[i] + " successfully");
                                borrowed[i] = false;
                                break;
                            } else if(borrowed[i] == false){
                                System.out.println("This book was not borrowed.");
                            } else{
                                continue;
                            }
                        } else {
                            continue;
                        }
                    }

                    if(found == false) {
                        System.out.println("This book is not in the library. Please check the available books and try again:");
                    }
                    break;
                case 5:
                    System.out.println("Enter the name of the book that you want to search for.");
                    book = sc.nextLine();

                    for(int i=0;i<count; i++) {
                        if (book.equalsIgnoreCase(Books[i])) {
                            found = true;
                            System.out.println("Book found!!");

                            if(borrowed[i] == true){
                                System.out.println("Status: Borrowed");
                            } else{
                                System.out.println("Status: Available");
                            }
                            break;
                        } else{
                            continue;
                        }

                    }

                    if(found==false){
                        System.out.println("Book not found. ");
                    }

                    break;
                case 6:
                    System.out.println("Enter the name of the book to be deleted.");
                    book = sc.nextLine();

                    for(int i=0;i<count; i++) {
                        if (book.equalsIgnoreCase(Books[i])) {
                            found = true;

                            for(int j=i; j<count-1;j++) {
                                Books[j] = Books[j+1];
                                borrowed[j] = borrowed[j+1];
                            }

                            count--;
                            System.out.println("The book was successfully deleted.");
                            break;
                        } else{
                            continue;
                        }

                    }

                    if(found==false) {
                        System.out.println("Book not found.");
                    }
                    break;
                case 7:
                    System.out.println("Thank you for visiting the library. See you soon!!");
                    break;

                default:
                    System.out.println("Invali choice. Select numbers between 1 to 7.");
            }

        } while (choice!=7);
    }
}
