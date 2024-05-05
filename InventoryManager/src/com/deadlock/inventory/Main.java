package com.deadlock.inventory;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        menu();
    }

    static void menu(){
        Scanner scanner = new Scanner(System.in);
        Helper h = new Helper();
        InventoryManager inventoryManager = new InventoryManager();

        h.banner("Inventory Manager");
        System.out.println("1. Add New Item");
        System.out.println("2. Get All Items");
        System.out.println("3. Get Item By ID");
        System.out.println("4. Update Item");
        System.out.println("5. Delete Item");
        System.out.println("0. Exit");

        System.out.print("Enter your option :");
        String option = scanner.nextLine();

        switch (option){
            case "1":
                inventoryManager.addNewItem();
                break;
            case "2":
                inventoryManager.getAllItems();
                break;
            case "3":
                inventoryManager.getItemById();
                break;
            case "4":
                inventoryManager.updateItem();
                break;
            case "5":
                inventoryManager.deleteItem();
                break;
            case "0":
                System.out.println("Program exit...");
                System.exit(0);
            default:
                System.out.println("Invalid option! Try again!");
        }
        menu();
    }

}