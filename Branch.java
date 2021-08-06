package Banking;

import java.util.ArrayList;

public class Branch {
    private String name;
    private ArrayList<Customer> customers;

    public Branch(String name) {
        this.name = name;
        this.customers = new ArrayList<Customer>();
    }

    public boolean newCustomer(String customerName, double initialTransaction){

        Customer existingCustomer = findCustomer(customerName);

        if (existingCustomer == null){
            this.customers.add(new Customer(customerName,initialTransaction));
            return true;
        }
        return false;
    }

    public boolean addCustomerTransaction(String customerName, double amount){
        Customer customer = findCustomer(customerName);

        if (customer != null){
            customer.addTransaction(amount);
            return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }


    private Customer findCustomer(String customerName){

        for (int i = 0; i < customers.size(); i++){
            Customer customer = this.customers.get(i);

            if (customerName.equals(customer.getName())){
                return customer;
            }
        }
        return null;
    }
}
