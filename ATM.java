import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by andre on 9/5/2016.
 */

public class ATM
{
    private Scanner input = new Scanner(System.in);
    private String entry;
    public ArrayList<Account> accountNumbers = new ArrayList<Account>();

    public void startATM()
    {
        System.out.print("Welcome to the Bank of Andrew. \nEnter \"y\" to create a new account.\n> ");
        entry = input.next();

        if(entry.equals("y"))
        {
            createAccount();
        }
    }

    public void createAccount()
    {
        Account currentAct = new Account();
        currentAct.setNumAndPas();
        accountNumbers.add(currentAct);
    }
}
