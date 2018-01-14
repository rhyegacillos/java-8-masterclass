package section9.linkedlist;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class LinkedListDemo {

    public static void main(String[] args) {
        LinkedList<String> placesToVisit = new LinkedList<>();
        addInOrder(placesToVisit, "Cavite");
        addInOrder(placesToVisit, "Laguna");
        addInOrder(placesToVisit, "Batangas");
        addInOrder(placesToVisit, "Benguet");
        addInOrder(placesToVisit, "Palawan");
        addInOrder(placesToVisit, "Bulacan");
        addInOrder(placesToVisit, "Pampanga");

        printList(placesToVisit);

        addInOrder(placesToVisit, "Pampanga");

        printList(placesToVisit);

        visit(placesToVisit);



    }

    private static void printList(LinkedList<String> placesToVisit) {
        Iterator<String> i = placesToVisit.iterator();

        while (i.hasNext()) {
            System.out.println("Now visiting " + i.next());
        }
        System.out.println("==========================");
    }

    private static boolean addInOrder(LinkedList<String> placesToVisit, String place) {
        ListIterator<String> stringListIterator = placesToVisit.listIterator();

        while (stringListIterator.hasNext()) {
            int comparison = stringListIterator.next().compareTo(place);
            if(comparison == 0) {
                // equal, do not add
                System.out.println(place + " is already included as a destination");
                return false;
            } else if(comparison > 0) {
                // new place will add before
                stringListIterator.previous();
                stringListIterator.add(place);
                return true;
            } else if(comparison < 0) {
                // move on next city
            }
        }

        stringListIterator.add(place);
        return true;
    }

    private static void visit(LinkedList cities) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean goingForward = true;
        ListIterator<String> listIterator = cities.listIterator();

        if (cities.isEmpty()) {
            System.out.println("No cities in the itenerary");
            return;
        } else {
            System.out.println("Now visiting " + listIterator.next());
            printMenu();
        }

        while (!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 0:
                    System.out.println("Holiday (Vacation) over");
                    quit = true;
                    break;
                case 1:
                    if (!goingForward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        goingForward = true;
                    }
                    if(listIterator.hasNext()) {
                        System.out.println("Now visiting " + listIterator.next());
                    } else {
                        System.out.println("Reached the end of the list");
                        goingForward = false;
                    }
                    break;
                case 2:
                    if (goingForward) {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        goingForward = false;
                    }
                    if (listIterator.hasPrevious()) {
                        System.out.println("Now visiting " + listIterator.previous());
                    } else {
                        System.out.println("We are at the start of the list");
                        goingForward = true;
                    }
                    break;
                case 3:
                    printMenu();
                    break;
            }
        }

    }

    private static void printMenu() {
        System.out.println("Available actions:\npress ");
        System.out.println("0 - to quit");
        System.out.println("1 - to next place");
        System.out.println("2 - to previous place");
        System.out.println("3 - print menu options");
    }
}
