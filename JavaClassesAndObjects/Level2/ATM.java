package JavaClassesAndObjects.Level2;

class ATM {
    String accountHolder;
    long accountNumber;
    double balance;

    ATM(String accountHolder, long accountNumber, double balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited ₹" + amount);
    }

    void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn ₹" + amount);
        } else {
            System.out.println("Insufficient funds !");
        }
    }

    void displayBalance() {
        System.out.println("Current balance: ₹" + balance);
    }

    public static void main(String[] args) {
        ATM acc = new ATM("Arihant Jain", 2215000337, 98728.02);
        acc.deposit(27005);
        acc.withdraw(56020);
        acc.displayBalance();
    }
}

