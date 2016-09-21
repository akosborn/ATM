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
    public String type;

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

    private int getPin()
    {
        return pin;
    }

    public static Account validateLogin(int accountNumber, int pin) // uses do-while loops to verify submitted account and pin
    {
        Account currentAcct = null;

            for (Account i : accounts)
            {
                if (i.getAccountNumber() == accountNumber)
                {
                    if (i.getPin() == pin)
                    {
                        currentAcct = i;
                    }
                }
            }
        return currentAcct; // returns reference to account object user logged in to if valid; otherwise, returns null
    }

    public double getBalance()
    {
        // get account balance(s)
        double balance = 0;
        return balance;
    }

    public void deposit()
    {
        // deposit money
    }

    public void withdraw()
    {
        // withdraw money
    }

    public String getType()
    {
        // return account type
        return type;
    }

    @Override
    public String toString()
    {
        return "(ACCT: " + accountNumber + ", PIN: " + pin + ")";
    }
}
