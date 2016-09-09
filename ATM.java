import java.util.Scanner;

/**
 * Created by andre on 9/5/2016.
 */

public class ATM
{
    private Scanner input = new Scanner(System.in);
    private String entryString;
    private Account currentAcct = new Account();
    private CheckingAccount currentCheckingAcct = new CheckingAccount();
    private SavingsAccount currentSavingsAcct = new SavingsAccount();

    public void startATM()
    {
        boolean validEntry = false;

        System.out.println("Welcome to the Bank of Andrew.");

        if (currentAcct.isAccountNumbersEmpty())
        {
            System.out.print("Enter \"n\" to create a new account. \n> ");
        } else
        {
            System.out.print("Enter \"n\" to create a new account or \"e\" to login with " +
                    "an existing account. \n> ");
        }

        while(!validEntry)
        {
            entryString = input.next();

            if (entryString.equals("n"))
            {
                System.out.print("Enter \"c\" for a checking account, \"s\" for a savings account, or \"b\" for both. \n> ");
                entryString = input.next();
                if (entryString.equals("c"))
                {
                    currentCheckingAcct.createAccount();
                    currentCheckingAcct.validateLogin();
                    loginScreen(currentCheckingAcct);
                }
                if (entryString.equals("s"))
                {
                    currentSavingsAcct.createAccount();
                    currentSavingsAcct.validateLogin();
                    loginScreen(currentSavingsAcct);
                }
                if (entryString.equals("b"))
                {
                    currentAcct.createAccount();
                    currentAcct.validateLogin();
                    loginScreen(currentAcct);
                }
                validEntry = true;
            } else if (entryString.equals("e"))
            {
                currentAcct.validateLogin();
                validEntry = true;
            } else
            {
                System.out.println("Invalid entry. Enter \"n\" to create a new account or \"e\" to login with with " +
                        "an existing account. \n> ");
            }
        }
    }

    public void loginScreen(Account acct)
    {

    }
}
