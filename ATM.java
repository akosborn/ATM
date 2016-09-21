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
        Account currentAccount = null;

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
                currentAccount = new CheckingAccount(nameFirst, nameLast, pin);
            }
            else if (entryString.equals("2"))
            {
                currentAccount = new SavingsAccount(nameFirst, nameLast, pin);
            }
            else if (entryString.equals("3"))
            {
                currentAccount = new savingsAndCheckingAccount(nameFirst, nameLast, pin);
            }

            System.out.println("\nThank you, " + currentAccount.getNameFirst()  + ". Your account (#" +
                    currentAccount.getAccountNumber() + ") has been created.\n");
            loggedIn(currentAccount);

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
                currentAccount = Account.validateLogin(accountNumber, pin);
            } while (currentAccount == null);

            loggedIn(currentAccount);
            validEntry = true;
        }
        else
        {
            System.out.println("Invalid entry. Enter \"1\" to create a new account or \"2\" to login with with " +
                    "an existing account. \n> ");
        }
        return validEntry;
    }

    private void loggedIn(Account currentAccount)
    {
        boolean loggedIn = true;

        System.out.println("Welcome, " + currentAccount.getNameFirst() + " " + currentAccount.getNameLast() + "!");

        do // loops until user logs out
        {
            System.out.print("What would you like to do?\n\t1) Get balance\n\t2) Deposit\n\t3) Withdraw\n\t" +
                    "4) Transfer\n\t5) Logout\n\t> ");
            entryInt = input.nextInt();
            System.out.println("");

            if (entryInt == 1) // user chooses "View balance"
            {
                balanceATM(currentAccount);
            } else if (entryInt == 2) // user chooses "Deposit"
            {
                depositATM(currentAccount);
                balanceATM(currentAccount);
            } else if (entryInt == 3) // user chooses "Withdraw"
            {
                currentAccount.withdraw();
            } else if (entryInt == 4 && currentAccount instanceof savingsAndCheckingAccount) // savingsAndCheckingAccount user chooses "Transfer"
            {
                ( (savingsAndCheckingAccount) currentAccount ).transfer();
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

    private void balanceATM(Account currentAccount)
    {
        System.out.println("Your " + currentAccount.getType() + " balance is $" + currentAccount.getBalance() + ".\n");
    }

    private void depositATM(Account currentAccount)
    {
        String depositLocation = currentAccount.getType();

        if (currentAccount.getType().equals("savings and checking"))
        {
            System.out.print("Enter 1 to deposit to savings or 2 to deposit to checking: ");
            entryString = input.next();

            if (entryString.equals("1")) { depositLocation = "savings"; }
            else if (entryString.equals("2")) { depositLocation = "checking"; }
        }

        System.out.print("Choose an amount to deposit:\n\t$20\n\t$40\n\t$60\n\t$80\n\t$100\n>$");
        double depositAmount = input.nextInt();
        currentAccount.deposit(depositAmount, depositLocation);

        System.out.println("Deposit successful!\n");
    }
}
