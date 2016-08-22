package tiyinc.noobs;

import java.util.ArrayList;

/**
 * Created by Yehia830 on 8/22/16.
 */
public class BankCustomer {
    private ArrayList<String> customers;

    public BankCustomer(){
        customers = new ArrayList<String >();
    }
    public boolean addCustomer(String customer) {
        customers.add(customer);
        return true;
    }
}
