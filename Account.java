import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by andre on 9/5/2016.
 */

public class Account
{
    Scanner input = new Scanner(System.in);
    private String password;
    public int accountNumber;

    public void setNumAndPas()
    {
        System.out.print("Enter desired account number: \n> ");
        accountNumber = input.nextInt();

        System.out.print("Enter desired password: \n> ");
        password = input.next();
    }
}
