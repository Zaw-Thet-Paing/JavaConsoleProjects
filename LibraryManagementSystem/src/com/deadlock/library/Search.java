package com.deadlock.library;

import java.util.Scanner;

public class Search implements IOOperation{

    @Override
    public void oper(Database database, User user){
        Scanner s = new Scanner(System.in);

        System.out.print("\nEnter book name :");
        String name = s.next();

        int i = database.getBook(name);
        if(i > -1){
            String text = "\n"+database.getBook(i).toString()+"\n";
            System.out.println(text);
        }else{
            System.out.println("Book doesn't exist!");
        }
        user.menu(database, user);

    }

}
