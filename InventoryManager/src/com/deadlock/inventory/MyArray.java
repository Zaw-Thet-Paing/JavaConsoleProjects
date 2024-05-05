package com.deadlock.inventory;

public class MyArray {
    private Object[] arr;
    private int itemCount;

    public MyArray(int size){
        arr = new Object[size];
        itemCount = 0;
    }

    public int getItemCount(){
        return itemCount;
    }

    public void add(Object data){
        if(itemCount < arr.length){
            arr[itemCount] = data;
            itemCount++;
        }else{
            System.out.println("Error: Array index out of bound");
        }
    }

    public Object get(int index){
        if(index >= 0 && index < itemCount){
            return arr[index];
        }
        return null;
    }

    public boolean isEmpty(){
        return itemCount == 0;
    }

    public void update(int index, Object newData){
        if(index >= 0 && index < itemCount){
            arr[index] = newData;
        }else{
            System.out.println("Error: Array index not found");
        }
    }

    public void remove(int index){
        if(index >= 0 && index < itemCount){
            for(int i = index; i<itemCount; i++){
                arr[i] = arr[i+1];
            }
            itemCount--;
        }else{
            System.out.println("Error: Array index not found");
        }
    }

}
