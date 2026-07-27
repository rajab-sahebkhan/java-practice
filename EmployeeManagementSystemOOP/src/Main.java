import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Employee[] employees = new Employee[100];
        int count = 0;
        int choice;

        Scanner sc = new Scanner(System.in);

        EmployeeManager manager = new EmployeeManager();

        do {
            System.out.println("\n===== Employee Management System =====");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch(choice) {
                case 1:
                    manager.addEmployee();
                    break;
                case 2:
                    manager.viewEmployees();
                    break;
                case 3:
                    manager.updateEmployee();
                    break;
                case 4:
                    manager.deleteEmployee();
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice!");

            }
        }while(choice!=5);
    }
}
