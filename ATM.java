import java.util.Scanner;

public class ATM
{
    private Scanner input = new Scanner(System.in);
    private String entryString;
    private int entryInt;

    public void initATM()
    {
        loadAccounts();
        runATM(); // endless menu loop
    }

    private void loadAccounts()
    {
        System.out.print("Load accounts.ser? (y or n)\n> ");
        entryString = input.next();
        System.out.println("");

        if (entryString.equals("y"))
        {
            Account.loadAccounts();
        }
    }

    private void runATM()
    {
        boolean validEntry = false;

        while (true)
        {
            System.out.println("Welcome to the Bank of Andrew.");

            if (Account.isListEmpty())
            {
                System.out.print("Enter \"1\" to create a new account. \n> ");
            }
            else
            {
                System.out.print("Enter \"1\" to create a new account or \"2\" to login with " +
                        "an existing account. \n> ");
            }

            do
            {
                validEntry = createOrLogin(validEntry);
            } while (!validEntry);
        }
    }

    private boolean createOrLogin(boolean validEntry)
    {
        entryString = input.next();
        String nameFirst, nameLast;
        int accountNumber, pin;
        Account currentAcct = null;

        if ( entryString.equals("1") )
        {
            System.out.print("Enter \"1\" for a checking account, \"2\" for a savings account, or \"3\" for both. \n> ");
            entryString = input.next();

            System.out.print("First name: ");
            nameFirst = input.next();
            System.out.print("Last name: ");
            nameLast = input.next();
            System.out.print("Set PIN: ");
            pin = input.nextInt();

            if (entryString.equals("1"))
            {
                currentAcct = new CheckingAccount(nameFirst, nameLast, pin);
            }
            else if (entryString.equals("2"))
            {
                currentAcct = new SavingsAccount(nameFirst, nameLast, pin);
            }
            else if (entryString.equals("3"))
            {
                currentAcct = new savingsAndCheckingAccount(nameFirst, nameLast, pin);
            }

            System.out.println("\nThank you, " + currentAcct.getNameFirst()  + ". Your account (#" + currentAcct.getAccountNumber() + ") has been created.\nYou " +
                    "will now be required to sign in with your new login information.\n");

            // validateLogin();
            loggedIn(currentAcct);

            validEntry = true;
        }
        else if (entryString.equals("2"))
        {
            do
            {
                System.out.print("Account #: ");
                accountNumber = input.nextInt();
                System.out.print("PIN: ");
                pin = input.nextInt();
                System.out.println("");
                currentAcct = Account.validateLogin(accountNumber, pin);
            } while (currentAcct == null);

            loggedIn(currentAcct);
            validEntry = true;
        }
        else
        {
            System.out.println("Invalid entry. Enter \"n\" to create a new account or \"e\" to login with with " +
                    "an existing account. \n> ");
        }
        return validEntry;
    }

    private void loggedIn(Account acct)
    {
        boolean loggedIn = true;

        System.out.println("Welcome, " + acct.getNameFirst() + " " + acct.getNameLast() + "!");

        do // loops until user logs out
        {
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
                acct.withdraw();
            } else if (entryInt == 4 && acct instanceof savingsAndCheckingAccount) // savingsAndCheckingAccount user chooses "Transfer"
            {
                ( (savingsAndCheckingAccount) acct ).transfer();
            } else if (entryInt == 5) // user chooses "Logout"
            {
                Account.saveAccounts();
                loggedIn = false;
            } else
            {
                System.out.println("Invalid entry.\n");
            }
        } while (loggedIn);

        System.out.println("You have been successfully logged out.\n");
    }
}
