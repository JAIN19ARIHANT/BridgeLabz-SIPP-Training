public class BankSystem {
    public static void main(String[] args) {
        SavingsAccount sa = new SavingsAccount("SA12345", 50000.0, 4.5);
        CheckingAccount ca = new CheckingAccount("CA67890", 30000.0, 10000.0);
        FixedDepositAccount fda = new FixedDepositAccount("FD11223", 100000.0, 12);

        sa.displayAccountType();
        ca.displayAccountType();
        fda.displayAccountType();
    }
}

class BankAccount {
    String accountNumber;
    double balance;

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
}

class SavingsAccount extends BankAccount {
    double interestRate;

    public SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    public void displayAccountType() {
        System.out.println("Savings Account");
        System.out.println("Account No: " + accountNumber + ", Balance: ₹" + balance + ", Interest Rate: " + interestRate + "%\n");
    }
}

class CheckingAccount extends BankAccount {
    double withdrawalLimit;

    public CheckingAccount(String accountNumber, double balance, double withdrawalLimit) {
        super(accountNumber, balance);
        this.withdrawalLimit = withdrawalLimit;
    }

    public void displayAccountType() {
        System.out.println("Checking Account");
        System.out.println("Account No: " + accountNumber + ", Balance: ₹" + balance + ", Withdrawal Limit: ₹" + withdrawalLimit + "\n");
    }
}

class FixedDepositAccount extends BankAccount {
    int tenureMonths;

    public FixedDepositAccount(String accountNumber, double balance, int tenureMonths) {
        super(accountNumber, balance);
        this.tenureMonths = tenureMonths;
    }

    public void displayAccountType() {
        System.out.println("Fixed Deposit Account");
        System.out.println("Account No: " + accountNumber + ", Balance: ₹" + balance + ", Tenure: " + tenureMonths + " months\n");
    }
}