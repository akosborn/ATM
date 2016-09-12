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
    protected String entryString, nameFirst, nameLast, fullName;
    private Random random = new Random();
    protected final static double initialBalance = 0.00;
    protected double checkingBalance = initialBalance, savingsBalance = initialBalance;

    public ArrayList<Account> accountNumbers = new ArrayList<Account>();

    public void createAccount() // sets acctNumber and pin and adds account to ArrayList<Account> accountNumbers
    {
        System.out.println("\nTo create your account, you must complete the following fields.");
        setName();
        setNumAndPin();
        accountNumbers.add(this);
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

    public boolean validateLogin() // uses do-while loops to verify submitted account and pin
    {
        boolean acctFound = false;
        boolean pinMatches = false;

        do  // requests account number until a valid account is entered
        {
            System.out.print("Account number: ");
            entryInt = input.nextInt();

            for (Account i : accountNumbers)
            {
                if (entryInt == i.accountNumber)
                {
                    acctFound = true;

                    do  // requests pin for above account until correct pin is entered
                    {
                        System.out.print("Password: ");
                        entryInt = input.nextInt();
                        if (entryInt == (i.pin))
                        {
                            pinMatches = true;
                        }else
                        {
                            System.out.println("Invalid password. Please try again.");
                        }
                    } while (!pinMatches);

                } else
                {
                    System.out.println("Invalid account. Please try again.");
                }
            }
        } while (!acctFound);

        return acctFound;
    }

    public boolean isAccountNumbersEmpty()
    {
        return accountNumbers.size() == 0;
    }

    public void getBalance()
    {
        System.out.println("Your savings balance is $" + savingsBalance + ".");
        System.out.println("Your checking balance is $" + checkingBalance + ".\n");
    }

    public void deposit()
    {
        double depositAmount = 0;

        System.out.print("Deposit to checking (c) or savings (s)?\n> ");
        entryString = input.next();
        while (!entryString.equals("c") && !entryString.equals("s"))
        {
            System.out.println("Invalid entry. Enter \"c\" to deposit to checking or \"s\" to deposit to savings");
            entryString = input.next();
        }

        if (entryString.equals("c")) // if user chooses to deposit to checking
        {
            while (depositAmount != 20 && depositAmount != 40 && depositAmount != 60 && depositAmount != 80 && depositAmount != 100)
            {
                System.out.print("Choose an amount to deposit.\n\t$20\n\t$40\n\t$60\n\t$80\n\t$100\n>$");
                depositAmount = input.nextInt();
            }

            checkingBalance += depositAmount;
            System.out.println("Your new checking balance is $" + checkingBalance + ".\n");

        } else if (entryString.equals("s")) // if user chooses to deposit to savings
        {
            while (depositAmount != 20 && depositAmount != 40 && depositAmount != 60 && depositAmount != 80 && depositAmount != 100)
            {
                System.out.print("Choose an amount to deposit.\n\t$20\n\t$40\n\t$60\n\t$80\n\t$100\n>$");
                depositAmount = input.nextInt();
            }

            savingsBalance += depositAmount;
            System.out.println("Your new savings balance is $" + savingsBalance + ".\n");
        }
    }
}
