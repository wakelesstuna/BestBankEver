package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Account implements Serializable {
    private int accountId;
    private int accountNumber;
    private int customerId;
    private double balance;
    private double interestRate;
    private String accountType;
    private List<Transaction> transactions;

    public Account(int accountId, int accountNumber, int customerId, double balance, double interestRate, String accountType) {
        this.accountId = accountId;
        this.accountNumber = accountNumber;
        this.customerId = customerId;
        this.balance = balance;
        this.interestRate = interestRate;
        this.accountType = accountType;
        this.transactions = new ArrayList<>();
    }



    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

}
