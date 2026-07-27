import java.util.Scanner;

public class EmployeeManager {

    Employee[] employees = new Employee[100];
    int count = 0;

    Scanner sc = new Scanner(System.in);

    private int findEmployee(int id){

        for(int i=0;i<count;i++){

            if(id==employees[i].id){
            return i;
            }

        }

        return -1;
    }

    public void addEmployee(){

        if(count < employees.length) {

            System.out.println("Enter employee ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.println("Enter name: ");
            String name = sc.nextLine();

            System.out.println("Enter department: ");
            String department = sc.nextLine();

            System.out.println("Enter salary: ");
            double salary = sc.nextDouble();
            sc.nextLine();

            System.out.println("Enter experience in years: ");
            int experience = sc.nextInt();
            sc.nextLine();

            employees[count] = new Employee(name, id, department, salary, experience);
            count++;

            System.out.println("Employee added successfully!");
        } else{
            System.out.println("Employee list is full.");
        }
    }

    public void viewEmployees(){
        if(count==0){
            System.out.println("No employees found.");
        } else {
            for (int i = 0; i < count; i++) {
                employees[i].display();
            }
        }

    }

    public void searchEmployee(){


        if(count==0){
            System.out.println("No employees found.");
        } else{

            System.out.println("Enter employee id:");
            int id = sc.nextInt();
            sc.nextLine();

            int index = findEmployee(id);

            if(index!=-1){
                System.out.println("Employee found!");
                employees[index].display();
            } else {
                System.out.println("Employee not found!!");
            }

        }

    }

    public void updateEmployee(){

        System.out.println("Enter employee id: ");
        int id = sc.nextInt();
        sc.nextLine();

        int index = findEmployee(id);

        if(index!=-1){
            int choice = 0;
            do {
                System.out.println("What do you want to update: ");
                System.out.println("1. Name");
                System.out.println("2. Department");
                System.out.println("3. Salary");
                System.out.println("4. Experience");
                System.out.println("5. Exit");

                choice = sc.nextInt();
                sc.nextLine();

                switch(choice){
                    case 1:
                        System.out.println("Enter name: ");
                        employees[index].name = sc.nextLine();
                        break;
                    case 2:
                        System.out.println("Enter department: ");
                        employees[index].department = sc.nextLine();
                        break;
                    case 3:
                        System.out.println("Enter salary: ");
                        employees[index].salary = sc.nextDouble();
                        sc.nextLine();
                        break;
                    case 4:
                        System.out.println("Enter experience in years: ");
                        employees[index].experience = sc.nextInt();
                        sc.nextLine();
                        break;
                    case 5:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice!");
                }

                if(choice>0 && choice<5){
                    System.out.println("Employee details updated successfully!");
                }

            } while(choice!=5);
        } else{
            System.out.println("Employee not found.");
        }

    }

    public void deleteEmployee(){

        System.out.println("Enter employee id: ");
        int id = sc.nextInt();

        int index = findEmployee(id);

        if(index!=-1){
            for(int i=index;i<count-1;i++){
                employees[i] = employees[i + 1];
            }

            employees[count-1] = null;
            count--;

            System.out.println("Employee deleted!");
        } else{
            System.out.println("Employee not found!");
        }

    }

}
