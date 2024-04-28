package com.deadlock.contact;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ContactManager contactManager = new ContactManager(50);
        Scanner scanner = new Scanner(System.in);
        String option;
        do{
            contactManager.banner("Contact Management System");
            System.out.println("1. Add New Contact");
            System.out.println("2. List All Contacts");
            System.out.println("3. Search Contacts");
            System.out.println("4. Delete Contact");
            System.out.println("5. Edit Contact");
            System.out.println("0. Exit");
            System.out.print("Enter your option :");
            option = scanner.nextLine();

            switch (option){
                case "1":
                    contactManager.addContact();
                    break;
                case "2":
                    contactManager.listAllContacts();
                    break;
                case "3":
                    contactManager.searchContacts();
                    break;
                case "4":
                    contactManager.deleteContact();
                    break;
                case "5":
                    contactManager.editContact();
                    break;
                case "0":
                    System.out.println("Program exit...");
                    System.exit(0);
                default:
                    System.out.println("Invalid option! Try again!");
            }

        }while (true);

    }
}
