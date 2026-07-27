public class Employee {

    String name;
    int id;
    String department;
    double salary;
    int experience;

    public Employee(String name, int id, String department,
                    double salary, int experience) {
        this.name = name;
        this.id = id;
        this.department = department;
        this.salary = salary;
        this.experience = experience;
    }

    public void display() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Department: " + department);
        System.out.println("Salary: " + salary);
        System.out.println("Experience: " + experience);
    }

}


