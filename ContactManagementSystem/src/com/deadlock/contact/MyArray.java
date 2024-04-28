package com.deadlock.contact;
public class MyArray {
    private int itemCount;
    private Object[] arr;

    public MyArray(int size){
        arr = new Object[size];
        itemCount = 0;
    }

    public void add(Object data){
        if(arr.length > itemCount){
            arr[itemCount] = data;
            itemCount++;
        }else{
            System.out.println("Array index out of bound! You cannot add new item");
        }
    }

    public Object get(int index){
        if(index >= 0 && index < itemCount){
            return arr[index];
        }
        return null;
    }

    public int getItemCount(){
        return itemCount;
    }

    public boolean isEmpty(){
        if(itemCount == 0){
            return true;
        }
        return false;
    }

    public void remove(int index){
        if(index >= 0 && index < itemCount){
            for(int i = index; i<itemCount; i++){
                arr[i] = arr[i+1];
            }
            itemCount--;
        }else{
            System.out.println("Index not found! Cannot remove item");
        }
    }

    public void update(int index, Object data){
        if(index >= 0 && index < itemCount){
            arr[index] = data;
        }else{
            System.out.println("Index not found! Cannot update item");
        }
    }



}
