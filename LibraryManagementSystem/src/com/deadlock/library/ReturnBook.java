package com.deadlock.library;

import java.util.Scanner;

public class ReturnBook implements IOOperation{
    @Override
    public void oper(Database database, User user) {
        System.out.print("Enter book name :");
        Scanner s = new Scanner(System.in);
        String bookName = s.next();
        if(!database.getBrws().isEmpty()){
            for(Borrowing b: database.getBrws()){
                if(b.getBook().getName().matches(bookName) && b.getUser().getName().matches(user.getName())){
                    Book book = b.getBook();
                    int i = database.getAllBooks().indexOf(book);
                    if(b.getDaysLeft() < 0){
                        System.out.println("You are late!");
                        System.out.println("You have to pay " + Math.abs(b.getDaysLeft()*50) + " as fine");
                    }
                    book.setBrwcopies(book.getBrwcopies() + 1);
                    database.returnBook(b, book, i);
                    System.out.println("Book returned\n Thank you!");
                    break;
                }else{
                    System.out.println("You didn't borrow this book");
                }
            }
        }else{
            System.out.println("You didn't borrow this book!");
        }
        user.menu(database, user);
    }
}
