package section9.arraylist;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static GroceryList groceryList = new GroceryList();

    public static void main(String[] args) {
        boolean quit = false;
        int choice = 0;
        printInstruction();
        while (!quit) {
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0:
                    printInstruction();
                    break;
                case 1:
                    groceryList.printGroceryList();
                    break;
                case 2:
                    addItem();
                    break;
                case 3:
                    modifyItem();
                    break;
                case 4:
                    removeItem();
                    break;
                case 5:
                    searchForItem();
                    break;
                case 6:
                    processArrayList();
                case 7:
                    quit = true;
                    break;
            }

        }

    }

    private static void processArrayList() {
        ArrayList<String> grocery = new ArrayList<>(groceryList.getGroceryList());
        System.out.println(grocery);
    }

    private static void searchForItem() {
        System.out.println("Item to search for: ");
        String searchItem = scanner.nextLine();
        if (groceryList.onFile(searchItem)) {
            System.out.println("Found " + searchItem + " in our grocery list");
        } else {
            System.out.println(searchItem + " is not in the shopping list");
        }
    }

    private static void removeItem() {
        System.out.print("Enter item name: ");
        String itemName = scanner.nextLine();
        groceryList.removeGroceryItem(itemName);
    }

    private static void modifyItem() {
        System.out.print("Enter current item: ");
        String currentItem = scanner.nextLine();
        System.out.print("Enter new item: ");
        String newItem = scanner.nextLine();

        groceryList.modifyGroceryItem(currentItem, newItem);
    }
    private static void addItem() {
        System.out.print("Please enter the grocery item: ");
        groceryList.addGroceryItem(scanner.nextLine());
    }

    private static void printInstruction() {
        System.out.println("\nPress");
        System.out.println("\t 0 - To print choice options");
        System.out.println("\t 1 - To print the list of grocery items");
        System.out.println("\t 2 - To add an item to the list.");
        System.out.println("\t 3 - To modify an item in the list.");
        System.out.println("\t 4 - To remove an item from the list.");
        System.out.println("\t 5 - To search for an item in this list.");
        System.out.println("\t 6 - To quit the application.");
    }
}
