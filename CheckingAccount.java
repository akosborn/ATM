// This account type provides only checking services.
public class CheckingAccount extends Account
{
    private double checkingBalance;
    private String type = "checking";

    public CheckingAccount(String nameFirst, String nameLast, int pin)
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
        return checkingBalance;
    }

    public void deposit(int depositAmount, String depositLocation)
    {
        checkingBalance += depositAmount;
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

        checkingBalance -= withdrawAmount;
        System.out.println("Your new checking balance is $" + checkingBalance + ".\n");
    }
}
