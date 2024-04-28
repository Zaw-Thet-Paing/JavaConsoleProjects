package com.deadlock.contact;

import java.util.Scanner;

public class ContactManager {
    private MyArray contacts;
    private int size;
    Scanner input;
    public ContactManager(int size){
        contacts = new MyArray(size);
        input = new Scanner(System.in);
        this.size = size;
    }

    public void addContact(){
        String name;
        String contactOption;
        banner("Add New Contact");
        System.out.print("Enter name :");
        name = input.nextLine();

        do{
            System.out.println("1. Personal Contact");
            System.out.println("2. Business Contact");
            System.out.print("Enter your contact option :");
            contactOption = input.nextLine();

            if(contactOption.equals("1") || contactOption.equals("2")){
                break;
            }else{
                System.out.println("Invalid contact option! Try again!");
            }

        }while(true);

        Contact contact;

        if(contactOption.equals("1")){
            String phoneNumber;
            System.out.print("Enter phone :");
            phoneNumber = input.nextLine();
            contact = new PersonalContact(name, phoneNumber);
        }else{
            String email;
            System.out.print("Enter email :");
            email = input.nextLine();
            contact = new BusinessContact(name, email);
        }

        contacts.add(contact);

        System.out.println("New Contact Added success...");

    }

    public void listAllContacts(){
        banner("List All Contacts");
        for(int i = 0; i<contacts.getItemCount(); i++){
            Contact contact = (Contact) contacts.get(i);
            contact.displayContacts();
        }
    }

    public void searchContacts(){

        String name;
        MyArray matchedContacts = new MyArray(size);

        banner("Search contacts by name");
        System.out.print("Enter name to search contacts :");
        name = input.nextLine();

        for(int i = 0; i<contacts.getItemCount(); i++){
            Contact contact = (Contact) contacts.get(i);
            if(contact.getName().toLowerCase().contains(name.toLowerCase())){
                matchedContacts.add(contact);
            }
        }

        if(matchedContacts.isEmpty()){
            System.out.println("No contacts found to show");
            return;
        }

        for(int i = 0; i<matchedContacts.getItemCount(); i++){
            Contact contact = (Contact) matchedContacts.get(i);
            contact.displayContacts();
        }

    }

    public void deleteContact(){
        banner("Delete Contact");
        String name;
        int contactIndex;

        System.out.print("Enter name to delete :");
        name = input.nextLine();
        contactIndex = getIndexByName(name);

        if(contactIndex == -1){
            System.out.println("Contact not found to delete!");
            return;
        }

        contacts.remove(contactIndex);

        System.out.println("Contact deleted success...");

    }

    public void editContact(){
        banner("Edit Contact");
        String name;
        int contactIndex;

        System.out.print("Enter name to search :");
        name = input.nextLine();
        contactIndex = getIndexByName(name);

        if(contactIndex == -1){
            System.out.println("Contact not found to edit!");
            return;
        }

        Contact contact = (Contact) contacts.get(contactIndex);

        Contact editedContact;

        if(contact.getType() == ContactType.PERSONAL){
            String uName;
            String uPhoneNumber;
            System.out.print("Enter name to edit :");
            uName = input.nextLine();
            System.out.print("Enter phone number to edit :");
            uPhoneNumber = input.nextLine();
            editedContact = new PersonalContact(uName, uPhoneNumber);
        }else{
            String uName;
            String uEmail;
            System.out.print("Enter name to edit :");
            uName = input.nextLine();
            System.out.print("Enter email to edit :");
            uEmail = input.nextLine();
            editedContact = new BusinessContact(uName, uEmail);
        }

        contacts.update(contactIndex, editedContact);

        System.out.println("Contact edited success...");
    }

    private int getIndexByName(String name){
        int contactIndex = -1;

        for(int i = 0; i<contacts.getItemCount(); i++){
            Contact contact = (Contact) contacts.get(i);
            if(contact.getName().equalsIgnoreCase(name)){
                contactIndex = i;
                break;
            }
        }

        return contactIndex;
    }

    public void banner(String text){
        printStar(text.length());
        System.out.println(text);
        printStar(text.length());
    }

    private void printStar(int count){
        for(int i = 0; i<count; i++){
            System.out.print('*');
        }
        System.out.println();
    }

}
