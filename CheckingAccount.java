// This account type provides only checking services.
public class CheckingAccount extends Account
{
    private double checkingBalance;

    @Override
    public void getBalance()
    {
        System.out.println("\nYour checking balance is $" + checkingBalance + ".\n");
    }

    public void deposit()
    {
        int depositAmount = 0;

        while (depositAmount != 20 && depositAmount != 40 && depositAmount != 60 && depositAmount != 80 && depositAmount != 100)
        {
            System.out.print("Choose an amount to deposit:\n\t$20\n\t$40\n\t$60\n\t$80\n\t$100\n>$");
            depositAmount = input.nextInt();
            System.out.println("");
        }

        checkingBalance += depositAmount;
        System.out.println("Your new checking balance is $" + checkingBalance + ".\n");
    }
}
