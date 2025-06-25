package Static&Final.Level1;

public class BankAccount {

    private static String bankName = "RBI";
    private static int totalAccounts = 0;
    private final String accountNumber;
    private String accountHolderName;
    private double balance;

    public static void main(String[] args) {
        System.out.println("Welcome to " + BankAccount.bankName);

        BankAccount account1 = new BankAccount("AC1001", "ARIHANT JAIN", 257000.50);
        BankAccount account2 = new BankAccount("AC1002", "SURYANSH", 385000.00);
        BankAccount account3 = new BankAccount("AC1003", "ARJUN RAGHAV", 825000.00);

        if (account1 instanceof BankAccount) {
            System.out.println("\nChecking account1 type using instanceof:");
            account1.displayAccountDetails();
        }

        account1.deposit(2700.00);
        account2.withdraw(1050.50);
        account3.withdraw(37000.75);

        if (account1 instanceof BankAccount) {
            account1.displayAccountDetails();
        }
        if (account2 instanceof BankAccount) {
            account2.displayAccountDetails();
        }
        if (account3 instanceof BankAccount) {
            account3.displayAccountDetails();
        }

        BankAccount.getTotalAccounts();

        Object someObject = new String("Hello");
        if (someObject instanceof BankAccount) {
            System.out.println("\nsomeObject is an instance of BankAccount.");
        } else {
            System.out.println("\nsomeObject is NOT an instance of BankAccount.");
        }
    }

    public BankAccount(String accountNumber, String accountHolderName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
        totalAccounts++;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public static void getTotalAccounts() {
        System.out.println("\n--- Bank Statistics ---");
        System.out.println("Bank Name: " + bankName);
        System.out.println("Total Accounts Created: " + totalAccounts);
        System.out.println("-------------------------");
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited ₹" + String.format("%.2f", amount) + ". New balance: ₹" + String.format("%.2f", balance));
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew ₹" + String.format("%.2f", amount) + ". New balance: ₹" + String.format("%.2f", balance));
        } else if (amount > balance) {
            System.out.println("Insufficient funds. Current balance: ₹" + String.format("%.2f", balance));
        } else {
            System.out.println("Withdrawal amount must be positive.");
        }
    }

    public void displayAccountDetails() {
        System.out.println("\n--- Account Details ---");
        System.out.println("Bank Name: " + bankName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Balance: ₹" + String.format("%.2f", balance));
        System.out.println("-----------------------");
    }
}
