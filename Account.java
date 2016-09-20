import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public abstract class Account implements Serializable
{
    private static final long serialVersionUID = -2491448891466958321L;
    static Scanner input = new Scanner(System.in);
    private int accountNumber, pin;
    private String nameFirst, fullName;
    private Random random = new Random();
    final static double INITIAL_BALANCE = 0;
    private static List<Account> accounts = new ArrayList<>();

    public Account() // sets acctNumber and pin and adds account to ArrayList<Account> accounts
    {
        System.out.println("\nTo create your account, you must complete the following fields.");
        setName();
        setNumAndPin();
        accounts.add(this);
        System.out.println(accounts);

        System.out.println("\nThank you, " + nameFirst + ". Your account (#" + this.accountNumber + ") has been created.\nYou " +
                "will now be required to sign in with your new login information.\n");
        validateLogin();
    }

    public static void saveAccounts()
    {
        try
        {
            FileOutputStream fs = new FileOutputStream("accounts.ser");
            ObjectOutputStream os = new ObjectOutputStream(fs);
            os.writeObject(accounts);
            os.close();
        } catch (IOException ex) { ex.printStackTrace(); }
    }

    public static void loadAccounts()
    {
        try
        {
            FileInputStream fs = new FileInputStream("accounts.ser");
            ObjectInputStream os = new ObjectInputStream(fs);

            Object one = os.readObject();
            accounts = (List<Account>) one;
            System.out.println(accounts + "\n");
        } catch (IOException | ClassNotFoundException ex) { ex.printStackTrace(); }
    }

    public static boolean isListEmpty()
    {
        return accounts.isEmpty();
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

    public static Account validateLogin() // uses do-while loops to verify submitted account and pin
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

            for (Account i : accounts)
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

    public void withdraw()
    {
        // withdraw money
    }

    @Override
    public String toString()
    {
        return "(ACCT: " + accountNumber + ", PIN: " + pin + ")";
    }
}
