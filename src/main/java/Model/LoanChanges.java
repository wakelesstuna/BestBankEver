package Model;

import java.time.LocalDate;

public class LoanChanges {

    private LocalDate dateOfChanges;
    private Employee admin;
    private double newInterestRate;

    public LoanChanges(LocalDate dateOfChanges, Employee admin, double newInterestRate) {
        this.dateOfChanges = dateOfChanges;
        this.admin = admin;
        this.newInterestRate = newInterestRate;
    }

    public LocalDate getDateOfChanges() {
        return dateOfChanges;
    }

    public void setDateOfChanges(LocalDate dateOfChanges) {
        this.dateOfChanges = dateOfChanges;
    }

    public Employee getAdmin() {
        return admin;
    }

    public void setAdmin(Employee admin) {
        this.admin = admin;
    }

    public double getNewInterestRate() {
        return newInterestRate;
    }

    public void setNewInterestRate(double newInterestRate) {
        this.newInterestRate = newInterestRate;
    }

}
