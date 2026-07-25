import java.util.Scanner;

public class MovieDatabase {
    public static void main(String[] args){

        String[] movieName = new String[100];
        String[] genre = new String[100];
        int[] releaseYear = new int[100];
        double[] rating = new double[100];

        int count = 0;

        int choice = 0;

        String name;

        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to Movie database!!");

        do{

            boolean found = false;

            System.out.println("========= Movie Database =========\n");
            System.out.println("1. Add Movie");
            System.out.println("2. View All Movies");
            System.out.println("3. Search Movie");
            System.out.println("4. Update Movie");
            System.out.println("5. Delete Movie");
            System.out.println("6. Filter by Genre");
            System.out.println("7. Show Highest Rated Movie");
            System.out.println("8. Exit");

            choice = sc.nextInt();
            sc.nextLine();

            switch(choice){

                case 1:

                    if(count>=100){
                        System.out.println("Movie limit exceeded.");
                    } else {
                        System.out.println("Enter the name of the movie: ");
                        movieName[count] = sc.nextLine();

                        if (count != 0) {
                            boolean duplicate;
                            do {
                                duplicate = false;

                                for (int i = 0; i < count; i++) {
                                    if (movieName[count].equalsIgnoreCase(movieName[i])) {
                                        duplicate = true;
                                        System.out.println("Name already exists. Enter another name: ");
                                        movieName[count] = sc.nextLine();
                                        break;
                                    }
                                }
                            } while (duplicate);
                        }


                    System.out.println("Enter the genre: ");
                    genre[count] = sc.nextLine();

                    System.out.println("Enter the release year (1888 - 2090: ");
                    releaseYear[count] = sc.nextInt();
                    sc.nextLine();

                    while(releaseYear[count] < 1888 || releaseYear[count] > 2100) {
                        System.out.println("Please enter a year between 1888 and 2100.");
                        releaseYear[count] = sc.nextInt();
                        sc.nextLine();

                    }

                    System.out.println("Enter the rating (0.0 to 10.0): ");
                    rating[count] = sc.nextDouble();
                    sc.nextLine();

                    while(rating[count] <0.0 || rating[count] > 10.0){
                        System.out.println("Please enter rating between 0.0 and 10.0");
                        rating[count] = sc.nextDouble();
                        sc.nextLine();
                    }

                    count++;

                    }

                    break;

                case 2:
                    if(count==0) {
                        System.out.println("No movies available.");
                    } else{
                        for(int i=0;i<count;i++){
                            System.out.println(i+1 + ".\nMovie: " + movieName[i] + "\nGenre: " + genre[i] + "\nYear: " + releaseYear[i]);
                            System.out.printf("Rating: %.1f%n", rating[i]);
                        }
                    }

                    break;

                case 3:

                    if(count==0){
                        System.out.println("There are no movies available.");
                    } else {
                        System.out.println("Search by name: ");
                        name = sc.nextLine();

                        for (int i = 0; i < count; i++) {
                            if (name.equalsIgnoreCase(movieName[i])) {
                                found = true;
                                System.out.println("Movie found!!");
                                System.out.println(i + 1 + ".\nMovie: " + movieName[i] + "\nGenre: " + genre[i] + "\nYear: " + releaseYear[i]);
                                System.out.printf("Rating: %.1f%n", rating[i]);
                                break;
                            }
                        }

                        if (found != true) {
                            System.out.println("Movie not found.");
                        }
                    }


                    break;

                case 4:
                    if(count==0){
                        System.out.println("There are no movies available.");
                    }else {
                        System.out.println("Enter name of the movie: ");
                        name = sc.nextLine();

                        for (int i = 0; i < count; i++) {
                            if (name.equalsIgnoreCase(movieName[i])) {
                                found = true;
                                System.out.println("Movie found!!");
                                System.out.println(i + 1 + ".\nMovie: " + movieName[i] + "\nGenre: " + genre[i] + "\nYear: " + releaseYear[i]);
                                System.out.printf("Rating: %.1f%n", rating[i]);

                                System.out.println("What do you want to update: ");
                                System.out.println("1. Genre");
                                System.out.println("2. Release year");
                                System.out.println("3. Rating");
                                System.out.println("4. Exit update portal");

                                int choice2 = 0;

                                do{
                                    choice2 = sc.nextInt();
                                    sc.nextLine();

                                    switch(choice2){
                                        case 1:
                                            System.out.println("Enter new genre: ");
                                            genre[i] = sc.nextLine();
                                            System.out.println("\nGenre updated to " + genre[i]);
                                            break;
                                        case 2:
                                            System.out.println("Enter the updated release year (1888 - 2090: ");
                                            releaseYear[i] = sc.nextInt();
                                            sc.nextLine();

                                            while(releaseYear[i] < 1888 || releaseYear[i] > 2100) {
                                                System.out.println("Please enter a year between 1888 and 2100.");
                                                releaseYear[i] = sc.nextInt();
                                                sc.nextLine();
                                            }
                                            break;
                                        case 3:
                                            System.out.println("Enter new rating (0.0 to 10.0): ");
                                            rating[i] = sc.nextDouble();
                                            sc.nextLine();

                                            while(rating[i] <0.0 || rating[i] > 10.0){
                                                System.out.println("Please enter rating between 0.0 and 10.0");
                                                rating[i] = sc.nextDouble();
                                                sc.nextLine();
                                            }
                                            break;
                                        case 4:
                                            System.out.println("Exiting update portal.");
                                            break;
                                        default:
                                            System.out.println("Invalid choice.");
                                    }

                                } while(choice2!=4);

                                break;
                            }
                        }

                        if (found != true) {
                            System.out.println("Movie not found.");
                        }
                    }

                    break;

                case 5:
                    System.out.println("Enter name of the movie to delete it: ");
                    name = sc.nextLine();

                    for (int i = 0; i < count; i++) {
                        if (name.equalsIgnoreCase(movieName[i])) {
                            found = true;

                            for(int j=i;j<count-1;j++){
                                movieName[j] = movieName[j+1];
                                genre[j] = genre[j+1];
                                releaseYear[j] = releaseYear[j+1];
                                rating[j] = rating[j+1];
                            }

                            count--;

                            System.out.println("Movie successfully deleted!!");
                            break;
                        }
                    }

                    if (found != true) {
                        System.out.println("Movie not found.");
                    }


                    break;

                case 6:
                    String genre1;

                    System.out.println("Enter genre: ");
                    genre1 = sc.nextLine();

                    for(int i=0;i<count;i++){
                        if(genre1.equalsIgnoreCase(genre[i])){
                            found= true;

                            int a=0;

                            for(int j=0;j<count;j++){
                                if(genre1.equalsIgnoreCase(genre[j])){
                                    a++;
                                    System.out.println(a + ". " + movieName[j]);
                                }
                            }

                            if(a==0){
                                System.out.println("No movies in this genre found.");
                            }

                            break;

                        }
                    }

                    if(!found){
                        System.out.println("Genre not found.");
                    }

                    break;

                case 7:
                    if(count == 0){
                        System.out.println("No movies available");
                    }else {

                        double HighestRating = 0;
                        int HighestIndex = 0;

                        for(int i=0;i<count;i++){
                            if(HighestRating < rating[i]){
                                HighestIndex = i;
                                HighestRating = rating[i];
                            }
                        }

                        System.out.println("Highest rated movie: \n");
                        System.out.println("Movie: " + movieName[HighestIndex]);
                        System.out.printf("Rating: %.1f%n", rating[HighestIndex]);
                        System.out.println("Genre: " + genre[HighestIndex]);
                        System.out.println("Year: " + releaseYear[HighestIndex]);

                    }

                    break;

                case 8:

                    System.out.println("Thank you for visiting.");

                    break;

                default:

                    System.out.println("Invalid choice! Please select a number between 1 to 8.");

                break;
            }


        }while(choice!=8);
    }
}
