import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by andre on 9/5/2016.
 */

// This class serves as an account with both a checking and savings account.

public class Account implements Serializable
{
    private Scanner input = new Scanner(System.in);
    private int accountNumber, pin, entryInt;
    private String entryString, nameFirst, nameLast;
    private Random random = new Random();
    private BigDecimal checkingBalance, amount, displayCheckingBalance;

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

    public void setName() // associates first and last name with new user's account
    {
        System.out.print("First name:\n> ");
        nameFirst = input.next();

        System.out.print("Last name:\n> ");
        nameLast = input.next();
    }

    public void setNumAndPin()
    {
        accountNumber = random.nextInt(5000) + 1;
        System.out.println("Your account number is " + accountNumber);

        System.out.print("Password:\n> ");
        pin = input.nextInt();
    }

    public boolean validateLogin() // uses do-while loops to verify submitted account and pin
    {
        boolean acctFound = false;
        boolean pinCorrect = false;

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
                            pinCorrect = true;
                        }else
                        {
                            System.out.println("Invalid password. Please try again.");
                        }
                    } while (!pinCorrect);

                } else
                {
                    System.out.println("Invalid account. Please try again.");
                }
            }
        } while (!acctFound);

        System.out.println("Welcome, " + nameFirst + " " + nameLast + "!");
        return acctFound;
    }

    public boolean isAccountNumbersEmpty()
    {
        return accountNumbers.size() == 0;
    }

    public void setCheckingBalance()
    {
        amount = new BigDecimal("100.815");
        checkingBalance = amount;
        displayCheckingBalance = amount.setScale(2, RoundingMode.HALF_UP);
        System.out.println("Your checking balance is $" + displayCheckingBalance + ".");
    }

    public void withdrawFromChecking()
    {
        amount = amount.subtract(new BigDecimal("37.42"));
        displayCheckingBalance = amount.setScale(2, RoundingMode.HALF_UP);
        System.out.println("Withdrawal successful. Your new balance is " + displayCheckingBalance + ".");
    }
}
