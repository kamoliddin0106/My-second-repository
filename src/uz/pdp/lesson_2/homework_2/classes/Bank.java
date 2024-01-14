package uz.pdp.lesson_2.homework_2.classes;

public class Bank {
    private Account[] accounts;

    public Bank(int initialBalance) {
        this.accounts = new Account[100];
        for (int i = 0; i < accounts.length; i++) {
            accounts[i] = new Account(initialBalance);
        }
    }

    public void transfer(int from, int to, int amount) {
        Account fromAccount = accounts[from];
        Account toAccount = accounts[to];
        if (fromAccount.getBalance() < amount) return;
        System.out.println(fromAccount + "$ dan " + toAccount + "$ ga Qiymat: " + amount + "$");
        fromAccount.setBalance(fromAccount.getBalance() - amount);
        toAccount.setBalance(toAccount.getBalance() + amount);
    }


    @Override
    public String toString() {
        for (Account account : accounts) {
            System.out.println(account.getName() + " " + account.getBalance());
        }
        return "";
    }


}

