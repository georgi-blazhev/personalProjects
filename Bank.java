package Banking;

import java.util.ArrayList;

public class Bank {

    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<>();
    }

    public boolean addBranch(String branchName){
        Branch branch = findBranch(branchName);

        if (branch == null){

            branches.add(new Branch(branchName));
            return true;
        }
        return false;
    }

    public boolean addCustomer(String branchName, String customerName, double initialTransaction){
        Branch branch = findBranch(branchName);

        if (branch != null){
            return branch.newCustomer(customerName,initialTransaction);
        }
        return false;
    }

    public boolean addCustomerTransaction(String branchName, String customerName, double amount){
        Branch branch = findBranch(branchName);

        if (branch != null){
            branch.addCustomerTransaction(customerName,amount);
            return true;
        }
        return false;
    }

    public boolean listCustomers(String branchName, boolean printTransactions){



        Branch branch = findBranch(branchName);

        if (branch != null){
            System.out.println("Customer details for branch " + branch.getName());


            ArrayList<Customer> branchCustomers = branch.getCustomers();

            for (int i = 0; i < branchCustomers.size(); i++){
                Customer customer = branchCustomers.get(i);
                System.out.println("Customer: " + customer.getName() + "[" + (i+1) + "]");

                if (printTransactions){
                    System.out.println("Transactions");
                    ArrayList<Double> transactions = customer.getTransactions();
                    for (int j = 0; j <transactions.size(); j++){
                        System.out.println("[" + (j+1) + "]" + " Amount " + transactions.get(j));
                    }
                }
            }
            return true;
        } else {
            return false;
        }
    }

    private Branch findBranch(String branchName){

        for (int i = 0; i < branches.size(); i++){
            Branch branch = branches.get(i);

            if (branchName.equals(branch.getName())){
                return branch;
            }
        }
        return null;
    }
}
