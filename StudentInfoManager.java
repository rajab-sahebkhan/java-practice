import java.util.Scanner;

public class Studentinfomanager {
    public static void main(String[] args){

        int wahl = 0;
        String[] student = new String[100];
        int[] age = new int[100];
        int[] id = new int[100];
        int a = 0;
        Scanner sc = new Scanner(System.in);
        boolean found = false;

        do {
            System.out.println("Welcome to Student info manager!!");
            System.out.println("Enter your choice from 1-5");
            System.out.println("1. Add student");
            System.out.println("2. View all students");
            System.out.println("3. Search student");
            System.out.println("4. Delete student");
            System.out.println("5. Update student age");
            System.out.println("6. Exit");

            wahl = sc.nextInt();
            sc.nextLine();

            switch (wahl){
                case 1:
                    if(a<100) {
                        System.out.println("You can now enter student details.");
                        System.out.println("Enter name of the student: ");
                        student[a] = sc.nextLine();
                        System.out.println("Enter Age: ");
                        age[a] = sc.nextInt();
                        System.out.println("Enter student id: ");
                        id[a] = sc.nextInt();
                        sc.nextLine();

                        a++;
                    } else {
                        System.out.println("Student limit exceeded");
                    } break;

                case 2:
                    System.out.println("The current student database is as follows: ");

                    for(int i=0; i<a;i++) {
                        System.out.println("Student name: " + student[i]);
                        System.out.println("Age: " + age[i]);
                        System.out.println("Student ID: " + id[i]);
                    }
                    break;

                case 3:
                    found = false;
                    System.out.println("Enter the name of the student: ");
                    String name = sc.next();

                    for(int i=0; i<a; i++){
                        if(name.equalsIgnoreCase(student[i])){ // or name.equals(student[i])
                            System.out.println("Student found!!");
                            found = true;
                        }
                    }
                    if(found == false){
                        System.out.println("Student not found");
                    }
                    break;

                case 4:
                    System.out.println("Enter the name of the student to be deleted: ");
                    name = sc.nextLine();

                    for(int i=0; i<a; i++) {
                        if (name.equals(student[i])) {
                            for(int j=i; j<a;j++){
                                student[j]=student[j+1];
                                age[j]=age[j+1];
                                id[j] =id[j];
                            }
                            System.out.println("Student deleted.");
                            a--;
                            break;
                        }
                    }
                    break;

                case 5:
                    System.out.println("Enter the name of the student whose age needs to be updated: ");
                    name = sc.nextLine();

                    for(int i=0; i<a; i++){
                        if(name.equalsIgnoreCase(student[i])){ // or name.equals(student[i])
                            System.out.println("Student found!!");
                            System.out.println("Enter age: ");
                            age[i] = sc.nextInt();
                            System.out.println("Age of the student has been updated.");
                            break;
                        }
                    }
                    if(found == false){
                        System.out.println("Student not found");
                    }
                    break;

                case 6:
                    System.out.println("Thank you for visiting.");
            }
        } while(wahl !=6);
    }
}
