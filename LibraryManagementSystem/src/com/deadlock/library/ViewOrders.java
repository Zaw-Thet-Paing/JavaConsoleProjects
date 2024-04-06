package com.deadlock.library;

import java.util.ArrayList;
import java.util.Scanner;

public class ViewOrders implements IOOperation{
    @Override
    public void oper(Database database, User user) {
        System.out.print("\nEnter book name :");
        Scanner s = new Scanner(System.in);
        String bookname = s.next();

        int i = database.getBook(bookname);

        if(i > -1){

            for(Order order: database.getAllOrders()){
                if(order.getBook().getName().matches(bookname)){
                    System.out.println(order.getBook().getName()+"\t\t"+order.getUser().getName()+"\t\t"+order.getQty()+"\t\t"+order.getPrice());
                }
                System.out.println();
            }

        }else{
            System.out.println("Book doesn't exists\n");
        }
        user.menu(database, user);
    }
}
