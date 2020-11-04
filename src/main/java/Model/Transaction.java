package Model;

import java.io.Serializable;
import java.time.LocalDate;


public class Transaction implements Serializable {

    private LocalDate dateOfTransaction;
    private double balance;
    private double newBalance;
    private double change;

    public Transaction(Account account, double change) {
        this.dateOfTransaction = LocalDate.now();
        this.balance = account.getBalance();
        this.change = change;
        this.newBalance = account.getBalance() + change;
        account.setBalance(newBalance);
    }

    public LocalDate getDateOfTransaction() {
        return dateOfTransaction;
    }

    public double getBalance() {
        return balance;
    }

    public double getNewBalance() {
        return newBalance;
    }

    public double getChange() {
        return change;
    }
}
