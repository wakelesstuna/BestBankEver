package Model;

import java.util.List;

public class Util {

    public int findCustomerIfThereIsCustomerWithSSC(List<Customer> list, String SSC){
        int counter = 0;
        for (Customer c : list) {
            if (c.getSocialSecurityNumber().equals(SSC)) {
                counter = 1;
                break;
            }
        }
        return counter;
    }
}
