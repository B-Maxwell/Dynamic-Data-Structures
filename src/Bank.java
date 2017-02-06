import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by Ben Maxwell on 2/2/17.
 * This bank class for the banking project
 * which includes additional banking features
 */

public class Bank {

    String name;
    Scanner input = new Scanner(System.in);
    static Map<String, Double> bankAccts = new HashMap(); //Bank account info


    //Load account info
    public void loadAcct() {
        bankAccts.put("Sally", 500.00);
        bankAccts.put("Joe", 50.00);
        bankAccts.put("Frank", 100.00);
    }

    //Ask the user to enter their name
    public void enterName() throws Exception {
        boolean nameSuccess = false;
        do {
            try {
                System.out.println("Hello welcome to the World Bank!");
                System.out.println("-------------------------------");
                System.out.println("Please enter your name or type EXIT to end: ");
                name = input.nextLine();

                if (name.toUpperCase().equals("EXIT")) {
                    System.out.println("\nThank you. Please come again!");
                    System.exit(0);

                } else if (name.isEmpty()) {
                    throw new Exception("Please enter a name! Input cannot be blank\n");

                } else if (bankAccts.containsKey(name)) {

                    System.out.println("Welcome, " + name + " your current balance is: " + bankAccts.get(name));
                    nameSuccess = true;

                } else {
                    nameSuccess = true;
                    createAcct();

                }

            } catch (Exception eName) {
                System.err.println(eName.getLocalizedMessage());

            }
        } while (nameSuccess == false);
    }

    //Create account if user is non-existent
    public void createAcct() throws Exception {

        System.out.println("\nYour name was not found in our system. Would you like to create a new account? [Y/N]");
        String createAcct = input.next();

        if (createAcct.toUpperCase().equals("Y")) {
            System.out.println("New account creation:\n==================\n" + name + ", how much would you like to deposit?");
            Double initDeposit = input.nextDouble();
            bankAccts.put(name, initDeposit);
            System.out.println("\nDeposit accepted!\n");


        } else {

            System.out.println("\nThank you " + name + ". Please come again!");
        }
    }

    //Machine terminal prompt
    public void enterChoice() throws Exception {

        System.out.println("\nHow can we serve you today? (Please select an option 1 - 5) \n1. Check Balance " +
                "\n2. Withdraw Funds \n3. Deposit Funds \n4. Close your account \n5. Cancel & exit");
        int option = input.nextInt();
        int choice = 0; //tracking for the do-while loop


        do {

            try {


                switch (option) {

                    case 1: choice = 1; checkBalance(); break;

                    case 2: choice = 2; makeWithdrawal(); break;

                    case 3: choice = 3; makeDeposit(); break;

                    case 4: choice = 4; closeAccount(); break;

                    case 5: choice = 5; exitSession(); break;

                    default:
                        throw new Exception("\nInvalid option. Please select an option 1 - 5");

                }

                System.out.println("\nHow can we serve you today? (Please select an option 1 - 5) \n1. Check Balance " +
                        "\n2. Withdraw Funds \n3. Deposit Funds \n4. Close your account \n5. Cancel & exit");
                option = input.nextInt();

            } catch (Exception e) {
                System.err.println(e.getLocalizedMessage());
            }
        } while (choice != 5);

    }

    private void exitSession() throws Exception {
        System.out.println("\nThank you " + name + ". Please come again!");
        enterName();
    }

    private void closeAccount() throws Exception {

        System.out.println("\n" + name + ", are you sure that you would like to close your account? [Y/N]");
        String closeChoice = input.next();
        if (closeChoice.toUpperCase().equals("Y")) {
            bankAccts.remove(name);
            System.out.println("Your account is now closed. Thank you for banking with us!");
            enterName();

        } else {

            System.out.println("Returning to main menu...");
        }
    }

    private void makeDeposit() {
        System.out.println("\n" + name + ", how much would you like to deposit?");
        Double dFunds = input.nextDouble();
        bankAccts.put(name, bankAccts.get(name) + dFunds);
        System.out.println("\nYou new balance is $" + bankAccts.get(name));

    }

    private void makeWithdrawal() {

        System.out.println(name + ", how much would you like to withdraw?");
        Double wFunds = input.nextDouble();

        if (wFunds > bankAccts.get(name)) {
            System.out.println("\nSorry, you currently do not enough funds to withdraw that amount.");

        } else {
            bankAccts.put(name, bankAccts.get(name) - wFunds);
            System.out.println("\nYou new balance is $" + bankAccts.get(name));
        }
    }

    private void checkBalance() {
        System.out.println("\nThe current balance for your account is: " + bankAccts.get(name));
    }
}



















