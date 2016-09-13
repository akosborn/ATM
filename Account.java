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
    protected Scanner input = new Scanner(System.in);
    private int accountNumber, pin, entryInt;
    protected String entryString;
    private String nameFirst, nameLast, fullName;
    private Random random = new Random();
    protected final static double initialBalance = 0.00;
    protected double checkingBalance = initialBalance, savingsBalance = initialBalance;
    public static ArrayList<Account> accountNumbers = new ArrayList<>();

    public void createAccount() // sets acctNumber and pin and adds account to ArrayList<Account> accountNumbers
    {
        System.out.println("\nTo create your account, you must complete the following fields.");
        setName();
        setNumAndPin();
        accountNumbers.add(this);
        System.out.println(accountNumbers);
        System.out.println("\nThank you, " + nameFirst + ". Your account (#" + this.accountNumber + ") has been created.\nYou " +
                "will now be required to sign in with your new login information.\n");
    }

    private void setName() // associates first and last name with new user's account
    {
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

    public Account validateLogin() // uses do-while loops to verify submitted account and pin
    {
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
