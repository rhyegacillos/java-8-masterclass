package section9.linkedlist;

import java.util.ArrayList;

public class ArrayListDemo {
    public static void main(String[] args) {
        Customer customer = new Customer("Tim", 546.4);
        Customer anotherCustomer;
        anotherCustomer = customer;
        anotherCustomer.setBalance(34.3);
        System.out.println("Balance for customer " + customer.getName() + " is " + customer.getBalance());

        ArrayList<Integer> intList = new ArrayList<>();

        intList.add(1);
        intList.add(3);
        intList.add(4);

        for (int i = 0; i < intList.size(); i++) {
            System.out.println(i + ": " +  intList.get(i));
        }

        intList.add(1, 2);
        for (int i = 0; i < intList.size(); i++) {
            System.out.println(i + ": " +  intList.get(i));
        }
    }
}
