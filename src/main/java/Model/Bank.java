package Model;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Bank {

    List<Employee> employeeList = new ArrayList<>();
    List<Customer> customerList = new ArrayList<>();

    Loan loan1 = new Loan(1234,25000,25000,2, 500);
    Loan loan2 = new Loan(4321,25000,22000,1, 546);
    Loan loan3 = new Loan(2134,25000,24000,1.5, 344);
    Loan loan4 = new Loan(2134,25000,24000,1.5, 344);
    Loan loan5 = new Loan(2134,25000,24000,1.5, 344);
    Loan loan6 = new Loan(2134,25000,24000,1.5, 344);
    Loan loan7 = new Loan(2134,25000,24000,1.5, 344);
    Loan loan8 = new Loan(2134,25000,24000,1.5, 344);

    private Employee HeadOfBank = new Employee("Oscar", "Forss", "910910XXXX", 123456, 123456);
    private Customer customer1  = new Customer("Oscar", "Forss", "910910XXXX","0709314079", 123456, 1234);

    public Bank(){
        customer1.getLoans().add(loan1);
        customer1.getLoans().add(loan2);
        customer1.getLoans().add(loan3);
        customer1.getLoans().add(loan4);
        customer1.getLoans().add(loan5);
        customer1.getLoans().add(loan6);
        customer1.getLoans().add(loan7);
        customer1.getLoans().add(loan8);

        employeeList.add(HeadOfBank);
        customerList.add(customer1);
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }
}
