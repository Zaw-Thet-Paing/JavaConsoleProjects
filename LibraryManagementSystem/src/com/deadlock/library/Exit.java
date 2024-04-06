package com.deadlock.library;

import java.util.Scanner;

public class Exit implements IOOperation{

    Scanner s;
    Database database;
    User user;

    @Override
    public void oper(Database database, User user) {
        this.database = database;
        this.user = user;
        s = new Scanner(System.in);
        System.out.println("Are you sure that you want to quit?");
        System.out.println("1. Yes");
        System.out.println("2. Main Menu");
        int i = s.nextInt();

        if(i == 1){
            int option;
            do{
                System.out.println("Welcome to Library Management System!");
                System.out.println("1. Login\n2. New user\n0. Exit");
                System.out.print("Enter your option :");
                option = s.nextInt();

                if(option == 1){
                    login();
                }else if(option == 2){
                    newUser();
                }else if(option == 0){
                    System.out.println("Program exit...");
                    System.exit(0);
                }else{
                    System.out.println("Invalid option! Try again!");
                }

            }while (option != 0);
        }else{
            user.menu(database, user);
        }

    }

    private void login(){
        System.out.print("Enter phoneNumber :");
        String phoneNumber = s.next();
        System.out.print("Enter email :");
        String email = s.next();

        int userIndex = database.login(phoneNumber, email);
        if(userIndex != -1){
            User user = database.getUser(userIndex);
            user.menu(database, user);
        }else{
            System.out.println("User doesn't exist!");
        }

    }

    private void newUser(){
        System.out.print("Enter name :");
        String name = s.next();
        System.out.print("Enter phoneNumber :");
        String phoneNumber = s.next();
        System.out.print("Enter email :");
        String email = s.next();

        System.out.println("1. Admin\n2. Normal User");
        System.out.print("Enter your option :");
        int option = s.nextInt();
        User user;
        if(option == 1){
            user = new Admin(name, email, phoneNumber);
        }else{
            user = new NormalUser(name, email, phoneNumber);
        }

        database.addUser(user);
        user.menu(database, user);

    }
}
