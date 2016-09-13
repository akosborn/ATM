import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by andre on 9/5/2016.
 */

// This class serves as an account with both a checking and savings account.

public class Account implements Serializable
{
    Scanner input = new Scanner(System.in);
    private int accountNumber, pin;
    private String nameFirst, fullName;
    private Random random = new Random();
    final static double INITIAL_BALANCE = 0;
    static ArrayList<Account> accountNumbers = new ArrayList<Account>();

    public Account() // sets acctNumber and pin and adds account to ArrayList<Account> accountNumbers
    {
        System.out.println("\nTo create your account, you must complete the following fields.");
        setName();
        setNumAndPin();
        accountNumbers.add(this);
        System.out.println(accountNumbers);

        System.out.println("\nThank you, " + nameFirst + ". Your account (#" + this.accountNumber + ") has been created.\nYou " +
                "will now be required to sign in with your new login information.\n");
        validateLogin();
    }

    private void setName() // associates first and last name with new user's account
    {
        String nameLast;

        System.out.print("First name: \n> ");
        nameFirst = input.next();

        System.out.print("Last name: \n> ");
        nameLast = input.next();

        fullName = nameFirst + " " + nameLast;
    }

    public String getFullName()
    {
        return fullName;
    }

    private void setNumAndPin()
    {
        accountNumber = random.nextInt(5000) + 1;
        System.out.println("Your account number is " + accountNumber);

        System.out.print("Password: \n> ");
        pin = input.nextInt();
    }

    static Account validateLogin() // uses do-while loops to verify submitted account and pin
    {
        Scanner input = new Scanner(System.in);
        int entryInt;
        boolean acctFound = false;
        boolean pinMatches = false;
        Account returnAccount = null;

        do  // requests account number until a valid account is entered
        {
            System.out.print("Account number: ");
            entryInt = input.nextInt();

            for (Account i : accountNumbers)
            {
                if (entryInt == i.accountNumber)
                {
                    returnAccount = i;
                    acctFound = true;

                    do  // requests pin for above account until correct pin is entered
                    {
                        System.out.print("Password: ");
                        entryInt = input.nextInt();
                        if (entryInt == (i.pin))
                        {
                            pinMatches = true;
                        }
                    } while (!pinMatches);
                }
            }
        } while (!acctFound);

        return returnAccount; // returns reference to account object user logged in to
    }

    public void getBalance()
    {
        // get account balance(s)
    }

    public void deposit()
    {
        // deposit money
    }
}
