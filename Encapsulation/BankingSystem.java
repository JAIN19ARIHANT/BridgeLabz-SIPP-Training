import java.util.*;

interface Loanable {
    boolean applyForLoan(double amount);
    double calculateLoanEligibility();
}

abstract class BankAccount implements Loanable {
    private final String accountNumber;
    private final String holderName;
    private double balance;
    private final String panCard;

    public BankAccount(String accountNumber, String holderName, double balance, String panCard) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
        this.panCard = panCard;
    }

    public void deposit(double amount) {
        if (amount > 0) balance += amount;
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) balance -= amount;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    protected String getMaskedPAN() {
        return "XXXXXX" + panCard.substring(panCard.length() - 4);
    }

    public abstract double calculateInterest();
}

class SavingsAccount extends BankAccount {
    private static final double INTEREST_RATE = 0.05;

    public SavingsAccount(String accountNumber, String holderName, double balance, String panCard) {
        super(accountNumber, holderName, balance, panCard);
    }

    public double calculateInterest() {
        return getBalance() * INTEREST_RATE;
    }

    public boolean applyForLoan(double amount) {
        return amount <= calculateLoanEligibility();
    }

    public double calculateLoanEligibility() {
        return getBalance() * 2;
    }
}

class CurrentAccount extends BankAccount {
    private static final double INTEREST_RATE = 0.01;

    public CurrentAccount(String accountNumber, String holderName, double balance, String panCard) {
        super(accountNumber, holderName, balance, panCard);
    }

    public double calculateInterest() {
        return getBalance() * INTEREST_RATE;
    }

    public boolean applyForLoan(double amount) {
        return amount <= calculateLoanEligibility();
    }

    public double calculateLoanEligibility() {
        return getBalance();
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        List<BankAccount> accounts = new ArrayList<>();
        accounts.add(new SavingsAccount("SBI007", "Arihant Jain", 25000, "CLKPJ1907k"));
        accounts.add(new CurrentAccount("HDFC202", "Suryansh", 80000, "PQRSX4321H"));
        accounts.add(new CurrentAccount("HSBC101", "Arjun Raghav", 10000, "ASDFZ7777X"));

        for (BankAccount acc : accounts) {
            System.out.println("\nAccount: " + acc.getAccountNumber() + " | Holder: " + acc.getHolderName());
            System.out.println("Balance: ₹" + acc.getBalance());
            System.out.println("Interest Earned: ₹" + acc.calculateInterest());
            System.out.println("Loan Eligibility: ₹" + acc.calculateLoanEligibility());
            System.out.println("Loan Approval for ₹50000: " + (acc.applyForLoan(50000) ? "Approved for Pan " + acc.getMaskedPAN() : "Denied for Pan " + acc.getMaskedPAN()));
            System.out.println("----------------------------------------");
        }
    }
}