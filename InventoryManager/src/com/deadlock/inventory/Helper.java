package com.deadlock.inventory;
public class Helper {
    public void banner(String text){
        printStar(text.length());
        System.out.println(text);
        printStar(text.length());
    }

    private void printStar(int count){
        for(int i = 0; i<count; i++){
            System.out.print("*");
        }
        System.out.println();
    }
}
