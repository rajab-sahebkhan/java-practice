import java.util.Scanner;

public class QuizScoreManager {
    public static void main(String[] args){

        String[] studentName = new String[100];
        int[] score = new int[100];
        String[] grade = new String[100];
        int count = 0;
        int temp = 0;
        String tempname;

        int choice=0;
        String name;


        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to Quiz score manager!!");

        do{

            boolean found = false;
            boolean duplicate;

            System.out.println("========= Quiz Score Manager =========\n");
            System.out.println("1. Add Student Score");
            System.out.println("2. View All Scores");
            System.out.println("3. Search Student");
            System.out.println("4. Update Score");
            System.out.println("5. Delete Student");
            System.out.println("6. Show Statistics");
            System.out.println("7. Exit");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice){
                case 1:

                    if(count>=100){
                        System.out.println("Student limit exceeded.");
                    } else {

                        System.out.println("Enter the name of the student: ");
                        studentName[count] = sc.nextLine();

                        if (count != 0) {
                            do {
                                tempname = studentName[count];

                                duplicate = false;

                                for (int i = 0; i < count; i++) {
                                    if (tempname.equalsIgnoreCase(studentName[i])) {
                                        duplicate = true;
                                        System.out.println("Student name is already present.\nEnter another name: ");
                                        studentName[count] = sc.nextLine();
                                        break;
                                    }
                                }

                            }while(duplicate);
                        }


                        System.out.println("Enter score of the student(1-100): ");
                        score[count] = sc.nextInt();
                        sc.nextLine();

                        while (score[count] < 0 || score[count] > 100) {
                            System.out.println("Please enter a score between 0 and 100: ");
                            score[count] = sc.nextInt();
                            sc.nextLine();
                        }

                        temp = score[count];

                        if (temp <= 39) {
                            grade[count] = "F";
                        } else if (temp >= 40 && temp <= 59) {
                            grade[count] = "E";
                        } else if (temp >= 60 && temp <= 69) {
                            grade[count] = "D";
                        } else if (temp >= 70 && temp <= 79) {
                            grade[count] = "C";
                        } else if (temp >= 80 && temp <= 89) {
                            grade[count] = "B";
                        } else {
                            grade[count] = "A";
                        }

                        count++;

                    }

                    break;

                case 2:

                    if(count==0){
                        System.out.println("No scores available.");
                    } else {

                        System.out.println("Scores of the students are as follows: ");

                        for (int i = 0; i < count; i++) {
                            System.out.println(i + 1 + ".\nName: " + studentName[i] + "\nScore: " + score[i] + " (" + grade[i] + ")");
                        }
                    }

                    break;

                case 3:

                    System.out.println("Search with name: ");
                    name = sc.nextLine();

                    for(int i=0;i<count;i++){
                        if(name.equalsIgnoreCase(studentName[i])){
                            found = true;
                            System.out.println("Student found!!");
                            System.out.println("Name: " + studentName[i]);
                            System.out.println("Score " + score[i]);
                            break;
                        }
                    }

                    if(found==false) {
                        System.out.println("Student not found.");
                    }

                    break;

                case 4:

                    System.out.println("Enter the name of the student: ");
                    name = sc.nextLine();

                    for(int i=0;i<count;i++){
                        if(name.equalsIgnoreCase(studentName[i])){
                            found = true;
                            System.out.println("Student found!!");
                            System.out.println("Current score: " + score[i]);

                            System.out.println("\nEnter the new score: ");
                            score[i] = sc.nextInt();
                            sc.nextLine();

                            while(score[i] < 0 || score[i] > 100){
                                System.out.println("Please enter a score between 0 and 100: ");
                                score[i] = sc.nextInt();
                                sc.nextLine();
                            }

                            temp = score[i];

                            if(temp<=39){
                                grade[i] = "F";
                            } else if(temp>=40 && temp<=59){
                                grade[i] = "E";
                            } else if(temp>=60 && temp<=69){
                                grade[i] = "D";
                            } else if(temp>=70 && temp<=79){
                                grade[i] = "C";
                            } else if(temp>=80 && temp<=89){
                                grade[i] = "B";
                            } else{
                                grade[i] = "A";
                            }

                            System.out.println("Score updated!!");
                            break;
                        }
                    }

                    if(found==false) {
                        System.out.println("Student not found.");
                    }

                    break;

                case 5:

                    System.out.println("Enter the name of student for deletion: ");
                    name = sc.nextLine();

                    for(int i=0;i<count;i++){
                        if(name.equalsIgnoreCase(studentName[i])){
                            found = true;

                            for(int j=i;j<count-1;j++){
                                studentName[j] = studentName[j+1];
                                score[j] = score[j+1];
                                grade[j] = grade[j+1];
                            }

                            count--;
                            System.out.println("Student info deleted successfully.");
                            break;
                        }
                    }

                    if(found==false) {
                        System.out.println("Student not found.");
                    }


                    break;

                case 6:

                    if(count==0){
                        System.out.println("No students in the directory.");
                    } else {
                        System.out.println("****Statistics****");

                        int max = 0;
                        int min = 100;
                        double avg;
                        int passed = 0;
                        int failed = 0;
                        int total = 0;

                        for (int i = 0; i < count; i++) {
                            if (score[i] > max) {
                                max = score[i];
                            }

                            if (score[i] < min) {
                                min = score[i];
                            }

                            if (score[i] > 39) {
                                passed++;
                            } else if (score[i] <= 39) {
                                failed++;
                            }

                            total += score[i];

                        }

                        avg = (double) total / count;

                        System.out.println("Highest score: " + max);
                        System.out.println("Lowest score: " + min);
                        System.out.printf("Average score: %.2f%n", avg);
                        System.out.println("Passed: " + passed);
                        System.out.println("Failed: " + failed);

                    }

                    break;

                case 7:

                    System.out.println("Thank you for visiting.");

                    break;

                default:
            }

        }while(choice!=7);
    }
}
