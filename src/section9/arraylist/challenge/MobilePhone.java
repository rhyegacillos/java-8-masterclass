package section9.arraylist.challenge;

import java.util.ArrayList;

public class MobilePhone {
    private String myNumber;
    private ArrayList<Contact> myContacts;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<>();
    }

    public boolean addNewContact(Contact contact) {
        if(findContact(contact.getName()) >= 0) {
            return false;
        }
        myContacts.add(contact);
        return true;
    }

    public boolean updateContact(Contact currentContact, Contact newContact) {
        int position = findContact(currentContact);
        if(position < 0) {
            System.out.println(currentContact.getName() + " was not found.");
            return false;
        }

        this.myContacts.set(position, newContact);
        System.out.println(currentContact.getName() + " was successfully replaced with " + newContact.getName());
        return true;
    }

    public String queryContact(Contact contact) {
        if (findContact(contact) >= 0) {
            return contact.getName();
        }

        return null;
    }

    public boolean removeContact(Contact contact) {
        int foundPosition = findContact(contact);
        if (foundPosition < 0) {
            System.out.println(contact.getName() + " was not found.");
            return false;
        }

        this.myContacts.remove(foundPosition);
        System.out.println(contact.getName() + " was deleted.");
        return true;
    }

    private int findContact(Contact contact) {
        return this.myContacts.indexOf(contact);
    }

    private int findContact(String contactName) {
        for(int i = 0; i <this.myContacts.size(); i++) {
            Contact contact = this.myContacts.get(i);
            if(contact.getName().equals(contactName))
                return i;
        }

        return -1;
    }

    public void printContacts() {
        System.out.println("Contact List");
        if (this.myContacts.size() > 0) {
            for (int i = 0; i < this.myContacts.size(); i++){
                System.out.println((i+1) + ". " +
                        this.myContacts.get(i).getName() + " -> " +
                        this.myContacts.get(i).getPhoneNumber());
            }
        } else {
            System.out.println("No contact added.");
        }

    }

    public Contact queryContact(String name) {
        int position = findContact(name);
        if (position >= 0) {
            return this.myContacts.get(position);
        }

        return null;
    }
}
