package com.deadlock.contact;
public abstract class Contact {
    private String name;
    private ContactType type;
    public Contact(String name, ContactType type){
        this.name = name;
        this.type = type;
    }

    public String getName(){
        return name;
    }

    public ContactType getType() {
        return type;
    }

    public abstract void displayContacts();

}
