package Model;

import java.time.LocalDate;

public class LoanChanges {

    private LocalDate dateOfChanges;
    private Employee admin;
    private double newInterestRate;

    public LoanChanges(Employee admin, double newInterestRate) {
        this.dateOfChanges = LocalDate.now();
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

    @Override
    public String toString() {
        return "LoanChanges{" +
                "dateOfChanges=" + dateOfChanges +
                ", admin=" + admin.getFirstName() +
                ", newInterestRate=" + newInterestRate +
                '}';
    }
}
