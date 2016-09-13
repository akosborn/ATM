import java.util.Scanner;

/**
 * Created by andre on 9/5/2016.
 */

public class ATM
{
    private Scanner input = new Scanner(System.in);
    private String entryString;
    private int entryInt;

    public void startATM()
    {
        CheckingAccount currentCheckingAcct;
        SavingsAccount currentSavingsAcct;
        savingsAndCheckingAccount currentSavingsAndCheckingAcct;

        while(true)
        {
            boolean validEntry = false;

            System.out.println("Welcome to the Bank of Andrew.");

            if ( (Account.accountNumbers).isEmpty() )
            {
                System.out.print("Enter \"n\" to create a new account. \n> ");
            } else {
                System.out.print("Enter \"n\" to create a new account or \"e\" to login with " +
                        "an existing account. \n> ");
            }

            while (!validEntry) {
                entryString = input.next();

                if ( entryString.equals("n") )
                {
                    System.out.print("Enter \"c\" for a checking account, \"s\" for a savings account, or \"b\" for both. \n> ");
                    entryString = input.next();
                    if (entryString.equals("c"))
                    {
                        currentCheckingAcct = new CheckingAccount();;
                        loginMenu(currentCheckingAcct);
                    } else if (entryString.equals("s")) {
                        currentSavingsAcct = new SavingsAccount();
                        loginMenu(currentSavingsAcct);
                    } else if (entryString.equals("b")) {
                        currentSavingsAndCheckingAcct = new savingsAndCheckingAccount();
                        loginMenu(currentSavingsAndCheckingAcct);
                    }
                    validEntry = true;
                } else if (entryString.equals("e")) {
                    loginMenu(Account.validateLogin());
                    validEntry = true;
                } else {
                    System.out.println("Invalid entry. Enter \"n\" to create a new account or \"e\" to login with with " +
                            "an existing account. \n> ");
                }
            }
        }
    }

    private void loginMenu(Account acct)
    {
        boolean loggedIn = true;

        System.out.println("\nWelcome, " + acct.getFullName() + "! ");

        do {
            System.out.print("What would you like to do?\n\t1) Get balance\n\t2) Deposit\n\t3) Withdraw\n\t" +
                    "4) Transfer\n\t5) Logout\n\t> ");
            entryInt = input.nextInt();
            System.out.println("");

            if (entryInt == 1) // user chooses "View balance"
            {
                acct.getBalance();
            } else if (entryInt == 2) // user chooses "Deposit"
            {
                acct.deposit();
            } else if (entryInt == 3) // user chooses "Withdraw"
            {
                System.out.println("Withdraw functionality not yet available.");
            } else if (entryInt == 4) // user chooses "Transfer"
            {
                System.out.println("Transfer functionality not yet available.");
            } else if (entryInt == 5) // user chooses "Logout"
            {
                loggedIn = false;
            }
        } while (loggedIn);

        System.out.println("You have been successfully logged out.\n");
    }
}
