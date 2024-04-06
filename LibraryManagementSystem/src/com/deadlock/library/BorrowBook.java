package com.deadlock.library;

import java.util.Scanner;

public class BorrowBook implements IOOperation{
    @Override
    public void oper(Database database, User user) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter book name :");
        String bookName = s.next();

        int i = database.getBook(bookName);

        if(i > -1){
            Book book = database.getBook(i);

            boolean n = true;

            for(Borrowing b: database.getBrws()){
                if(b.getBook().getName().matches(bookName) && b.getUser().getName().matches(user.getName())){
                    n = false;
                    System.out.println("You have borrowed this book before!");
                }
            }

            if(n){
                if(book.getBrwcopies() > 1){
                    Borrowing borrowing = new Borrowing(book, user);
                    book.setBrwcopies(book.getBrwcopies()-1);
                    database.borrowBook(borrowing, book, i);
                    System.out.println("You must return the book before 14 days from now\n");
                    System.out.println("Expiry date: " + borrowing.getFinish());
                    System.out.println("Enjoy!");
                }else{
                    System.out.println("This book isn't available for borrowing\n");
                }
            }

        }else{
            System.out.println("Book doesn't exist!\n");
        }
        user.menu(database, user);
    }
}
