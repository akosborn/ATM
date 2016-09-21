public class savingsAndCheckingAccount extends Account
{
    private double checkingBalance = INITIAL_BALANCE, savingsBalance = INITIAL_BALANCE;
    public String type = "savings and checking";

    public savingsAndCheckingAccount(String nameFirst, String nameLast, int pin)
    {
        super(nameFirst, nameLast, pin);
    }

    public String getType()
    {
        return type;
    }

    @Override
    public double getBalance()
    {
        return savingsBalance + checkingBalance;
    }

    @Override
    public void deposit()
    {
        String entryString;
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

    public void transfer()
    {
        String entryString;
        int entryInt;

        System.out.println("Transfer options:\n\t1) Checking to Savings\n\t2) Savings to Checking");
        entryString = input.next();

        System.out.println("Amount to transfer:\n\t$20\n\t$40\n\t$60\n\t$80\n\t$100");
        entryInt = input.nextInt();

        if ( entryString.equals("1") )
        {
            checkingBalance -= entryInt;
            savingsBalance += entryInt;
        } else if ( entryString.equals("2") )
        {
            savingsBalance -= entryInt;
            checkingBalance += entryInt;
        }

        System.out.println("Transfer complete.");
        getBalance();
    }

    @Override
    public void withdraw()
    {
        String entryString;
        double withdrawAmount = 0;

        System.out.print("Withdraw from checking (c) or savings (s)?\n> ");
        entryString = input.next();
        while (!entryString.equals("c") && !entryString.equals("s"))
        {
            System.out.println("Invalid entry. Enter \"c\" to withdraw from checking or \"s\" to withdraw from savings");
            entryString = input.next();
        }

        if (entryString.equals("c")) // if user chooses to deposit to checking
        {
            while (withdrawAmount != 20 && withdrawAmount != 40 && withdrawAmount != 60 && withdrawAmount != 80 && withdrawAmount != 100)
            {
                System.out.print("Choose an amount to withdraw.\n\t$20\n\t$40\n\t$60\n\t$80\n\t$100\n>$");
                withdrawAmount = input.nextInt();
            }

            checkingBalance -= withdrawAmount;
            System.out.println("Your new checking balance is $" + checkingBalance + ".\n");

        } else if (entryString.equals("s")) // if user chooses to deposit to savings
        {
            while (withdrawAmount != 20 && withdrawAmount != 40 && withdrawAmount != 60 && withdrawAmount != 80 && withdrawAmount != 100)
            {
                System.out.print("Choose an amount to withdraw.\n\t$20\n\t$40\n\t$60\n\t$80\n\t$100\n>$");
                withdrawAmount = input.nextInt();
            }

            savingsBalance -= withdrawAmount;
            System.out.println("Your new savings balance is $" + savingsBalance + ".\n");
        }
    }
}

