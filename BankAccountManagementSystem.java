import java.util.Scanner;

public class BankAccountManagementSystem {
    public static void main(String[] args){

        String[] accountHolder = new String[100];
        int[] accountNumber = new int[100];
        double[] balance = new double[100];

        int acc1;
        int acc2;
        int amount =0;

        int count = 0;
        int choice = 0;

        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to the Bank Account Management System!!");

        do{
            boolean found=false;

            System.out.println("========= Bank Account Management =========");
            System.out.println("1. Create Account");
            System.out.println("2. View All Accounts");
            System.out.println("3. Deposit Money");
            System.out.println("4. Withdraw Money");
            System.out.println("5. Transfer Money");
            System.out.println("6. Search Account");
            System.out.println("7. Delete Account");
            System.out.println("8. Exit");

            choice = sc.nextInt();
            sc.nextLine();

            switch(choice){
                case 1:
                    if(count==100){
                        System.out.println("Number of accounts exceeded.");
                    } else {
                        System.out.println("Enter name: ");
                        accountHolder[count] = sc.nextLine();

                        System.out.println("Enter account number: ");
                        accountNumber[count] = sc.nextInt();

                        boolean duplicate;

                        do{
                            duplicate = false;

                            for(int i=0;i<count;i++){
                                if(accountNumber[count] == accountNumber[i]){
                                    duplicate = true;
                                    System.out.println("Account number already exists.");
                                    System.out.println("Enter another account number:");
                                    accountNumber[count] = sc.nextInt();
                                    break;
                                }
                            }

                        }while(duplicate);

                        System.out.println("Enter initial balance: ");
                        balance[count] = sc.nextInt();
                        sc.nextLine();

                        do {
                            if (balance[count] < 0) {
                                System.out.println("Balance can't be negative");
                                System.out.println("Please enter accepted initial balance.");
                                balance[count] = sc.nextInt();
                                sc.nextLine();
                            }

                        }while (balance[count]<0);

                        System.out.println("Account created.");
                        count++;
                    }

                    break;
                case 2:

                    if(count==0){
                        System.out.println("No accounts are present in the bank.");
                    } else {
                        System.out.println("The following accounts are present: " + count);
                        for (int i = 0; i < count; i++) {
                            System.out.println(i + 1);
                            System.out.println("Name: " + accountHolder[i]);
                            System.out.println("Account number: " + accountNumber[i]);
                            System.out.println("Balance: " + balance[i]);
                            System.out.println("\n");
                        }
                    }

                    break;
                case 3:
                    System.out.println("Enter the account number of the beneficiary: ");
                    acc1 = sc.nextInt();

                    for(int i=0;i<count;i++){
                        if(acc1==accountNumber[i]){
                            found = true;
                            System.out.println("Enter amount to be deposited: ");
                            amount = sc.nextInt();
                            if(amount>0) {
                                balance[i] += amount;

                                System.out.println("Deposit successful.");
                                System.out.println("New balance: " + balance[i]);
                            }else{
                                System.out.println("Amount should be positive and greater than 0.");
                            }
                        } else{
                            continue;
                        }
                    }

                    sc.nextLine();

                    if(found==false){
                        System.out.println("Account does not exist. Please try again with the correct account number.");
                    }

                    break;
                case 4:
                    System.out.println("Enter the account number of the withdrawer: ");
                    acc1 = sc.nextInt();

                    for(int i=0;i<count;i++){
                        if(acc1==accountNumber[i]) {
                            found = true;
                            System.out.println("Enter amount to be withdrawn: ");
                            amount = sc.nextInt();

                            if (amount > 0) {
                                if (amount > balance[i]) {
                                    System.out.println("Insufficient funds.");
                                } else {
                                    System.out.println("Withdrew successfully.");
                                    balance[i] -= amount;
                                    System.out.println("New balance: " + balance[i]);
                                }
                            } else {
                                System.out.println("Amount can't be negative or 0.");
                            }
                        } else{
                            continue;
                        }
                    }

                    sc.nextLine();

                    if(found==false){
                        System.out.println("Account does not exist. Please try again with the correct account number.");
                    }


                    break;
                case 5:
                    boolean found2 = false;
                    int a =0;

                    System.out.println("Enter the acc number of the sender: ");
                    acc1 = sc.nextInt();

                    System.out.println("Enter the account number of the receiver: ");
                    acc2 = sc.nextInt();

                    if(acc1==acc2){
                        System.out.println("The account number of sender and receiver can't be the same.");
                    } else {
                        for (int i = 0; i < count; i++) {
                            if (acc1 == accountNumber[i]) {
                                found = true;
                                a=i;
                                break;
                            } else {
                                continue;
                            }
                        }

                        if (found == true) {
                            for (int j = 0; j < count; j++) {
                                if(acc2==accountNumber[j]){
                                    found2=true;

                                        System.out.println("Enter the amount to be transferred: ");
                                        amount = sc.nextInt();
                                        if(amount>0) {
                                            if (balance[a] < amount) {
                                                System.out.println("Insufficient funds.");
                                                break;
                                            } else {
                                                balance[a] -= amount;
                                                balance[j] += amount;
                                                System.out.println("Transfer successful.");
                                                break;
                                            }
                                        } else{
                                            System.out.println("Amount can't be negative or 0.");
                                        }
                                }
                            }
                        }else{
                            System.out.println("Sender's account number does not exist.");
                        }
                    }

                    if(found2==false){
                        System.out.println("The account number of receiver does not exist.");
                    }

                    sc.nextLine();

                    break;
                case 6:
                    System.out.println("Search using account number: ");
                    acc1 = sc.nextInt();
                    sc.nextLine();

                    for(int i=0;i<count;i++){
                        if(acc1==accountNumber[i]){
                            System.out.println("Account found!!\n");
                            found=true;

                            System.out.println("Name: " + accountHolder[i]);
                            System.out.println("Balance: " + balance[i]);
                            System.out.println("Account number: " + accountNumber[i]);

                            break;
                        }
                        else{
                            continue;
                        }
                    }

                    if(found==false){
                        System.out.println("Account not found.");
                    }

                    break;
                case 7:
                    System.out.println("Enter the account number for deletion: ");
                    acc1 = sc.nextInt();
                    sc.nextLine();

                    for(int i=0;i<count;i++){
                        if(acc1==accountNumber[i]){
                            found=true;
                            for(int j=i;j<count-1;j++){
                                accountNumber[j]=accountNumber[j+1];
                                accountHolder[j]=accountHolder[j+1];
                                balance[j]=balance[j+1];
                            }
                            System.out.println("Account successfully deleted.");
                            count--;
                            break;
                        } else{
                            continue;
                        }
                    }

                    if(found==false){
                        System.out.println("Account not found.");
                    }

                    break;
                case 8:
                    System.out.println("Thank you for visiting.");
                    break;

                default:
                    System.out.println("Invalid choice. Please choose numbers between 1 to 8.");
            }

        }while(choice!=8);

    }
}
