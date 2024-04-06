package com.deadlock.library;

import java.util.ArrayList;

public class ViewBooks implements IOOperation{

    @Override
    public void oper(Database database, User user){
        ArrayList<Book> books =  database.getAllBooks();

        for(Book b: books){
            System.out.println(b.getName() + "\t\t" + b.getAuthor() + "\t\t" + b.getPublisher() + "\t\t" + b.getAddress() + "\t\t" + b.getStatus() + "\t\t" + b.getQty() + "\t\t" + b.getPrice() + "\t\t" + b.getBrwcopies());
        }

        System.out.println();
        user.menu(database, user);
    }

}
