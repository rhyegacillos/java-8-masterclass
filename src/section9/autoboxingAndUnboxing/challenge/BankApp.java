package section9.autoboxingAndUnboxing.challenge;

public class BankApp {
    public static void main(String[] args) {
        Bank bank = new Bank("National Phil Bank");

        if (bank.addBranch("Cavite")) {
            System.out.println("Cavite Branch created!");
        }

        bank.addCustomer("Cavite", "Rhye Gacillos", 5000);
        bank.addCustomer("Cavite", "Aphy Gallahad", 7000);
        bank.addCustomer("Cavite", "Ian Laro", 15000);

        bank.addBranch("Laguna");
        bank.addCustomer("Laguna", "James Marcos", 9000);
        bank.addCustomer("Laguna", "Tim Burgos", 12.21);

        bank.addCustomerTransaction("Cavite", "Rhye Gacillos", 2000.25);
        bank.addCustomerTransaction("Cavite", "Rhye Gacillos", 200.25);
        bank.addCustomerTransaction("Cavite", "Aphy Gallahad", 270.25);
        bank.addCustomerTransaction("Laguna", "James Marcos", 900.50);
        bank.addCustomerTransaction("Laguna", "James Marcos", 1900.50);

        bank.listCustomer("Cavite", true);
        bank.listCustomer("Laguna", true);

        if(!bank.addCustomer("Batangas", "July Best", 25.65)) {
            System.out.println("Error: Batangas branch does not exist");
        }

        if(!bank.addBranch("Cavite")) {
            System.out.println("Cavite branch already exists");
        }

        if (!bank.addCustomerTransaction("Laguna", "Andrew", 600)) {
            System.out.println("Customer does not exist at branch");
        }

        if(!bank.addCustomer("Laguna", "Tim Burgos", 12.21)) {
            System.out.println("Customer Tim Burgos already exists");
        }
    }
}
