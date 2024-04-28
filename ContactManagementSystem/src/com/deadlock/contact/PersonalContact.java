package com.deadlock.contact;
public class PersonalContact extends Contact{

    private String phoneNumber;

    public PersonalContact(String name, String phoneNumber){
        super(name, ContactType.PERSONAL);
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    @Override
    public void displayContacts() {
        System.out.println("=================================");
        System.out.println("Name : " + getName());
        System.out.println("Phone Number : " + getPhoneNumber());
        System.out.println("Contact Type : " + getType());
        System.out.println("=================================");
    }
}
