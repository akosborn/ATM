// This account type only provides savings services.
public class SavingsAccount extends Account
{
    private double savingsBalance;

    @Override
    public void getBalance()
    {
        System.out.println("\nYour savings balance is $" + savingsBalance + ".\n");
    }

    @Override
    public void deposit()
    {
        double depositAmount = 0;

        while (depositAmount != 20 && depositAmount != 40 && depositAmount != 60 && depositAmount != 80 && depositAmount != 100)
        {
            System.out.print("Choose an amount to deposit.\n\t$20\n\t$40\n\t$60\n\t$80\n\t$100\n>$");
            depositAmount = input.nextInt();
            System.out.println("");
        }

        savingsBalance += depositAmount;
        System.out.println("Your new savings balance is $" + savingsBalance + ".\n");
    }
}
