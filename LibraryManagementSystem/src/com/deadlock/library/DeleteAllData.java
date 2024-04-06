package com.deadlock.library;

import java.util.Scanner;

public class DeleteAllData implements IOOperation{

    @Override
    public void oper(Database database, User user) {

        Scanner s = new Scanner(System.in);
        System.out.println("Are you sure that you want to delete all data?");
        System.out.println("1. Continue");
        System.out.println("2. Main Menu");
        int option = s.nextInt();
        if(option == 1){
            database.deleteAllData();
        }else{
            user.menu(database, user);
        }
    }
}
