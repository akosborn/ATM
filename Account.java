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
    private String nameFirst, nameLast, nameFull;
    private Random random = new Random();
    final static double INITIAL_BALANCE = 0;
    private static List<Account> accounts = new ArrayList<>();

    public Account(String nameFirst, String nameLast, int pin)
    {
        setNameFirst(nameFirst);
        setNameLast(nameLast);
        setAccountNumber();
        setPin(pin);
        accounts.add(this);
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

    private void setNameFirst(String nameFirst)
    {
        this.nameFirst = nameFirst;
    }

    private void setNameLast(String nameLast)
    {
        this.nameLast = nameLast;
    }

    public String getNameFirst()
    {
        return nameFirst;
    }

    public String getNameLast()
    {
        return nameLast;
    }

    public int getAccountNumber()
    {
        return accountNumber;
    }

    private void setAccountNumber()
    {
        accountNumber = random.nextInt(5000) + 1;
    }

    private void setPin(int pin)
    {
        this.pin = pin;
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
                        System.out.println("");
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
