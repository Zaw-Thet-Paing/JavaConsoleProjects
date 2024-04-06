package com.deadlock.library;

import java.util.Scanner;

public class AddBook implements IOOperation{

    @Override
    public void oper(Database database, User user) {
        Scanner s = new Scanner(System.in);
        Book book = new Book();

        System.out.print("Enter book name :");
        String name = s.next();
        if(database.getBook(name) > -1){
            System.out.println("There is a book with this name");
            user.menu(database, user);
        }else{
            book.setName(name);
        }

        System.out.print("Enter book author :");
        book.setAuthor(s.next());

        System.out.print("Enter book publisher :");
        book.setPublisher(s.next());

        System.out.print("Enter book collection address :");
        book.setAddress(s.next());

        System.out.print("Enter qty :");
        book.setQty(s.nextInt());

        System.out.print("Enter price :");
        book.setPrice(s.nextDouble());

        System.out.print("Enter borrowing copies :");
        book.setBrwcopies(s.nextInt());

        database.addBook(book);

        System.out.println("Book added successfully...");

        user.menu(database, user);

    }
}
