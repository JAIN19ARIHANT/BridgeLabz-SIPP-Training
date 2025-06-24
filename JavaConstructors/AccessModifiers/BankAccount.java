package JavaConstructors.AccessModifiers;

class BankAccount {
    public String accountNumber;
    protected String accountHolder;
    private double balance;

    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        }
    }
}

class SavingsAccount extends BankAccount {
    public SavingsAccount(String accountNumber, String accountHolder, double balance) {
        super(accountNumber, accountHolder, balance);
    }

    public void display() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
    }

    public static void main(String[] args) {
        SavingsAccount sa = new SavingsAccount("12345677", "Arihant Jain", 97500);
        sa.display();
        System.out.println("Balance: " + sa.getBalance());
        sa.deposit(27500);
        sa.withdraw(9000);
        System.out.println("Updated Balance: " + sa.getBalance());
    }
}
