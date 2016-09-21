// This account type only provides savings services.
public class SavingsAccount extends Account
{
    private double savingsBalance;
    private String type = "savings";

    public SavingsAccount(String nameFirst, String nameLast, int pin)
    {
        super(nameFirst, nameLast, pin);
    }

    @Override
    public String getType()
    {
        return type;
    }

    @Override
    public double getBalance()
    {
        return savingsBalance;
    }

    @Override
    public void deposit(double depositAmount, String depositLocation)
    {
        savingsBalance += depositAmount;
    }

    @Override
    public void withdraw()
    {
        double withdrawAmount = 0;

        while (withdrawAmount != 20 && withdrawAmount != 40 && withdrawAmount != 60 && withdrawAmount != 80 && withdrawAmount != 100)
        {
            System.out.print("Choose an amount to withdraw.\n\t$20\n\t$40\n\t$60\n\t$80\n\t$100\n>$");
            withdrawAmount = input.nextInt();
            System.out.println("");
        }

        savingsBalance -= withdrawAmount;
        System.out.println("Your new savings balance is $" + savingsBalance + ".\n");
    }
}
