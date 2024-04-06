package com.deadlock.library;

import java.util.Scanner;

public class CalculateFine implements IOOperation{
    @Override
    public void oper(Database database, User user) {
        System.out.print("Enter book name :");
        Scanner s = new Scanner(System.in);
        String bookName = s.next();

        boolean g = true;

        for(Borrowing b: database.getBrws()){
            if(b.getBook().getName().matches(bookName) && b.getUser().getName().matches(user.getName())){
//                System.out.println(b.getDaysLeft());
                if(b.getDaysLeft() > 0){
                    System.out.println("You are late!");
                    System.out.println("You have to pay " + b.getDaysLeft()*50 + " as fine");
                }else{
                    System.out.println("You don't have to pay fine\n");
                }
                g = false;
                break;
            }
        }

        if(g){
            System.out.println("You didn't borrow this book!");
        }

        user.menu(database, user);
    }
}
