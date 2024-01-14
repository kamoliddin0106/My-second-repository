package uz.pdp.lesson_1.classes;

public class Account {
    private int balance;
    private String name = "Account" + counter++;
    private static int counter = 0;

    public Account(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + ": " + balance;
    }
}
