package BM23AI069;

class LessBalanceException extends Exception {
    public LessBalanceException(String message) {
        super(message);
    }
}

class Account {
    private double balance;

    public Account() {
        this.balance = 500;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited Rs" + amount + ". Current balance: Rs" + balance);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public void withdraw(double amount) throws LessBalanceException {
        if (balance - amount < 500) {
            throw new LessBalanceException("Withdraw amount Rs" + amount + " is not valid. Minimum balance of Rs500 must be maintained.");
        } else {
            balance -= amount;
            System.out.println("Withdrawn Rs" + amount + ". Current balance: Rs" + balance);
        }
    }

    public double getBalance() {
        return balance;
    }
}

public class Main {
    public static void main(String[] args) {
        try {
            Account account1 = new Account();
            Account account2 = new Account();

            account1.deposit(1000);
            account2.deposit(1500);

            account1.withdraw(600);
            account2.withdraw(1200);
        } catch (LessBalanceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
