package com.deadlock.inventory;

import java.util.Scanner;

public class InventoryManager {
    private final Helper h;
    private Scanner scanner;
    private ItemDAO itemDAO;
    public InventoryManager(){
        h = new Helper();
        scanner = new Scanner(System.in);
        itemDAO = new ItemDAO();
    }

    public void addNewItem(){

        h.banner("Add New Item");
        System.out.print("Enter name :");
        String name = scanner.nextLine();
        System.out.print("Enter price :");
        double price = scanner.nextDouble();
        int id = generateItemId();

        itemDAO.saveItem(new Item(id, name, price));

        System.out.println("Item added successfully...");

    }

    public void getAllItems(){
        h.banner("Get All Items");
        MyArray items = itemDAO.getItems();
        if(items.isEmpty()){
            System.out.println("No item to show!");
        }else {
            for(int i = 0; i<items.getItemCount(); i++){
                Item item = (Item)items.get(i);
                System.out.println(item.displayItem());
            }
        }
    }

    public void getItemById(){
        h.banner("Get Item By ID");
        System.out.print("Enter id to get item :");
        int id = scanner.nextInt();
        scanner.nextLine();
        Item item = searchItemByID(id);

        if(item == null){
            System.out.println("No item found with provided ID");
        }else{
            System.out.println(item.displayItem());
        }

    }

    public void updateItem(){
        h.banner("Update Item");
        System.out.print("Enter id to update item :");
        int id = scanner.nextInt();
        scanner.nextLine();

        Item item = searchItemByID(id);

        if(item == null){
            System.out.println("No item found to update with that ID");
        }else{
            System.out.println(item.displayItem());
            System.out.print("Enter name to update :");
            String name = scanner.nextLine();
            System.out.print("Enter price to update :");
            double price = scanner.nextDouble();
            itemDAO.updateItem(new Item(id, name, price));
            System.out.println("Item updated success...");
        }

    }

    public void deleteItem(){
        h.banner("Delete Item");
        System.out.print("Enter id to delete item :");
        int id = scanner.nextInt();
        scanner.nextLine();

        Item item = searchItemByID(id);

        if(item == null){
            System.out.println("No item found to delete with that ID");
        }else{
            System.out.println(item.displayItem());
            System.out.print("Are you sure to delete this item(y/n)?");
            char yOrn = scanner.next().charAt(0);

            if(yOrn == 'y'){
                itemDAO.deleteItem(id);
                System.out.println("Item deleted success..");
            }else{
                System.out.println("Item didn't delete..");
            }

        }

    }

    private int generateItemId() {
        MyArray items = itemDAO.getItems();
        if(items.isEmpty()){
            return 1;
        } else {
            Item lastItem = (Item) items.get(items.getItemCount() - 1);
            return lastItem.getId() + 1;
        }
    }

    private Item searchItemByID(int id){

        MyArray items = itemDAO.getItems();
        Item item = null;
        for(int i = 0; i<items.getItemCount(); i++){
            Item sItem = (Item) items.get(i);
            if(sItem.getId() == id){
                item = sItem;
                break;
            }
        }
        return item;
    }

}
