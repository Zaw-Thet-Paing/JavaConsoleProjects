package com.deadlock.contact;
public class BusinessContact extends Contact {

    private String email;

    public BusinessContact(String name, String email){
        super(name, ContactType.BUSINESS);
        this.email = email;
    }

    public String getEmail(){
        return email;
    }

    @Override
    public void displayContacts() {
        System.out.println("=================================");
        System.out.println("Name : " + getName());
        System.out.println("Email : " + getEmail());
        System.out.println("Contact Type " + getType());
        System.out.println("=================================");
    }
}
