package com.deadlock.library;
import java.util.Scanner;

public class Main{

    static Scanner s;
    static Database database;

    public static void main(String[] args) {

        database = new Database();

        s = new Scanner(System.in);
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
            }else{
                System.out.println("Invalid option! Try again!");
            }

        }while (option != 0);

    }

    private static void login(){
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

    private static void newUser(){
        System.out.print("Enter name :");
        String name = s.next();

        if(database.userExists(name)){
            System.out.println("User exists!");
            return;
        }

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