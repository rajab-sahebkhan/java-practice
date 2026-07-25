import java.util.Scanner;

public class EmployeeManagementSystem {
    public static void main(String[] args){

        String[] employeeName = new String[100];
        int[] employeeId = new int[100];
        String[] department = new String[100];
        double[] salary = new double[100];
        int[] experience = new int[100];

        int count = 0;
        int choice = 0;

        String name;
        int num;

        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to Employee Management System.");

        do{
            boolean found = false;
            boolean duplicate;

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

            choice = sc.nextInt();
            sc.nextLine();

            switch(choice){
                case 1:
                    if(count>=100){
                        System.out.println("Employee limit exceeded.");
                    } else {
                        System.out.println("Enter Employee ID");
                        employeeId[count] = sc.nextInt();
                        sc.nextLine();

                        if (count != 0) {
                            do {
                                duplicate = false;

                                for (int i = 0; i < count; i++) {
                                    if (employeeId[count] == employeeId[i]) {
                                        duplicate = true;
                                        System.out.println("Employee ID already taken. Please enter another.");
                                        employeeId[count] = sc.nextInt();
                                        sc.nextLine();
                                    }
                                }
                            } while (duplicate);
                        }

                        System.out.println("Enter employee name: ");
                        employeeName[count] = sc.nextLine();

                        System.out.println("Enter department name: ");
                        department[count] = sc.nextLine();

                        System.out.println("Enter salary: ");
                        salary[count] = sc.nextDouble();
                        sc.nextLine();

                        while(salary[count]<0){
                            System.out.println("Salary can't be negative. Enter valid salary.");
                            salary[count] = sc.nextDouble();
                            sc.nextLine();
                        }

                        System.out.println("Years of experience: ");
                        experience[count] = sc.nextInt();
                        sc.nextLine();

                        while(experience[count] < 0){
                            System.out.println("Experience can't be negative. Try again: ");
                            experience[count] = sc.nextInt();
                            sc.nextLine();
                        }

                        count++;
                    }
                    break;
                case 2:
                    if(count==0){
                        System.out.println("No employees present.");
                    } else{
                        System.out.println("Details of all employees: ");

                        for(int i=0;i<count;i++){
                            System.out.println(i+1 + ".\nEmployee ID: " + employeeId[i] + "\nEmployee name: " + employeeName[i] + "\nDepartment: " + department[i]);
                            System.out.printf("Salary: %.2f%n" , salary[i]);
                            System.out.println("Years of experience: " + experience[i]);
                        }
                    }

                    break;
                case 3:
                    if(count==0){
                        System.out.println("No employees present currently.");
                    } else{
                        System.out.println("Search by Employee ID: ");
                        num = sc.nextInt();
                        sc.nextLine();

                            for (int i = 0; i < count; i++) {
                                if (num == employeeId[i]) {
                                    found = true;
                                    System.out.println("Employee found!");
                                    System.out.println(i+1 + ".\nEmployee ID: " + employeeId[i] + "\nEmployee name: " + employeeName[i] + "\nDepartment: " + department[i]);
                                    System.out.printf("Salary: %.2f%n" , salary[i]);
                                    System.out.println("Years of experience: " + experience[i]);
                                    break;
                                }
                            }

                        if(!found){
                            System.out.println("Employee not found.");
                        }

                    }

                    break;
                case 4:
                    if(count==0){
                        System.out.println("No employees present.");
                    }else {
                        System.out.println("Enter employee ID: ");
                        num = sc.nextInt();
                        sc.nextLine();

                        for (int i = 0; i < count; i++) {
                            if (num == employeeId[i]) {
                                found = true;
                                System.out.println("Employee found!");
                                System.out.println(i + 1 + ".\nEmployee ID: " + employeeId[i] + "\nEmployee name: " + employeeName[i] + "\nDepartment: " + department[i]);
                                System.out.printf("Salary: %.2f%n", salary[i]);
                                System.out.println("Years of experience: " + experience[i]);

                                int choice2 = 0;

                                do{

                                    System.out.println("What do you want to update?");
                                    System.out.println("1. Name");
                                    System.out.println("2. Department");
                                    System.out.println("3. Salary");
                                    System.out.println("4. Experience");
                                    System.out.println("5. Exit");

                                    choice2 = sc.nextInt();
                                    sc.nextLine();

                                    switch(choice2){
                                        case 1:
                                            System.out.println("Enter employee name: ");
                                            employeeName[i] = sc.nextLine();

                                            System.out.println("Employee name updated.");
                                            break;
                                        case 2:
                                            System.out.println("Enter department name: ");
                                            department[i] = sc.nextLine();

                                            System.out.println("Department name updated.");
                                            break;
                                        case 3:
                                            System.out.println("Enter salary: ");
                                            salary[i] = sc.nextDouble();
                                            sc.nextLine();

                                            while(salary[i]<0){
                                                System.out.println("Salary can't be negative. Enter valid salary.");
                                                salary[i] = sc.nextDouble();
                                                sc.nextLine();
                                            }

                                            System.out.println("Salary updated.");
                                            break;
                                        case 4:
                                            System.out.println("Years of experience: ");
                                            experience[i] = sc.nextInt();
                                            sc.nextLine();

                                            while(experience[i] < 0){
                                                System.out.println("Experience can't be negative. Try again: ");
                                                experience[i] = sc.nextInt();
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

                                }while(choice2!=5);

                                break;
                            }
                        }

                        if (!found) {
                            System.out.println("Employee not found.");
                        }

                    }

                    break;
                case 5:

                    if(count==0){
                        System.out.println("No employees present currently.");
                    } else{
                        System.out.println("Search by Employee ID: ");
                        num = sc.nextInt();
                        sc.nextLine();

                        for (int i = 0; i < count; i++) {
                            if (num == employeeId[i]) {
                                found = true;

                                for(int j=i;j<count-1;j++){
                                    employeeId[j] = employeeId[j+1];
                                    employeeName[j] = employeeName[j+1];
                                    department[j] = department[j+1];
                                    salary[j] = salary[j+1];
                                    experience[j] = experience[j+1];
                                }

                                System.out.println("Employee info deleted.");
                                count--;
                                break;
                            }
                        }

                        if(!found){
                            System.out.println("Employee not found.");
                        }

                    }

                    break;
                case 6:

                    if(count==0){
                        System.out.println("No employees present.");
                    } else{
                        System.out.println("Enter department name: ");
                        name = sc.nextLine();

                        for(int i=0;i<count;i++){
                            if(name.equalsIgnoreCase(department[i])){
                                found = true;
                                int a=0;

                                for(int j=0;j<count;j++){
                                    if(name.equalsIgnoreCase(department[j])){
                                        a++;
                                        System.out.println(a+". " + employeeName[j]);

                                    }
                                }
                                break;
                            }
                        }

                        if(!found){
                            System.out.println("No employees are present in this department.");
                        }
                    }

                    break;
                case 7:

                    if(count==0){
                        System.out.println("No employees present.");
                    } else {


                        double HighestSalary = 0;
                        int HighestIndex = 0;

                        for (int i = 0; i < count; i++) {
                            if (salary[i] > HighestSalary) {
                                HighestSalary = salary[i];
                                HighestIndex = i;
                            }
                        }

                        System.out.println("Employee with the highest salary: ");
                        System.out.println("Name: " + employeeName[HighestIndex]);
                        System.out.printf("Salary: %.2f%n", salary[HighestIndex]);

                    }

                    break;
                case 8:

                    if(count==0){
                        System.out.println("No employees present.");
                    } else {

                        double TotalSalary = 0;

                        for (int i = 0; i < count; i++) {
                            TotalSalary += salary[i];
                        }

                        double avg = (double) TotalSalary / count;

                        System.out.printf("Average Salary: %.2f%n", avg);

                    }
                    break;
                case 9:
                    System.out.println("Thanks for visiting.");

                    break;
                default:
                    System.out.println("Invalid choice. Please select a number between 1 to 9");
            }


        }while(choice!=9);
    }
}
