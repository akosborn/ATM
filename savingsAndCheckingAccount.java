/**
 * Created by andre on 9/12/2016.
 */
public class savingsAndCheckingAccount extends Account
{
    @Override
    public void getBalance()
    {
        System.out.println("Your savings balance is $" + savingsBalance + ".");
        System.out.println("Your checking balance is $" + checkingBalance + ".\n");
    }

    @Override
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
