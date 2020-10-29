package Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Loan {
    private int loanID;
    private double amount;
    private double remainingAmount;
    private double interestRate;
    private double monthlyPayment;
    private LocalDate loanDate;
    private List<LoanChanges> loanChanges;

    public Loan(){}

    public Loan(int loanID, double amount, double remainingAmount, double interestRate, double monthlyPayment) {
        this.loanID = loanID;
        this.amount = amount;
        this.remainingAmount = remainingAmount;
        this.interestRate = interestRate;
        this.monthlyPayment = monthlyPayment;
        this.loanDate = LocalDate.now();
        this.loanChanges = new ArrayList<>();
    }

    public int getLoanID() {
        return loanID;
    }

    public void setLoanID(int loanID) {
        this.loanID = loanID;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getRemainingAmount() {
        return remainingAmount;
    }

    public void setRemainingAmount(double remainingAmount) {
        this.remainingAmount = remainingAmount;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public double getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(double monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(LocalDate loanDate) {
        this.loanDate = loanDate;
    }

    public List<LoanChanges> getLoanChanges() {
        return loanChanges;
    }
}
