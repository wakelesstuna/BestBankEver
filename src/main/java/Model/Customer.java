package Model;

import java.util.ArrayList;
import java.util.List;

public class Customer extends Person{

    private int customerId;
    private int pin;

    private List<Account> accounts = new ArrayList<>();
    private List<Loan> loans = new ArrayList<>();

    public Customer(String firstName, String lastName, String socialSecurityNumber, int customerId, int pin) {
        super(firstName, lastName, socialSecurityNumber);
        this.customerId = customerId;
        this.pin = pin;

    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public List<Loan> getLoans() {
        return loans;
    }

    public void setLoans(List<Loan> loans) {
        this.loans = loans;
    }
}
