package Model;

public class Employee extends Person{

    private int employeeID;
    private int employeeCode;

    public Employee(String firstName, String lastName, String socialSecurityNumber, int employeeID, int employeeCode) {
        super(firstName, lastName, socialSecurityNumber);
        this.employeeID = employeeID;
        this.employeeCode = employeeCode;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public int getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(int employeeCode) {
        this.employeeCode = employeeCode;
    }


}
