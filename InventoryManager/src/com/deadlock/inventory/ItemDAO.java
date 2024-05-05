package com.deadlock.inventory;

import java.io.*;

public class ItemDAO {
    private File file;

    public ItemDAO(){
        //replace with your file path
        file = new File("D:\\Z\\Java\\InventoryManager\\files\\data.txt");
    }
    public void saveItem(Item item){
        MyArray items = loadAllDataFromFile();
        items.add(item);
        saveAllDataToFile(items);
    }

    public MyArray getItems(){
        return loadAllDataFromFile();
    }

    public Item getItem(int id){
        MyArray items = loadAllDataFromFile();
        Item item = (Item) items.get(id);
        return item;
    }

    public void updateItem(Item updateItem){
        MyArray items = loadAllDataFromFile();

        for(int i = 0; i<items.getItemCount(); i++){
            Item item = (Item) items.get(i);
            if(item.getId() == updateItem.getId()){
                item.setName(updateItem.getName());
                item.setPrice(updateItem.getPrice());
                break;
            }
        }

        saveAllDataToFile(items);

    }

    public void deleteItem(int id){
        MyArray items = loadAllDataFromFile();
        int indexToDelete = -1;
        for(int i = 0; i<items.getItemCount(); i++){
            Item item = (Item) items.get(i);
            if(item.getId() == id){
                indexToDelete = i;
            }
        }
        items.remove(indexToDelete);
        saveAllDataToFile(items);
    }

    private void saveAllDataToFile(MyArray items){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(file))){
            for(int i = 0; i<items.getItemCount(); i++){
                Item item = (Item) items.get(i);
                writer.write(item.getId() + " " + item.getName() + " " + item.getPrice());
                writer.write("\n");
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    private MyArray loadAllDataFromFile(){
        MyArray items = new MyArray(50);
        try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while((line = reader.readLine()) != null){
                String[] itemInfo = line.split(" ");
                int id = Integer.parseInt(itemInfo[0]);
                String name = itemInfo[1];
                double price = Double.parseDouble(itemInfo[2]);

                items.add(new Item(id, name, price));

            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return items;
    }

}
