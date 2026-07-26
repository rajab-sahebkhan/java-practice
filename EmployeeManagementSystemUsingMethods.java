import java.util.Scanner;

public class EmployeeManagementSystemUsingMethods {

    public static int addEmployee(String[] employeename, int[] id,String[] department, double[] salary, int[] experience, int count){

        Scanner sc = new Scanner(System.in);

        if(count>=100){
            System.out.println("Employee limit reached");
        } else{

            System.out.println("Enter Employee ID");
            id[count] = sc.nextInt();
            sc.nextLine();

            boolean found;

                if (findEmployee(id[count], id, count) != -1) {
                    do {
                        found = false;

                        System.out.println("Employee id already exists.\nEnter another id: ");
                        id[count] = sc.nextInt();
                        sc.nextLine();

                        if (findEmployee(id[count], id, count) != -1) {
                            found = true;
                        }

                    } while (found);
                }

                System.out.println("Enter employee name: ");
                employeename[count] = sc.nextLine();

                System.out.println("Enter department name: ");
                department[count] = sc.nextLine();

                System.out.println("Enter salary: ");
                salary[count] = sc.nextDouble();
                sc.nextLine();

                while (salary[count] < 0) {
                    System.out.println("Salary can't be negative. Enter valid salary.");
                    salary[count] = sc.nextDouble();
                    sc.nextLine();
                }

                System.out.println("Years of experience: ");
                experience[count] = sc.nextInt();
                sc.nextLine();

                while (experience[count] < 0) {
                    System.out.println("Experience can't be negative. Try again: ");
                    experience[count] = sc.nextInt();
                    sc.nextLine();
                }

                count++;

        }

        return count;
    }

    public static void viewEmployees(String[] employeename, int[] id,String[] department, double[] salary, int[] experience, int count){

        if(count==0){
            System.out.println("No employees present.");
        } else {
                for (int i = 0; i < count; i++) {
                    System.out.println(i + 1 + ".\nName: " + employeename[i] + "\nID: " + id[i] + "\nDepartment: " + department[i]);
                    System.out.printf("Salary: %.2f%n", salary[i]);
                    System.out.println("Experience: " + experience[i]);
                }
            }
        }


    public static void searchEmployee(String[] employeename, int[] id,String[] department, double[] salary, int[] experience,  int count){

        int num=0;
        Scanner sc = new Scanner(System.in);

        if(count==0){
            System.out.println("No employees present.");
        } else {

            System.out.println("Enter Employee ID");
            num = sc.nextInt();
            sc.nextLine();

            int index = findEmployee(num, id, count);

            if (index != -1) {

                System.out.println("Employee found!!");

                System.out.println("\nName: " + employeename[index] + "\nID: " + id[index] + "\nDepartment: " + department[index]);
                System.out.printf("Salary: %.2f%n", salary[index]);
                System.out.println("Experience: " + experience[index]);

            } else{

                System.out.println("Employee does not exist.");
            }

        }

    }

    public static void updateEmployee(String[] employeename, int[] id,String[] department, double[] salary, int[] experience,  int count){

        Scanner sc = new Scanner(System.in);
        int num=0;

        if(count==0){
            System.out.println("No employees present.");
        } else {

            System.out.println("Enter Employee ID");
            num = sc.nextInt();
            sc.nextLine();

            int index = findEmployee(num, id, count);

            if ( index != -1) {

                System.out.println("Employee found!!");

                int choice = 0;

                do{

                    System.out.println("What do you want to update?");
                    System.out.println("1. Name");
                    System.out.println("2. Department");
                    System.out.println("3. Salary");
                    System.out.println("4. Experience");
                    System.out.println("5. Exit");

                    choice = sc.nextInt();
                    sc.nextLine();

                    switch(choice){
                        case 1:
                            System.out.println("Enter employee name: ");
                            employeename[index] = sc.nextLine();

                            System.out.println("Employee name updated.");
                            break;
                        case 2:
                            System.out.println("Enter department name: ");
                            department[index] = sc.nextLine();

                            System.out.println("Department name updated.");
                            break;
                        case 3:
                            System.out.println("Enter salary: ");
                            salary[index] = sc.nextDouble();
                            sc.nextLine();

                            while(salary[index]<0){
                                System.out.println("Salary can't be negative. Enter valid salary.");
                                salary[index] = sc.nextDouble();
                                sc.nextLine();
                            }

                            System.out.println("Salary updated.");
                            break;
                        case 4:
                            System.out.println("Years of experience: ");
                            experience[index] = sc.nextInt();
                            sc.nextLine();

                            while(experience[index] < 0){
                                System.out.println("Experience can't be negative. Try again: ");
                                experience[index] = sc.nextInt();
                                sc.nextLine();
                            }
                            System.out.println("Work experience updated.");
                            break;
                        case 5:
                            System.out.println("Exiting update portal.");
                            break;
                        default:
                            System.out.println("Invalid choice. Please select numbers between 1 to 5.");

                    }

                }while(choice!=5);

            }
        }

    }

    public static int deleteEmployee(String[] employeename, int[] id,String[] department, double[] salary, int[] experience,  int count){

        int num=0;
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Employee ID");
        num = sc.nextInt();
        sc.nextLine();

        int index = findEmployee(num, id, count);

        if (index != -1) {

            for(int i=index;i<count-1;i++){
                id[i] = id[i+1];
                employeename[i] = employeename[i+1];
                department[i] = department[i+1];
                salary[i] = salary[i+1];
                experience[i] = experience[i+1];
            }

            count--;

        } else{
            System.out.println("Employee does not exist.");
        }


        return count;
    }

    public static void filterDepartment(String[] employeename, int[] id,String[] department, double[] salary, int[] experience,  int count){

        Scanner sc = new Scanner(System.in);
        String name;

        if(count==0){
            System.out.println("No employees present.");
        } else {

            boolean found = false;

            System.out.println("Enter the name of the department: ");
            name = sc.nextLine();

            for (int i = 0; i < count; i++) {
                if (name.equalsIgnoreCase(department[i])) {

                    found=true;
                    int a=0;

                    System.out.println("Employees in this department: ");

                    for (int j = 0; j < count; j++){

                        if(name.equalsIgnoreCase(department[j])) {
                            a++;

                            System.out.println(a + ".\nName: " + employeename[j] + "\nID: " + id[j] + "\nDepartment: " + department[j]);
                            System.out.printf("Salary: %.2f%n", salary[j]);
                            System.out.println("Experience: " + experience[j]);

                        }
                    }

                    if(a==0){
                        System.out.println("There are no employees in this department.");
                    } else{
                        System.out.println("Total employees: " + a);
                    }

                    break;

                }
            }
            if(!found){
                System.out.println("Department not found.");
            }
        }

    }

    public static void highestSalary(String[] employeename, int[] id,String[] department, double[] salary, int[] experience,  int count){

        if(count==0){
            System.out.println("No employees present.");
        } else {
            double high = 0;
            int a = 0;

            for (int i = 0; i < count; i++) {
                if (high < salary[i]) {
                    high = salary[i];
                    a = i;
                }
            }

            System.out.printf("The highest salary is %.2f%n", high);
            System.out.println("\nEmployee details: ");

            System.out.println("Name: " + employeename[a] + "\nID: " + id[a] + "\nDepartment: " + department[a]);
            System.out.printf("Salary: %.2f%n", salary[a]);
            System.out.println("Experience: " + experience[a]);

        }
    }

    public static void averageSalary(double[] salary,  int count){

        if(count==0){
            System.out.println("No employees present.");
        } else {
            double totalsalary = 0;

            for (int i = 0; i < count; i++) {
                totalsalary += salary[i];
            }

            double avg = totalsalary / count;

            System.out.printf("The average salary is %.2f%n" , avg);

        }
    }

    public static int findEmployee(int num, int[] id, int count) {
        for (int i = 0; i < count; i++) {
            if (num == id[i]) {
                return i;
            }
        }
        return -1;
    }

    public static void menu(){

        System.out.println("========= Employee Management =========\n");
        System.out.println("1. Add Employee");
        System.out.println("2. View Employees");
        System.out.println("3. Search Employee");
        System.out.println("4. Update Employee");
        System.out.println("5. Delete Employee");
        System.out.println("6. Filter by Department");
        System.out.println("7. Show Highest Salary");
        System.out.println("8. Show Average Salary");
        System.out.println("9. Exit");

    }

    public static void main(String[] args){


        int count=0;
        int choice=0;
        Scanner sc = new Scanner(System.in);

        String[] employeeName = new String[100];
        int[] employeeId = new int[100];
        String[] department = new String[100];
        double[] salary = new double[100];
        int[] experience = new int[100];

        do{

            menu();
            choice = sc.nextInt();
            sc.nextLine();

            switch(choice){
                case 1:

                    count = addEmployee(employeeName, employeeId,department, salary, experience, count);

                    break;
                case 2:

                    viewEmployees(employeeName, employeeId,department, salary, experience, count);

                    break;
                case 3:

                    searchEmployee(employeeName, employeeId,department, salary, experience, count);

                    break;
                case 4:

                    updateEmployee(employeeName, employeeId,department, salary, experience, count);

                    break;
                case 5:

                    count = deleteEmployee(employeeName, employeeId,department, salary, experience, count);

                    break;
                case 6:

                    filterDepartment(employeeName, employeeId,department, salary, experience, count);

                    break;
                case 7:

                    highestSalary(employeeName, employeeId,department, salary, experience, count);

                    break;
                case 8:

                    averageSalary(salary, count);

                    break;
                case 9:

                    System.out.println("Exiting!!!");

                    break;
                default:
                    System.out.println("Invalid choice. Please select a number between 1 to 9.");
            }


        }while(choice!=9);


    }
}
