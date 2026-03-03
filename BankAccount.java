import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalDateTime;


public class BankAccount{
    Scanner scanner = new Scanner(System.in);
    int balance = 0;
    LocalDate today = LocalDate.now();

    void displayMenu(){
        int option = 0;
        while (option < 1 || option > 4){
            System.out.println("*===========================*");
            System.out.println("Welcome to your bank account");
            System.out.println("Date: " + today);
            System.out.println("What would you like to do?");
            System.out.println("1. Check your balance");
            System.out.println("2. Deposit");
            System.out.println("3. WithDrawal");
            System.out.println("4. Exit");
            System.out.println("*===========================*");
            System.out.println("Enter your option: ");


            try {
                option = Integer.parseInt(scanner.next());
                switch (option) {
                    case 1:
                        checkBalance();
                        break;
                    
                    case 2:
                        deposit();
                        break;

                    case 3:
                        withDraw();
                        break;

                    case 4:
                        exit();
                        break;
                
                    default:
                        break;
                }


            } catch (Exception e) {
                System.out.println("Type (1-4)!");
            }
        }
    }


    void checkBalance(){
        int pick = 0;
        
        while (pick != 5){
            try{
                System.out.println("Your current balance: " + "$" + balance);
                System.out.println("Press 5 to go back to the menu");
                pick = Integer.parseInt(scanner.next());
                if (pick == 5){
                    displayMenu();
                }
            }
            catch (Exception _) {
                System.out.println("You have to press 5 if you wanna go back to the menu");
            }
        }
    }

    void deposit(){
        int choice = 0;

        while (choice < 1 || choice > 2){
            System.out.println("Would you like to deposit or back to the menu?");
            try {
                System.out.println("Type 1 or 2: ");
                choice = Integer.parseInt(scanner.next());
                if (choice == 1) store();
                else displayMenu();

            } catch (Exception _) {
                System.out.println("You have to type 1 or 2!");
            }
        }
    }

    void store(){
        int amount = 0;
        while (true){
            System.out.println("How much would you like to deposit or press 0 to go back to the menu?");
            try {
                amount = Integer.parseInt(scanner.next());
                if (amount > 0){
                    balance += amount;
                    System.out.println("Current balance: " + balance);
                    amount = 0;
                }

                else if (amount < 0){
                    System.out.println("Insert a positive number!");
                }

                else if (amount == 0){
                    displayMenu();
                }

            } catch (Exception _) {
                System.out.println("Please enter a number");
            }
        }
    }

    void withDraw(){
        int choice = 0;
        System.out.println("Do you want to withdraw or back to the menu?");
        while(choice != 1 || choice != 2){
            try {
                System.out.println("Type 1 or 2");
                choice = Integer.parseInt(scanner.next());
                if (choice == 1){
                    subtract();
                }
                else{
                    displayMenu();
                }
            } catch (Exception _) {
                System.out.println("You have to type 1 or 2!");
            }
        }
     }

     void subtract(){
        int sum = 0;
        System.out.println("Quantity or press 0 to go back to the menu?");
        if (balance > 0){
            while (true) {
                try{
                    sum = Integer.parseInt(scanner.next());
                    if (sum > 0 && balance > 0){
                        balance -= sum;
                        System.out.println("Current balance: " + balance);
                        sum = 0;
                        subtract();
                    }

                    else if (sum < 0){
                        System.out.println("Insert a positive number!");
                    }

                    else if (sum == 0){
                        displayMenu();
                    }

                }
                catch (Exception _){
                    System.out.println("Please enter a number");
                }
            }
        }

        else if (balance <= 0){
            System.out.println("Insufficient credit!");
            displayMenu();
        }

     }


    void exit(){
        System.out.println("Thanks for choosing us!");
    }

}