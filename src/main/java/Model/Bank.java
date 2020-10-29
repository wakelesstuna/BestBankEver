package Model;

import java.util.ArrayList;
import java.util.List;

public class Bank {

    List<Employee> employeeList = new ArrayList<>();
    List<Customer> customerList = new ArrayList<>();

    private Employee HeadOfBank = new Employee("Oscar", "Forss", "910910XXXX", 123456, 123456);
    private Customer customer1  = new Customer("Oscar", "Forss", "910910XXXX", 123456, 1234);

    public Bank(){
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
