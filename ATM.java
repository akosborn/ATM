import java.util.Scanner;

/**
 * Created by andre on 9/5/2016.
 */

public class ATM
{
    private Scanner input = new Scanner(System.in);
    private String entry;
    private Account currentAct = new Account();

    public void startATM()
    {
        boolean validEntry = false;

        do {

            System.out.print("Welcome to the Bank of Andrew. \nEnter \"n\" to create a new account or \"e\" to login with " +
                    "an existing account.\n> ");
            entry = input.next();

            if (entry.equals("n"))
            {
                currentAct.createAccount();
                currentAct.validateLogin();
                validEntry = true;
            } else if (entry.equals("e")) {
                currentAct.validateLogin();
                validEntry = true;
            } else
            {
                System.out.println("Invalid entry. Enter \"n\" to create a new account or \"e\" to login with with " +
                        "an existing account.");
            }
        } while(!validEntry);
    }
}
